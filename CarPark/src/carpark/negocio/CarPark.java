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
public class CarPark {

    private final int spaces;
    public final int carFee = 2;
    public final int truckFee = 3;
    private int freeSpaces;

    public CarPark(int spaces) {
        this.spaces = spaces;
        this.freeSpaces = spaces;
    }

    public int getSpaces() {
        return spaces;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

}
