/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mk.gov.ia.exception.ServiceException;
import mk.gov.ia.model.Document;
import mk.gov.ia.model.DocumentLeave;
import mk.gov.ia.model.DocumentLeaveHistory;
import mk.gov.ia.service.DocumentService;

/**
 *
 * @author internet
 */
@SessionScoped
@ManagedBean(name = "testController")
public class TestController implements Serializable {

    private Date dateFrom;

    private Date dateTo;

    private String description;

    private List<Document> documentList;

    private List<DocumentLeave> documentLeaveList;

    private List<DocumentLeaveHistory> documentLeaveHistory;

    private DocumentLeave currentDocumentLeave = new DocumentLeave();

    public DocumentLeave getCurrentDocumentLeave() {
        return currentDocumentLeave;
    }

    public void setCurrentDocumentLeave(DocumentLeave currentDocumentLeave) {
        this.currentDocumentLeave = currentDocumentLeave;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public List<DocumentLeave> getDocumentLeaveList() {
        return documentLeaveList;
    }

    public void setDocumentLeaveList(List<DocumentLeave> documentLeaveList) {
        this.documentLeaveList = documentLeaveList;
    }

    public List<DocumentLeaveHistory> getDocumentLeaveHistory() {
        return documentLeaveHistory;
    }

    public void setDocumentLeaveHistory(List<DocumentLeaveHistory> documentLeaveHistory) {
        this.documentLeaveHistory = documentLeaveHistory;
    }

    @ManagedProperty(value = "#{documentService}")
    DocumentService documentService;

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostConstruct
    public void init() {

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));

        this.documentList = documentService.getAllDocuments();

        this.documentLeaveList = documentService.getAllDocumentLeaves();

        this.documentLeaveHistory = documentService.getAllDocumentLeaveHistories();
    }

    public void testMethod01() {

        try {
            documentService.createLeaveDocument(1, dateFrom, dateTo, description);
        } catch (ServiceException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testMethod02() {

        try {
            documentService.updateLeaveDocument(currentDocumentLeave.getDocument().getId(),
                    1, currentDocumentLeave.getDateFrom(), currentDocumentLeave.getDateTo(),
                    currentDocumentLeave.getComment());
        } catch (ServiceException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testMethod03(int id) {

        try {
            this.currentDocumentLeave = documentService.getDocumentLeaveById(id);
            Logger.getLogger(TestController.class.getName()).log(Level.INFO,
                    null, "Enters curr doc id:" + currentDocumentLeave.getId());
        } catch (ServiceException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
