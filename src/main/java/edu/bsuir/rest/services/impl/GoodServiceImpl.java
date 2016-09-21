package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.GoodDAO;
import edu.bsuir.rest.model.Good;
import edu.bsuir.rest.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class GoodServiceImpl implements GoodService {

    @Autowired
    GoodDAO goodDAO;

    @Override
    public boolean addGood(Good good) throws Exception {
        return goodDAO.add(good);
    }

    @Override
    public boolean addGoods(List<Good> goods) throws Exception {
        return goodDAO.addList(goods);
    }

    @Override
    public boolean updateGood(Good good) throws Exception {
        return goodDAO.update(good);
    }

    @Override
    public boolean updateGoods(List<Good> goods) throws Exception {
        return goodDAO.updateList(goods);
    }

    @Override
    public Good getGoodById(int id) throws Exception {
        return goodDAO.getById(id);
    }

    @Override
    public List<Good> getGoodList() throws Exception {
        return goodDAO.getList();
    }

    @Override
    public boolean deleteGood(int id) throws Exception {
        return goodDAO.delete(id);
    }

    @Override
    public boolean deleteAllGood() throws Exception {
        return deleteAllGood();
    }
}
