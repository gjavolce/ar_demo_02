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
public class DiscountVoucherAlreadyExistsException extends Exception {

    /**
     * Creates a new instance of <code>UserAlreadyExistsException</code> without
     * detail message.
     */
    public DiscountVoucherAlreadyExistsException() {
    }

    /**
     * Constructs an instance of <code>UserAlreadyExistsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DiscountVoucherAlreadyExistsException(String msg) {
        super(msg);
    }
}
