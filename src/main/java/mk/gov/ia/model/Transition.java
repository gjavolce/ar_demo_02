/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author internet
 */

@Entity
@Table(name="transition")
public class Transition extends BaseObject {
    
    private State stateFrom;
    private State stateTo;

    @OneToOne
    @JoinColumn(name = "state_from")
    public State getStateFrom() {
        return stateFrom;
    }

    public void setStateFrom(State stateFrom) {
        this.stateFrom = stateFrom;
    }

    @OneToOne
    @JoinColumn(name = "state_to")
    public State getStateTo() {
        return stateTo;
    }

    public void setStateTo(State stateTo) {
        this.stateTo = stateTo;
    }

    
}
