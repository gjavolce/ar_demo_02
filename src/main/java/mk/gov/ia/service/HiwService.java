/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.gov.ia.service;

import mk.gov.ia.repository.HiwDAO;
import mk.gov.ia.exception.DataStoreIntegrityException;
import mk.gov.ia.exception.NoSuchObjectException;
import mk.gov.ia.model.Hiw;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author expert
 */
@Service("HiwService")
@Transactional(readOnly = true)
public class HiwService {

    @Autowired
    HiwDAO hiwDAO;

    public Hiw getHiwById(int hiwId, int loggedInUserId) throws
            DataStoreIntegrityException, NoSuchObjectException {

        return hiwDAO.getById(hiwId);

    }

    @Transactional(readOnly = false)
    public void createHiw(Hiw hiw) throws
            DataStoreIntegrityException, NoSuchObjectException {

        hiwDAO.create(hiw);

    }

    @Transactional(readOnly = false)
    public void createHiw(Hiw hiw, int loggedInUserId) throws
            DataStoreIntegrityException, NoSuchObjectException {

        hiw.setCreatedBy(loggedInUserId);

        hiw.setCreatedDate(Calendar.getInstance().getTime());

        hiwDAO.create(hiw);

    }

    @Transactional(readOnly = false)
    public void updateHiw(Hiw hiw, int loggedInUserId) throws
            DataStoreIntegrityException, NoSuchObjectException {

        Hiw oldHiw = hiwDAO.getById(hiw.getId());

        oldHiw.setDescription(hiw.getDescription());

        oldHiw.setTitle(hiw.getTitle());

        oldHiw.setModifiedBy(loggedInUserId);

        oldHiw.setModifiedDate(Calendar.getInstance().getTime());

        hiwDAO.update(oldHiw);

    }

    @Transactional(readOnly = false)
    public void deleteHiw(Hiw hiw, int loggedInUserId) throws
            DataStoreIntegrityException, NoSuchObjectException {
        Hiw oldHiw = hiwDAO.getById(hiw.getId());

        oldHiw.setDeletedBy(loggedInUserId);
        oldHiw.setDeletedDate(Calendar.getInstance().getTime());

        hiwDAO.update(oldHiw);

    }

    @Transactional(readOnly = true)
    public List<Hiw> getAllHiws(int loggedInUserId) {

        return hiwDAO.getAllHiws();

    }

}
