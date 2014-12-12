/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark.apresentacao;

import carpark.negocio.CarParkDAOException;
import carpark.negocio.CarParkFacade;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;//lindo codigo
import static java.lang.Integer.parseInt;

/**
 *
 * @author CanTM
 */
public class CarParkInterface {

    /**
     * @param args the command line arguments
     * @throws carpark.negocio.CarParkDAOException
     */
    public static void main(String[] args) throws CarParkDAOException {

        CarParkFacade facade = new CarParkFacade();
        boolean running1 = true;
        boolean running2 = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (running1) {
            System.out.println("How many spaces does the car park have?");
            try {
                String userInput = br.readLine();
                if (userInput.matches("^[0-9]+$")) {
                    int totalSpaces = parseInt(userInput);
                    facade.initCarPark(totalSpaces);
                    running1 = false;
                } else {
                    System.out.println("Please enter a positive number");
                }
            } catch (IOException ex) {
                System.out.println("Could not initialize Car Park");
            }
        }
        while (running2 == true) {
            try {
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
                            facade.enterVehicle("CAR");
                        } else if (enter.equals("2")) {
                            facade.enterVehicle("TRUCK");
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
                        boolean testHours = true;
                        while (testHours) {
                            System.out.println("");
                            System.out.println("HOURS INSIDE CAR PARK: ");
                            String time = br.readLine();
                            int hours;
                            if (time.matches("^[0-9]+$")) {
                                hours = parseInt(time);
                                testHours = false;
                                if (exit.equals("1")) {
                                    facade.exitVehicle("CAR", hours);
                                } else if (exit.equals("2")) {
                                    facade.exitVehicle("TRUCK", hours);
                                } else {
                                    System.out.println("This is not a valid option");
                                }
                            } else {
                                System.out.println("Please enter a valid positive number");
                            }
                        }
                        break;
                    case "3":
                        System.out.println("");
                        System.out.println(facade.getReport());
                        System.out.println("");
                        break;
                    case "4":
                        running2 = false;
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
