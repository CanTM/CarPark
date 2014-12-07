/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark_v2;

/**
 *
 * @author CanTM
 */
public class CarParkFacade {
    
    private CarPark cp;
    
    public void initCarPark(int totalSpaces) {
        if(totalSpaces > 0){
            cp = new CarPark(totalSpaces);
        }
        else{
            System.out.println("Please enter a number greater than zero");
        }
    }

    public void enterVehicle(Vehicle vehicle) {
        if(vehicle.equals(Vehicle.CAR)){
            if(cp.getFreeSpaces() > 0){
                cp.setCarsIn(cp.getCarsIn() + 1);
                cp.setParkedCars(cp.getParkedCars() + 1);
                cp.setFreeSpaces(cp.getFreeSpaces() - 1);
            }
            else{
                System.out.println("There is no space for this vehicle");
            }
        }
        else if(vehicle.equals(Vehicle.TRUCK)){
            if(cp.getFreeSpaces() > 1){
                cp.setTrucksIn(cp.getTrucksIn() + 1);
                cp.setParkedTrucks(cp.getParkedTrucks() + 1);
                cp.setFreeSpaces(cp.getFreeSpaces() - 2);
            }
            else{
                System.out.println("There is no space for this vehicle");
            }
        }
        else{
            System.out.println("This is not a valid vehicle");
        }
    }

    void exitVehicle(Vehicle vehicle, int hours) {
        if(vehicle.equals(Vehicle.CAR)){
            if(cp.getParkedCars() > 0){
                cp.setCarsOut(cp.getCarsOut() + 1);
                cp.setParkedCars(cp.getParkedCars() - 1);
                cp.setFreeSpaces(cp.getFreeSpaces() + 1);
                cp.setTotalPaidFees(cp.getTotalPaidFees() + (cp.getCarFee()*hours));
            }
            else{
                System.out.println("There is no car parked");
            }
        }
        else if(vehicle.equals(Vehicle.TRUCK)){
            if(cp.getParkedTrucks() > 0){
                cp.setTrucksOut(cp.getTrucksOut() + 1);
                cp.setParkedTrucks(cp.getParkedTrucks() - 1);
                cp.setFreeSpaces(cp.getFreeSpaces() + 2);
                cp.setTotalPaidFees(cp.getTotalPaidFees() + (cp.getTruckFee()*hours));
            }
            else{
                System.out.println("There is no truck parked");
            }
        }
        else{
            System.out.println("This is not a valid vehicle");
        }
    }

    public String getReport() {
        String report = "Cars Entered: " + cp.getCarsIn() 
                + "\nTrucks Entered: " + cp.getTrucksIn() 
                + "\nCars Exited: " + cp.getCarsOut() 
                + "\nTrucks Exited: " + cp.getTrucksOut() 
                + "\nParking Cars: " + cp.getParkedCars() 
                + "\nParking Trucks: " + cp.getParkedTrucks() 
                + "\nSpaces available: " + cp.getFreeSpaces() 
                + "\nFees paid: " + cp.getTotalPaidFees();
        return report;
    }
}
