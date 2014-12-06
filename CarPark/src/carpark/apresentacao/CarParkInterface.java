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
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CanTM
 */
public class CarParkInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CarParkDAOException {
        CarParkFacade facade = new CarParkFacade();
        boolean running = true;
        
        System.out.println("How many spaces does the car park have?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String userImput = br.readLine();
            int totalSpaces = parseInt(userImput);
            facade.initCarPark(totalSpaces);
        } catch (IOException ex) {
            System.out.println("Não foi possível inicializar CarPark");
        }
        
        while(running == true){
            try{
                System.out.println("1 - ENTER VEHICLE");
                System.out.println("2 - EXIT VEHICLE");
                System.out.println("3 - REPORT");
                System.out.println("4 - QUIT");
                String operation = br.readLine();
                switch(operation){
                    case "1":
                        System.out.println("1 - CAR");
                        System.out.println("2 - TRUCK");
                        String enter = br.readLine();
                        if(enter.equals("1")){
                            facade.enterVehicle("CAR");
                        }
                        else if(enter.equals("2")){
                            facade.enterVehicle("TRUCK");
                        }
                        else{
                            System.out.println("This is not a valid option");
                        }
                        break;
                    case "2":
                        System.out.println("1 - CAR");
                        System.out.println("2 - TRUCK");
                        String exit = br.readLine();
                        System.out.println("HOURS INSIDE CAR PARK: ");
                        String time = br.readLine();
                        int hours = parseInt(time);
                        if(exit.equals("1")){
                            facade.exitVehicle("CAR", hours);
                        }
                        else if(exit.equals("2")){
                            facade.exitVehicle("TRUCK", hours);
                        }
                        else{
                            System.out.println("This is not a valid option");
                        }   
                        break;
                    case "3":
                        System.out.println(facade.getReport());
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("This is not a valid option");
                }
            } catch (IOException ex) {
                System.out.println("Não foi possível ler a sua opção");
            }
        }
    }
    
}
