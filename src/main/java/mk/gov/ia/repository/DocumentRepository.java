/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import java.util.ArrayList;
import java.util.List;
import mk.gov.ia.model.DebitCard;
import mk.gov.ia.model.Document;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author internet
 */
@Repository
public class DocumentRepository extends GenericRepository<Document> {

    @Autowired
    private SessionFactory sessionFactory;

    public DocumentRepository() {
        super(Document.class);
    }
    
}
