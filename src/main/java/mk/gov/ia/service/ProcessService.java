/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mk.gov.ia.exception.DataStoreIntegrityException;
import mk.gov.ia.exception.NoSuchObjectException;
import mk.gov.ia.model.Document;
import mk.gov.ia.model.DocumentFlow;
import mk.gov.ia.model.Employee;
import mk.gov.ia.model.State;
import mk.gov.ia.model.Transition;
import mk.gov.ia.repository.ActionRepository;
import mk.gov.ia.repository.DocumentRepository;
import mk.gov.ia.repository.EmployeeRepository;
import mk.gov.ia.repository.StateRepository;
import mk.gov.ia.repository.TransitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author expert
 */
@Service("processService")
@Transactional(readOnly = true)
public class ProcessService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    StateRepository stateRepository;
    
    @Autowired
    TransitionRepository transitionRepository;
    
    @Autowired
    ActionRepository actionRepository;

    public void startProcess(int docId, int employeeId) {

        try {
            Document doc = documentRepository.getById(docId);

            Employee employee = employeeRepository.getById(employeeId);
            
            State initialState = stateRepository.getById(1);
            
            List<Transition> availableTransitionsList = 
                    transitionRepository.findByParam("stateFrom", initialState);
            
            List<DocumentFlow> nextFlows = new ArrayList<>(availableTransitionsList.size());
            
            
            
            for(Transition t : availableTransitionsList) {
                
                DocumentFlow docFlow = new DocumentFlow();
                
             //   docFlow.setAction();
                
                docFlow.setDocument(doc);
                
                docFlow.setTransitionId(t);
                
                
                
                
              //  nextFlows.add()
                
                t.getStateTo();
            }
            
            
            
         //   docF

        } catch (DataStoreIntegrityException | NoSuchObjectException | NoSuchFieldException ex) {
            Logger.getLogger(ProcessService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
