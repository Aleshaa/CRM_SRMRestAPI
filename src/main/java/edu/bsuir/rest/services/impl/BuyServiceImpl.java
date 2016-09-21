package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.BuyDAO;
import edu.bsuir.rest.model.Buy;
import edu.bsuir.rest.services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public class BuyServiceImpl implements BuyService {

    @Autowired
    BuyDAO buyDAO;

    @Override
    public boolean addBuy(Buy buy) throws Exception {
        return false;
    }

    @Override
    public boolean addBuys(List<Buy> buys) throws Exception {
        return false;
    }

    @Override
    public boolean updateBuy(Buy buy) throws Exception {
        return false;
    }

    @Override
    public boolean updateBuys(List<Buy> buys) throws Exception {
        return false;
    }

    @Override
    public Buy getBuyById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Buy> getBuyList() throws Exception {
        return null;
    }

    @Override
    public boolean deleteBuy(int id) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAllBuy() throws Exception {
        return false;
    }
}
