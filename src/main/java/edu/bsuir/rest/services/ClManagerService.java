package edu.bsuir.rest.services;

import edu.bsuir.rest.model.ClManager;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public interface ClManagerService {
    
    boolean addClManager(ClManager clManager) throws Exception;
    boolean addClManagers(List<ClManager> clManager) throws Exception;
    boolean updateClManager(ClManager clManager) throws Exception;
    boolean updateClManagers(List<ClManager> clManager) throws Exception;
    ClManager getClManagerById(int id) throws Exception;
    List<ClManager> getClManagerList() throws Exception;
    boolean deleteClManager(int id) throws Exception;
    boolean deleteAllClManager() throws Exception;
    
}
