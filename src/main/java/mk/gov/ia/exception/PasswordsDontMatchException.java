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
public class PasswordsDontMatchException extends Exception {

    /**
     * Creates a new instance of <code>PasswordsDontMatch</code> without detail
     * message.
     */
    public PasswordsDontMatchException() {
    }

    /**
     * Constructs an instance of <code>PasswordsDontMatch</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PasswordsDontMatchException(String msg) {
        super(msg);
    }
}
