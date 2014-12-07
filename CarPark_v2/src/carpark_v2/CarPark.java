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
    /*@
    @ requires totalSpaces != null && totalSpaces > 0;
    @ ensures getTotalSpaces() == totalSpaces && getFreeSpaces() == totalSpaces;
    @ ensures getCarsIn() == 0;
    @ ensures getCarsOut() == 0;
    @ ensures getParkedCars() == 0;
    @ ensures getTrucksIn() == 0;
    @ ensures getTrucksOut() == 0;
    @ ensures getParkesTrucks() == 0;
    @ ensures getCarFee() == 2;
    @ ensures getTruckFee() == 3;
    @ ensures getTotalPaidFees() == 0;
    @*/
    public CarPark(int totalSpaces) {
        this.totalSpaces = totalSpaces;
        this.freeSpaces = totalSpaces;
        this.carsIn = 0;
        this.carsOut = 0;
        this.parkedCars = 0;
        this.trucksIn = 0;
        this.trucksOut = 0;
        this.parkedTrucks = 0;
        this.carFee = 2;
        this.truckFee = 3;
        this.totalPaidFees = 0;
    }

    //getters and setters
    /*@
    @ requires carsIn >=0;
    @ ensures getCarsIn() == carsIn;
    */
    public void setCarsIn(int carsIn) {
        this.carsIn = carsIn;
    }

    /*@
    @ requires carsOut >= 0;
    @ ensures getCarsOut() == carsOut;
    */
    public void setCarsOut(int carsOut) {
        this.carsOut = carsOut;
    }

    /*@
    @ requires parkedCars >= 0 && parkedCars <= (getTotalSpaces() - (getParkedTrucks()*2));
    @ ensures getParkedCars() == parkedCars;
    */
    public void setParkedCars(int parkedCars) {
        this.parkedCars = parkedCars;
    }

    /*@
    @ requires trucksIn >=0;
    @ ensures getTrucksIn() == trucksIn;
    */
    public void setTrucksIn(int trucksIn) {
        this.trucksIn = trucksIn;
    }

    /*@
    @ requires trucksOut >= 0;
    @ ensures getTrucksOut() == trucksOut;
    */
    public void setTrucksOut(int trucksOut) {
        this.trucksOut = trucksOut;
    }

    /*@
    @ requires parkedTrucks >= 0 && parkedTrucks*2 <= (getTotalSpaces() - (getParkedCars());
    @ ensures getParkedCars() == parkedCars;
    */
    public void setParkedTrucks(int parkedTrucks) {
        this.parkedTrucks = parkedTrucks;
    }
    /*@
    @ requires freeSpaces >= 0 && freeSpaces <= (getTotalSpaces() - (getParkedCars() + (getParkedTrucks()*2)));
    @ ensures getFreeSpaces() == freeSpaces;
    */
    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }
    
    /*@
    @ requires totalPaidFees >= 0;
    @ ensures getTotalPaidFees() == totalPaidFees;
    */
    public void setTotalPaidFees(int totalPaidFees) {
        this.totalPaidFees = totalPaidFees;
    }

    //@ensures\result==carsIn;
    public /*@ pure @*/ int getCarsIn() {
        return carsIn;
    }
    
    //@ensures\result==carsOut;
    public /*@ pure @*/ int getCarsOut() {
        return carsOut;
    }

    //@ensures\result==parkedCars;
    public /*@ pure @*/ int getParkedCars() {
        return parkedCars;
    }

    //@ensures\result==trucksIn;
    public /*@ pure @*/ int getTrucksIn() {
        return trucksIn;
    }

    //@ensures\result==trucksOut;
    public /*@ pure @*/ int getTrucksOut() {
        return trucksOut;
    }

    //@ensures\result==parkedTrucks;
    public /*@ pure @*/ int getParkedTrucks() {
        return parkedTrucks;
    }

    //@ensures\result==totalSpaces;
    public /*@ pure @*/ int getTotalSpaces() {
        return totalSpaces;
    }
    
    //@ensures\result==freeSpaces;
    public /*@ pure @*/ int getFreeSpaces() {
        return freeSpaces;
    }

    //@ensures\result==carFee;
    public /*@ pure @*/ int getCarFee() {
        return carFee;
    }

    //@ensures\result==truckFee;
    public /*@ pure @*/ int getTruckFee() {
        return truckFee;
    }

    //@ensures\result==totalPaidFees;
    public /*@ pure @*/ int getTotalPaidFees() {
        return totalPaidFees;
    }  
}
