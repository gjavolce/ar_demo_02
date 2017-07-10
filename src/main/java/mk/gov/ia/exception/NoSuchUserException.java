/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.exception;

/**
 *
 * @author expert
 */
public class NoSuchUserException extends NoSuchObjectException {

    /**
     * Creates a new instance of <code>NoSuchUserException</code> without detail
     * message.
     */
    public NoSuchUserException() {
    }

    /**
     * Constructs an instance of <code>NoSuchUserException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoSuchUserException(String msg) {
        super(msg);
    }
}
