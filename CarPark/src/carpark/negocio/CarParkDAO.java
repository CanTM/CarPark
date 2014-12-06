/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark.negocio;

/**
 *
 * @author CanTM
 */
public interface CarParkDAO {

    public void enterVehicle(String vehicle) throws CarParkDAOException;

    public void exitVehicle(String vehicle, int fee) throws CarParkDAOException;

    public int getParkedVehiclesNumber(String vehicle) throws CarParkDAOException;

    public int getTotalNumberOfVehiclesThatEntered(String vehicle) throws CarParkDAOException;

    public int getTotalNumberOfVehiclesThatExited(String vehicle) throws CarParkDAOException;

    public int getTotalFee() throws CarParkDAOException;

    public void cleanDB() throws CarParkDAOException;
}
