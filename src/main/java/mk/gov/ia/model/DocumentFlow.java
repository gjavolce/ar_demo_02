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
@Table(name="document_flow")
public class DocumentFlow extends BaseObject {
    
    private String isComplete;
    private Document documentId;
    private Action actionId;
    private Transition transitionId;

    
    @Column(name = "is_complete")
    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    
     @OneToOne
   @JoinColumn(name = "document_id")
    public Document getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Document documentId) {
        this.documentId = documentId;
    }

    
     @OneToOne
   @JoinColumn(name = "action_id")
    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
    }

    
     @OneToOne
   @JoinColumn(name = "transition_id")
    public Transition getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(Transition transitionId) {
        this.transitionId = transitionId;
    }
    
    
    
    

    
}
