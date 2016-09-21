package edu.bsuir.rest.services;

import edu.bsuir.rest.model.Sell;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public interface SellService {
    boolean addSell(Sell sell) throws Exception;
    boolean addSells(List<Sell> sells) throws Exception;
    boolean updateSell(Sell sell) throws Exception;
    boolean updateSells(List<Sell> sells) throws Exception;
    Sell getSellById(int id) throws Exception;
    List<Sell> getSellList() throws Exception;
    boolean deleteSell(int id) throws Exception;
    boolean deleteAllSell() throws Exception;
}
