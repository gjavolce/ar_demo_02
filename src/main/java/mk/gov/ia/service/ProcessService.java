/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import mk.gov.ia.exception.DataStoreIntegrityException;
import mk.gov.ia.exception.NoSuchObjectException;
import mk.gov.ia.model.Document;
import mk.gov.ia.model.DocumentFlow;
import mk.gov.ia.model.Employee;
import mk.gov.ia.model.State;
import mk.gov.ia.repository.DocumentRepository;
import mk.gov.ia.repository.EmployeeRepository;
import mk.gov.ia.repository.StateRepository;
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

    public void startProcess(int docId, int employeeId) {

        try {
            Document doc = documentRepository.getById(docId);

            Employee employee = employeeRepository.getById(employeeId);
            
            State initialState = stateRepository.getById(1);
            
            
            
            DocumentFlow docFlow = new DocumentFlow();
            
            docF

        } catch (DataStoreIntegrityException | NoSuchObjectException ex) {
            Logger.getLogger(ProcessService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
