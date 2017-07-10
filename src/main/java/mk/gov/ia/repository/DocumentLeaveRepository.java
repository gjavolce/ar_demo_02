/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import mk.gov.ia.model.DocumentLeave;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author internet
 */
@Repository
public class DocumentLeaveRepository extends GenericRepository<DocumentLeave> {

    @Autowired
    private SessionFactory sessionFactory;

    public DocumentLeaveRepository() {
        super(DocumentLeave.class);
    }
    
}
