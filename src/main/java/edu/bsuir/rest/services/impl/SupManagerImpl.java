package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.SupManagerDAO;
import edu.bsuir.rest.model.SupManager;
import edu.bsuir.rest.services.SupManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class SupManagerImpl implements SupManagerService {

    @Autowired
    SupManagerDAO supManagerDAO;

    @Override
    public boolean addSupManager(SupManager supManager) throws Exception {
        return supManagerDAO.add(supManager);
    }

    @Override
    public boolean addSupManagers(List<SupManager> supManagers) throws Exception {
        return supManagerDAO.addList(supManagers);
    }

    @Override
    public boolean updateSupManager(SupManager supManager) throws Exception {
        return supManagerDAO.update(supManager);
    }

    @Override
    public boolean updateSupManagers(List<SupManager> supManagers) throws Exception {
        return supManagerDAO.updateList(supManagers);
    }

    @Override
    public SupManager getSupManagerById(int id) throws Exception {
        return supManagerDAO.getById(id);
    }

    @Override
    public List<SupManager> getSupManagerList() throws Exception {
        return supManagerDAO.getList();
    }

    @Override
    public boolean deleteSupManager(int id) throws Exception {
        return supManagerDAO.delete(id);
    }

    @Override
    public boolean deleteAllSupManager() throws Exception {
        return deleteAllSupManager();
    }
}
