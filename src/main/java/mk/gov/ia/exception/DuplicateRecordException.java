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
public class DuplicateRecordException extends Exception {

    /**
     * Creates a new instance of <code>DataStoreIntegrityException</code>
     * without detail message.
     */
    public DuplicateRecordException() {
    }

    /**
     * Constructs an instance of <code>DataStoreIntegrityException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DuplicateRecordException(String msg) {
        super(msg);
    }
}
