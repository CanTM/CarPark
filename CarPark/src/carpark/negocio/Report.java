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
public class Report {

    private int CarsEntered;
    private int TrucksEntered;
    private int CarsExited;
    private int TrucksExited;
    private int ParkingCars;
    private int ParkingTrucks;
    private int Spacesavailable;
    private int Feespaid;

    public int getCarsEntered() {
        return CarsEntered;
    }

    public void setCarsEntered(int CarsEntered) {
        this.CarsEntered = CarsEntered;
    }

    public int getTrucksEntered() {
        return TrucksEntered;
    }

    public void setTrucksEntered(int TrucksEntered) {
        this.TrucksEntered = TrucksEntered;
    }

    public int getCarsExited() {
        return CarsExited;
    }

    public void setCarsExited(int CarsExited) {
        this.CarsExited = CarsExited;
    }

    public int getTrucksExited() {
        return TrucksExited;
    }

    public void setTrucksExited(int TrucksExited) {
        this.TrucksExited = TrucksExited;
    }

    public int getParkingCars() {
        return ParkingCars;
    }

    public void setParkingCars(int ParkingCars) {
        this.ParkingCars = ParkingCars;
    }

    public int getParkingTrucks() {
        return ParkingTrucks;
    }

    public void setParkingTrucks(int ParkingTrucks) {
        this.ParkingTrucks = ParkingTrucks;
    }

    public int getSpacesavailable() {
        return Spacesavailable;
    }

    public void setSpacesavailable(int Spacesavailable) {
        this.Spacesavailable = Spacesavailable;
    }

    public int getFeespaid() {
        return Feespaid;
    }

    public void setFeespaid(int Feespaid) {
        this.Feespaid = Feespaid;
    }

    @Override
    public String toString() {
        return " Cars Entered: " + CarsEntered
                + "\n Trucks Entered: " + TrucksEntered
                + "\n Cars Exited: " + CarsExited
                + "\n Trucks Exited: " + TrucksExited
                + "\n Parking Cars: " + ParkingCars
                + "\n Parking Trucks: " + ParkingTrucks
                + "\n Spaces Available: " + Spacesavailable
                + "\n Fees Paid: " + Feespaid;
    }

}
