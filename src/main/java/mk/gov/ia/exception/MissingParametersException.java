/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.exception;

/**
 *
 * @author gjoko.mitrovski
 */
public class MissingParametersException extends Exception {

    /**
     * Creates a new instance of <code>MissingParametersException</code> without detail
     * message.
     */
    public MissingParametersException() {
    }

    /**
     * Constructs an instance of <code>MissingParametersException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MissingParametersException(String msg) {
        super(msg);
    }
}
