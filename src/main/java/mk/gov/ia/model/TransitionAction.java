/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author internet
 */
@Entity
@Table(name="transition_action")
public class TransitionAction extends BaseObject {
    
    private Transition transitionId;
    private Action actionId;

    
    @OneToOne
   @JoinColumn(name = "transition_id")
    public Transition getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(Transition transitionId) {
        this.transitionId = transitionId;
    }

    
    @OneToOne
   @JoinColumn(name = "action_id")
    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
    }
    
    

    
}
