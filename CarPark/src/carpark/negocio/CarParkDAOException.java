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
public class CarParkDAOException extends Exception {

    public CarParkDAOException() {
        super();
    }

    public CarParkDAOException(String mensagem) {
        super(mensagem);
    }

    public CarParkDAOException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
