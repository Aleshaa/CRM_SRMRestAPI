package edu.bsuir.rest.services;

import edu.bsuir.rest.model.SupManager;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public interface SupManagerService {

    boolean addSupManager(SupManager supManager) throws Exception;
    boolean addSupManagers(List<SupManager> supManagers) throws Exception;
    boolean updateSupManager(SupManager supManager) throws Exception;
    boolean updateSupManagers(List<SupManager> supManagers) throws Exception;
    SupManager getSupManagerById(int id) throws Exception;
    List<SupManager> getSupManagerList() throws Exception;
    boolean deleteSupManager(int id) throws Exception;
    boolean deleteAllSupManager() throws Exception;
}
