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
@Table(name="action")
public class Action extends BaseObject{
    
    
   
    private String actionType;
    private Group group_id;

    
   @OneToOne
   @JoinColumn(name = "transition_id")
    public Group getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Group group_id) {
        this.group_id = group_id;
    }

   

    @Column(name = "action_type")
    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

 
    
    
    
}
