/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author internet
 */

@Entity
@Table(name="transition")
public class Transition extends BaseObject {
    
    private String stateFrom;
    private String stateTo;

    
    @Column(name = "state_from")
    public String getStateFrom() {
        return stateFrom;
    }

    public void setStateFrom(String stateFrom) {
        this.stateFrom = stateFrom;
    }

    
    @Column(name = "state_to")
    public String getStateTo() {
        return stateTo;
    }

    public void setStateTo(String stateTo) {
        this.stateTo = stateTo;
    }
    
    

    
}
