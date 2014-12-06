/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 *
 * @author CanTM
 */
public class CarParkMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarParkFacade facade = new CarParkFacade();
        boolean running = true;

        System.out.println("How many spaces does the car park have?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String userImput = br.readLine();
            int totalSpaces = parseInt(userImput);
            facade.initCarPark(totalSpaces);
        } catch (IOException ex) {
            System.out.println("Could not initialize Car Park");
        }

        while (running == true) {
            try {
                System.out.println("");
                System.out.println("1 - ENTER VEHICLE");
                System.out.println("2 - EXIT VEHICLE");
                System.out.println("3 - REPORT");
                System.out.println("4 - QUIT");
                System.out.println("");
                String operation = br.readLine();
                switch (operation) {
                    case "1":
                        System.out.println("Choose a vehicle to enter:");
                        System.out.println("1 - CAR");
                        System.out.println("2 - TRUCK");
                        System.out.println("");
                        String enter = br.readLine();
                        if (enter.equals("1")) {
                            facade.enterVehicle(Vehicle.CAR);
                        } else if (enter.equals("2")) {
                            facade.enterVehicle(Vehicle.TRUCK);
                        } else {
                            System.out.println("This is not a valid option");
                        }
                        break;
                    case "2":
                        System.out.println("Choose a vehicle to exit:");
                        System.out.println("1 - CAR");
                        System.out.println("2 - TRUCK");
                        System.out.println("");
                        String exit = br.readLine();
                        System.out.println("HOURS INSIDE CAR PARK: ");
                        String time = br.readLine();
                        int hours = parseInt(time);
                        if (exit.equals("1")) {
                            facade.exitVehicle(Vehicle.CAR, hours);
                        } else if (exit.equals("2")) {
                            facade.exitVehicle(Vehicle.TRUCK, hours);
                        } else {
                            System.out.println("This is not a valid option");
                        }
                        break;
                    case "3":
                        System.out.println("");
                        facade.getReport();
                        System.out.println("");
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("This is not a valid option");
                }
            } catch (IOException ex) {
                System.out.println("Your option could not be read");
            }
        }
    }
    
}