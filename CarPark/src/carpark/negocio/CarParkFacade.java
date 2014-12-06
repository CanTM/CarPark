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

    public void initCarPark(int totalSpaces) {
        carPark = new CarPark(totalSpaces);
    }

    public void enterVehicle(String vehicle) throws CarParkDAOException {
        if(vehicle.equals(Vehicle.CAR.name())){
            carPark.setFreeSpaces(carPark.getFreeSpaces() - 1);
        }
        else if(vehicle.equals(Vehicle.TRUCK.name())){
            carPark.setFreeSpaces(carPark.getFreeSpaces() - 2);
        }
        else{
            System.out.println("This is not a valid vehicle");
            return;
        }
        carParkDaoDerby.enterVehicle(vehicle);
    }
    
    public void exitVehicle(String vehicle, int hours) throws CarParkDAOException{
        int fee;
        if(vehicle.equals(Vehicle.CAR.name())){
            fee = carPark.carFee;
            carPark.setFreeSpaces(carPark.getFreeSpaces() + 1);
        }
        else if(vehicle.equals(Vehicle.TRUCK.name())){
            fee = carPark.truckFee;
            carPark.setFreeSpaces(carPark.getFreeSpaces() + 2);
        }
        else{
            System.out.println("This is not a valid vehicle");
            return;
        }
        int totalFee = fee*hours;
        carParkDaoDerby.exitVehicle(vehicle, totalFee);
    }
    
    public String getReport() throws CarParkDAOException{
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
