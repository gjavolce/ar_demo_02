/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import mk.gov.ia.model.Action;
import mk.gov.ia.model.Transition;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author internet
 */
@Repository
public class ActionRepository extends GenericRepository<Action> {

    @Autowired
    private SessionFactory sessionFactory;

    public ActionRepository() {
        super(Action.class);
    }
    
}
