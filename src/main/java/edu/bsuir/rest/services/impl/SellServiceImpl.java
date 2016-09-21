package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.SellDAO;
import edu.bsuir.rest.model.Sell;
import edu.bsuir.rest.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class SellServiceImpl implements SellService {

    @Autowired
    SellDAO sellDAO;

    @Override
    public boolean addSell(Sell sell) throws Exception {
        return sellDAO.add(sell);
    }

    @Override
    public boolean addSells(List<Sell> sells) throws Exception {
        return sellDAO.addList(sells);
    }

    @Override
    public boolean updateSell(Sell sell) throws Exception {
        return sellDAO.update(sell);
    }

    @Override
    public boolean updateSells(List<Sell> sells) throws Exception {
        return sellDAO.updateList(sells);
    }

    @Override
    public Sell getSellById(int id) throws Exception {
        return sellDAO.getById(id);
    }

    @Override
    public List<Sell> getSellList() throws Exception {
        return sellDAO.getList();
    }

    @Override
    public boolean deleteSell(int id) throws Exception {
        return sellDAO.delete(id);
    }

    @Override
    public boolean deleteAllSell() throws Exception {
        return deleteAllSell();
    }
}
