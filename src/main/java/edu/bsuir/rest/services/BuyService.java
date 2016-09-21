package edu.bsuir.rest.services;

import edu.bsuir.rest.model.Buy;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public interface BuyService {

    boolean addBuy(Buy buy) throws Exception;
    boolean addBuys(List<Buy> buys) throws Exception;
    boolean updateBuy(Buy buy) throws Exception;
    boolean updateBuys(List<Buy> buys) throws Exception;
    Buy getBuyById(int id) throws Exception;
    List<Buy> getBuyList() throws Exception;
    boolean deleteBuy(int id) throws Exception;
    boolean deleteAllBuy() throws Exception;

}
