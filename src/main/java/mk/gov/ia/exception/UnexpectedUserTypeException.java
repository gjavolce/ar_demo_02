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
public class UnexpectedUserTypeException extends Exception {

    /**
     * Creates a new instance of <code>UnexpectedUserStatusException</code>
     * without detail message.
     */
    public UnexpectedUserTypeException() {
    }

    /**
     * Constructs an instance of <code>UnexpectedUserStatusException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public UnexpectedUserTypeException(String msg) {
        super(msg);
    }
}
