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
@Table(name = "document_flow")
public class DocumentFlow extends BaseObject {

    private boolean complete;
    private Document document;
    private Action action;
    private Transition transition;

    @Column(name = "is_complete")
    public boolean isComplete() {
        return complete;
    }

    public void setIsComplete(boolean isComplete) {
        this.complete = isComplete;
    }

    @OneToOne
    @JoinColumn(name = "document_id")
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @OneToOne
    @JoinColumn(name = "action_id")
    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @OneToOne
    @JoinColumn(name = "transition_id")
    public Transition getTransition() {
        return transition;
    }

    public void setTransitionId(Transition transition) {
        this.transition = transition;
    }

}
