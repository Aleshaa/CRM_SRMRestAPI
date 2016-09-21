package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.ClManagerDAO;
import edu.bsuir.rest.model.ClManager;
import edu.bsuir.rest.services.ClManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class ClManagerServiceImpl implements ClManagerService {

    @Autowired
    ClManagerDAO clManagerDAO;

    @Override
    public boolean addClManager(ClManager clManager) throws Exception {
        return clManagerDAO.add(clManager);
    }

    @Override
    public boolean addClManagers(List<ClManager> clManagers) throws Exception {
        return clManagerDAO.addList(clManagers);
    }

    @Override
    public boolean updateClManager(ClManager clManager) throws Exception {
        return clManagerDAO.update(clManager);
    }

    @Override
    public boolean updateClManagers(List<ClManager> clManagers) throws Exception {
        return clManagerDAO.updateList(clManagers);
    }

    @Override
    public ClManager getClManagerById(int id) throws Exception {
        return clManagerDAO.getById(id);
    }

    @Override
    public List<ClManager> getClManagerList() throws Exception {
        return clManagerDAO.getList();
    }

    @Override
    public boolean deleteClManager(int id) throws Exception {
        return clManagerDAO.delete(id);
    }

    @Override
    public boolean deleteAllClManager() throws Exception {
        return deleteAllClManager();
    }
}
