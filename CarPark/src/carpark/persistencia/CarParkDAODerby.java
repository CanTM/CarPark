/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark.persistencia;

import carpark.negocio.CarParkDAO;
import carpark.negocio.CarParkDAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CanTM
 */
public class CarParkDAODerby implements CarParkDAO {

    @Override
    public void enterVehicle(String vehicle) throws CarParkDAOException {
        String sql = "insert into parkedcars(VEHICLE,INSIDE) values(?,?)";
        int resultado = 0;
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command = conexao.prepareStatement(sql)) {
                command.setString(1, vehicle);
                command.setBoolean(2, true);
                resultado = command.executeUpdate();
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in connectiong DB", e);
        }
        if (resultado == 0) {
            throw new CarParkDAOException("Fail in inserting vehicle");
        }
    }

    @Override
    public void exitVehicle(String vehicle, int fee) throws CarParkDAOException {
        int id = 0;
        String sql1 = "select * from parkedcars where INSIDE = ? and VEHICLE = ?";
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command1 = conexao.prepareStatement(sql1)) {
                command1.setBoolean(1, true);
                command1.setString(2, vehicle);
                try (ResultSet result = command1.executeQuery()) {
                    if (result.next()) {
                        id = result.getInt("ID");
                    }
                }
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in search a parked vahicle", e);
        }
        String sql2 = "update parkedcars set INSIDE = ? where ID = ?";
        String sql3 = "update parkedcars set FEE = ? where ID = ?";
        int resultado1 = 0;
        int resultado2 = 0;
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command2 = conexao.prepareStatement(sql2)) {
                command2.setBoolean(1, false);
                command2.setInt(2, id);
                resultado1 = command2.executeUpdate();
            }
            try (PreparedStatement command3 = conexao.prepareStatement(sql3)) {
                command3.setInt(1, fee);
                command3.setInt(2, id);
                resultado2 = command3.executeUpdate();
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in update exiting vehicle", e);
        }
        if (resultado1 == 0 || resultado2 == 0) {
            throw new CarParkDAOException("Fail in executing command");
        }
    }

    @Override
    public int getParkedVehiclesNumber(String vehicle) throws CarParkDAOException {
        String sql = "select * from parkedcars where INSIDE = ? and VEHICLE = ?";
        int parkedCars = 0;
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command = conexao.prepareStatement(sql)) {
                command.setBoolean(1, true);
                command.setString(2, vehicle);
                try (ResultSet resultado = command.executeQuery()) {
                    while (resultado.next()) {
                        parkedCars++;
                    }
                    return parkedCars;
                }
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in searching number of parked cars", e);
        }
    }

    @Override
    public int getTotalNumberOfVehiclesThatEntered(String vehicle) throws CarParkDAOException {
        String sql = "select * from parkedcars where VEHICLE = ?";
        int totalEnteredCars = 0;
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command = conexao.prepareStatement(sql)) {
                command.setString(1, vehicle);
                try (ResultSet resultado = command.executeQuery()) {
                    while (resultado.next()) {
                        totalEnteredCars++;
                    }
                    return totalEnteredCars;
                }
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in searching total number of entered cars", e);
        }
    }

    @Override
    public int getTotalNumberOfVehiclesThatExited(String vehicle) throws CarParkDAOException {
        String sql = "select * from parkedcars where INSIDE = ? and VEHICLE = ?";
        int exitedCars = 0;
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command = conexao.prepareStatement(sql)) {
                command.setBoolean(1, false);
                command.setString(2, vehicle);
                try (ResultSet resultado = command.executeQuery()) {
                    while (resultado.next()) {
                        exitedCars++;
                    }
                    return exitedCars;
                }
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in searching number of exited cars", e);
        }
    }

    @Override
    public int getTotalFee() throws CarParkDAOException {
        String sql = "select * from parkedcars where INSIDE = ?";
        int totalFee = 0;
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command = conexao.prepareStatement(sql)) {
                command.setBoolean(1, false);
                try (ResultSet resultado = command.executeQuery()) {
                    while (resultado.next()) {
                        totalFee = totalFee + resultado.getInt("FEE");
                    }
                    return totalFee;
                }
            }
        } catch (Exception e) {
            throw new CarParkDAOException("Fail in calculating total fee", e);
        }
    }

    public void cleanDB() throws CarParkDAOException {
        String sql1 = "select * from parkedcars";
        try (Connection conexao = DBInitializer.conectarBd()) {
            try (PreparedStatement command = conexao.prepareStatement(sql1)) {
                try (ResultSet resultado = command.executeQuery()) {
                    while (resultado.next()) {
                        String sql2 = "delete from parkedcars where ID = ?";
                        try (PreparedStatement command1 = conexao.prepareStatement(sql2)) {
                            command1.setInt(1, resultado.getInt("ID"));
                            command1.execute();
                        }
                    }
                }

            }

        } catch (Exception e) {
            throw new CarParkDAOException("Fail in cleaning DB", e);
        }
    }
}
