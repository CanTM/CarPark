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
                String operation = br.readLine();
                System.out.println("operation: " + operation);
                switch(operation){
                    case "ENTER CAR":
                    case "ENTER TRUCK":
                        String enter = br.readLine();
                        StringTokenizer st1 = new StringTokenizer(enter, " ");
                        String vehicle1 = st1.nextToken();
                        facade.enterVehicle(vehicle1);
                        break;
                    case "EXIT CAR":
                    case "EXIT TRUCK":
                        String exit = br.readLine();
                        StringTokenizer st2 = new StringTokenizer(exit, " ");
                        String vehicle2 = st2.nextToken();
                        String time = st2.nextToken();
                        int hours = parseInt(time);
                        facade.exitVehicle(vehicle2, hours);
                        break;
                    case "REPORT":
                        facade.getReport();
                        break;
                    case "QUIT":
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
