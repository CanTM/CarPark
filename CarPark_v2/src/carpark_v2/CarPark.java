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
public class CarPark {
    //vehicle counters
    private int carsIn;
    private int carsOut;
    private int parkedCars;
    private int trucksIn;
    private int trucksOut;  
    private int parkedTrucks;
    
    //spaces
    private final int totalSpaces;
    private int freeSpaces;
    
    //fees
    private final int carFee;
    private final int truckFee;
    private int totalPaidFees;

    //contructor
    public CarPark(int totalSpaces) {
        this.carsIn = 0;
        this.carsOut = 0;
        this.parkedCars = 0;
        this.trucksIn = 0;
        this.trucksOut = 0;
        this.parkedTrucks = 0;
        this.totalSpaces = totalSpaces;
        this.freeSpaces = totalSpaces;
        this.carFee = 2;
        this.truckFee = 3;
        this.totalPaidFees = 0;
    }

    //getters and setters
    public void setCarsIn(int carsIn) {
        this.carsIn = carsIn;
    }

    public void setCarsOut(int carsOut) {
        this.carsOut = carsOut;
    }

    public void setParkedCars(int parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void setTrucksIn(int trucksIn) {
        this.trucksIn = trucksIn;
    }

    public void setTrucksOut(int trucksOut) {
        this.trucksOut = trucksOut;
    }

    public void setParkedTrucks(int parkedTrucks) {
        this.parkedTrucks = parkedTrucks;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public void setTotalPaidFees(int totalPaidFees) {
        this.totalPaidFees = totalPaidFees;
    }

    public int getCarsIn() {
        return carsIn;
    }

    public int getCarsOut() {
        return carsOut;
    }

    public int getParkedCars() {
        return parkedCars;
    }

    public int getTrucksIn() {
        return trucksIn;
    }

    public int getTrucksOut() {
        return trucksOut;
    }

    public int getParkedTrucks() {
        return parkedTrucks;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public int getCarFee() {
        return carFee;
    }

    public int getTruckFee() {
        return truckFee;
    }

    public int getTotalPaidFees() {
        return totalPaidFees;
    }  
}
