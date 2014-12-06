/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark.negocio;

import carpark.persistencia.CarParkDAODerby;

/**
 *
 * @author CanTM
 */
public class CarParkFacade {

    private CarPark carPark;
    private CarParkDAODerby carParkDaoDerby = new CarParkDAODerby();

    public void initCarPark(int totalSpaces) throws CarParkDAOException {
        carParkDaoDerby.cleanDB();
        carPark = new CarPark(totalSpaces);
    }

    public void enterVehicle(String vehicle) throws CarParkDAOException {
        if (vehicle.equals(Vehicle.CAR.name())) {
            if (carPark.getFreeSpaces() >= 1) {
                carParkDaoDerby.enterVehicle(vehicle);
                carPark.setFreeSpaces(carPark.getFreeSpaces() - 1);
            } else {
                System.out.println("There is no space for this vehicle");
            }
        } else if (vehicle.equals(Vehicle.TRUCK.name())) {
            if (carPark.getFreeSpaces() >= 2) {
                carParkDaoDerby.enterVehicle(vehicle);
                carPark.setFreeSpaces(carPark.getFreeSpaces() - 2);
            } else {
                System.out.println("There is no space for this vehicle");
            }
        } else {
            System.out.println("This is not a valid vehicle");
        }
    }

    public void exitVehicle(String vehicle, int hours) throws CarParkDAOException {
        int totalFee;
        if (vehicle.equals(Vehicle.CAR.name())) {
            if (carParkDaoDerby.getParkedVehiclesNumber(vehicle) > 0) {
                totalFee = carPark.carFee * hours;
                carParkDaoDerby.exitVehicle(vehicle, totalFee);
                carPark.setFreeSpaces(carPark.getFreeSpaces() + 1);
            } else {
                System.out.println("There is no such vehicle parked");
            }
        } else if (vehicle.equals(Vehicle.TRUCK.name())) {
            if (carParkDaoDerby.getParkedVehiclesNumber(vehicle) > 0) {
                totalFee = carPark.truckFee * hours;
                carParkDaoDerby.exitVehicle(vehicle, totalFee);
                carPark.setFreeSpaces(carPark.getFreeSpaces() + 2);
            } else {
                System.out.println("There is no such vehicle parked");
            }
        } else {
            System.out.println("This is not a valid vehicle");
        }
    }

    public String getReport() throws CarParkDAOException {
        Report report = new Report();
        report.setCarsEntered(carParkDaoDerby.getTotalNumberOfVehiclesThatEntered("CAR"));
        report.setCarsExited(carParkDaoDerby.getTotalNumberOfVehiclesThatExited("CAR"));
        report.setFeespaid(carParkDaoDerby.getTotalFee());
        report.setParkingCars(carParkDaoDerby.getParkedVehiclesNumber("CAR"));
        report.setParkingTrucks(carParkDaoDerby.getParkedVehiclesNumber("TRUCK"));
        report.setSpacesavailable(carPark.getFreeSpaces());
        report.setTrucksEntered(carParkDaoDerby.getTotalNumberOfVehiclesThatEntered("TRUCK"));
        report.setTrucksExited(carParkDaoDerby.getTotalNumberOfVehiclesThatExited("TRUCK"));
        return report.toString();
    }
}
