/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.service;

import java.util.Date;
import java.util.List;
import mk.gov.ia.exception.DataStoreIntegrityException;
import mk.gov.ia.exception.NoSuchObjectException;
import mk.gov.ia.exception.ServiceException;
import mk.gov.ia.model.Document;
import mk.gov.ia.model.DocumentLeave;
import mk.gov.ia.model.DocumentLeaveHistory;
import mk.gov.ia.model.Employee;
import mk.gov.ia.repository.DocumentLeaveHistoryRepository;
import mk.gov.ia.repository.DocumentLeaveRepository;
import mk.gov.ia.repository.DocumentRepository;
import mk.gov.ia.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author expert
 */
@Service("documentService")
@Transactional(readOnly = false)
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    DocumentLeaveRepository documentLeaveRepository;

    @Autowired
    DocumentLeaveHistoryRepository documentLeaveHistoryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void createLeaveDocument(int employeeId, Date startDate, Date endDate,
            String description) throws ServiceException {

        try {

            Employee employee = employeeRepository.getById(employeeId);

            Document newDocument = createDocumentRecord(employee);

            createDocumentLeaveRecord(newDocument, startDate, endDate, description);

            createDocumentLeaveHistoryRecord(newDocument, startDate, endDate, description);

        } catch (DataStoreIntegrityException | NoSuchObjectException ex) {

            throw new ServiceException(ex.getMessage());

        }

    }

    public Document createDocumentRecord(Employee employee) {

        Document tempDoc = new Document();

        tempDoc.setEmployee(employee);

        documentRepository.create(tempDoc);

        return tempDoc;

    }

    public void createDocumentLeaveRecord(Document document, Date startDate, Date endDate,
            String description) {

        DocumentLeave documentLeave = new DocumentLeave();

        documentLeave.setDateFrom(startDate);

        documentLeave.setDateTo(endDate);

        documentLeave.setDocument(document);

        documentLeave.setComment(description);

        documentLeaveRepository.create(documentLeave);

    }

    public void createDocumentLeaveHistoryRecord(Document document, Date startDate, Date endDate,
            String description) {

        Integer x = documentLeaveHistoryRepository.getLastVersionNumberForDocument(document);

        DocumentLeaveHistory tempLeaveHistory = new DocumentLeaveHistory();

        tempLeaveHistory.setDocument(document);

        tempLeaveHistory.setDateFrom(startDate);

        tempLeaveHistory.setDateTo(endDate);

        tempLeaveHistory.setVersion(x + 1);

        tempLeaveHistory.setComment(description);

        documentLeaveHistoryRepository.create(tempLeaveHistory);

    }

    public void updateLeaveDocument(int documentId, int employeeId, Date startDate, Date endDate,
            String description) throws ServiceException {

        try {

            Document document = documentRepository.getById(documentId);

            DocumentLeave documentLeave = documentLeaveRepository.getByParam("document", document);

            documentLeave.setDateFrom(startDate);

            documentLeave.setDateTo(endDate);

            documentLeave.setComment(description);

            documentLeaveRepository.update(documentLeave);

            createDocumentLeaveHistoryRecord(document, startDate, endDate, description);

        } catch (DataStoreIntegrityException | NoSuchObjectException ex) {

            throw new ServiceException(ex.getMessage());

        }

    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<DocumentLeave> getAllDocumentLeaves() {
        return documentLeaveRepository.findAll();
    }

    public List<DocumentLeaveHistory> getAllDocumentLeaveHistories() {
        return documentLeaveHistoryRepository.findAll();
    }

    public DocumentLeave getDocumentLeaveById(int docId) throws ServiceException {

        try {
            return documentLeaveRepository.getById(docId);
        } catch (NoSuchObjectException | DataStoreIntegrityException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
