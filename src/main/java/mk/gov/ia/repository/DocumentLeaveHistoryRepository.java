/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.repository;

import java.util.ArrayList;
import mk.gov.ia.model.Document;
import mk.gov.ia.model.DocumentLeaveHistory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author internet
 */
@Repository
public class DocumentLeaveHistoryRepository extends GenericRepository<DocumentLeaveHistory> {

    @Autowired
    private SessionFactory sessionFactory;

    public DocumentLeaveHistoryRepository() {
        super(DocumentLeaveHistory.class);
    }

    public Integer getLastVersionNumberForDocument(Document document) {

        Criteria cq = getSessionFactory().getCurrentSession().createCriteria(DocumentLeaveHistory.class);

        Criterion userTypeCrit = Restrictions.eq("document", document);

        cq.add(userTypeCrit);

        cq.setProjection(Projections.max("version"));

        Integer x = (Integer) cq.uniqueResult();
        
        return x == null ? 0 : x;

    }

}
