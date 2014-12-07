/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark_v2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CanTM
 */
public class CarParkFacadeTest {
    
    public CarParkFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initCarPark method, of class CarParkFacade.
     */
    @Test
    public void testInitCarParkValid() {
        System.out.println("initCarPark - valid");
        int totalSpaces = 10;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        assertEquals(instance.getCp().getTotalSpaces(), totalSpaces);
        assertEquals(instance.getCp().getFreeSpaces(), totalSpaces);
    }

    @Test
    public void testInitCarParkInvalid() {
        System.out.println("initCarPark - invalid");
        int totalSpaces = -10;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        assert(instance.getCp() == null);
    }
    
    /**
     * Test of enterVehicle method, of class CarParkFacade.
     */
    @Test
    public void testEnterVehicleValidCar() {
        System.out.println("enter car - valid");
        int totalSpaces = 10;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle car = Vehicle.CAR;
        instance.enterVehicle(car);
        assertEquals(instance.getCp().getCarsIn(),1);
        assertEquals(instance.getCp().getParkedCars(),1);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces()-1);
    }
    
    @Test
    public void testEnterVehicleValidTruck() {
        System.out.println("enter truck - valid");
        int totalSpaces = 10;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle truck = Vehicle.TRUCK;
        instance.enterVehicle(truck);
        assertEquals(instance.getCp().getTrucksIn(),1);
        assertEquals(instance.getCp().getParkedTrucks(),1);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces()-2);
    }
    
    @Test
    public void testEnterVehicleInvalidCar() {
        System.out.println("enter car - invalid");
        int totalSpaces = 1;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle car = Vehicle.CAR;
        instance.enterVehicle(car);
        instance.enterVehicle(car);
        assertEquals(instance.getCp().getCarsIn(),1);
        assertEquals(instance.getCp().getParkedCars(),1);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces()-1);
    }
    
    @Test
    public void testEnterVehicleInvalidTruck() {
        System.out.println("enter truck - invalid");
        int totalSpaces = 3;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle truck = Vehicle.TRUCK;
        instance.enterVehicle(truck);
        instance.enterVehicle(truck);
        assertEquals(instance.getCp().getTrucksIn(),1);
        assertEquals(instance.getCp().getParkedTrucks(),1);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces()-2);
    }

    /**
     * Test of exitVehicle method, of class CarParkFacade.
     */
    @Test
    public void testExitCarValid() {
        System.out.println("exit car - valid");
        int totalSpaces = 10;
        int hours = 2;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle car = Vehicle.CAR;
        instance.enterVehicle(car);
        instance.exitVehicle(car, hours);
        assertEquals(instance.getCp().getCarsIn(),1);
        assertEquals(instance.getCp().getCarsOut(),1);
        assertEquals(instance.getCp().getParkedCars(),0);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces());
        assertEquals(instance.getCp().getTotalPaidFees(),4);
    }
    
    @Test
    public void testExitCarInvalid() {
        System.out.println("exit car - invalid");
        int totalSpaces = 10;
        int hours = 2;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle car = Vehicle.CAR;
        instance.exitVehicle(car, hours);
        assertEquals(instance.getCp().getCarsIn(),0);
        assertEquals(instance.getCp().getCarsOut(),0);
        assertEquals(instance.getCp().getParkedCars(),0);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces());
        assertEquals(instance.getCp().getTotalPaidFees(),0);
    }

    @Test
    public void testExitCarInvalidHours() {
        System.out.println("exit car - invalid hours");
        int totalSpaces = 10;
        int hours = 0;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle car = Vehicle.CAR;
        instance.enterVehicle(car);
        instance.exitVehicle(car, hours);
        assertEquals(instance.getCp().getCarsIn(),1);
        assertEquals(instance.getCp().getCarsOut(),0);
        assertEquals(instance.getCp().getParkedCars(),1);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces()-1);
        assertEquals(instance.getCp().getTotalPaidFees(),0);
    }
    
    @Test
    public void testExitTruckValid() {
        System.out.println("exit truck - valid");
        int totalSpaces = 10;
        int hours = 2;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle truck = Vehicle.TRUCK;
        instance.enterVehicle(truck);
        instance.exitVehicle(truck, hours);
        assertEquals(instance.getCp().getTrucksIn(),1);
        assertEquals(instance.getCp().getTrucksOut(),1);
        assertEquals(instance.getCp().getParkedTrucks(),0);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces());
        assertEquals(instance.getCp().getTotalPaidFees(),6);
    }
    
    @Test
    public void testExitTruckInvalid() {
        System.out.println("exit truck - invalid");
        int totalSpaces = 10;
        int hours = 2;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle truck = Vehicle.TRUCK;
        instance.exitVehicle(truck, hours);
        assertEquals(instance.getCp().getTrucksIn(),0);
        assertEquals(instance.getCp().getTrucksOut(),0);
        assertEquals(instance.getCp().getParkedTrucks(),0);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces());
        assertEquals(instance.getCp().getTotalPaidFees(),0);
    }

    @Test
    public void testExitTruckInvalidHours() {
        System.out.println("exit truck - invalid hours");
        int totalSpaces = 10;
        int hours = 0;
        CarParkFacade instance = new CarParkFacade();
        instance.initCarPark(totalSpaces);
        Vehicle truck = Vehicle.TRUCK;
        instance.enterVehicle(truck);
        instance.exitVehicle(truck, hours);
        assertEquals(instance.getCp().getTrucksIn(),1);
        assertEquals(instance.getCp().getTrucksOut(),0);
        assertEquals(instance.getCp().getParkedTrucks(),1);
        assertEquals(instance.getCp().getFreeSpaces(),instance.getCp().getTotalSpaces()-2);
        assertEquals(instance.getCp().getTotalPaidFees(),0);
    }

}
