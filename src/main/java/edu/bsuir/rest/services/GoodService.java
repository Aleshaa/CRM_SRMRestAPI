package edu.bsuir.rest.services;

import edu.bsuir.rest.model.Good;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public interface GoodService {
    boolean addGood(Good good) throws Exception;
    boolean addGoods(List<Good> goods) throws Exception;
    boolean updateGood(Good good) throws Exception;
    boolean updateGoods(List<Good> goods) throws Exception;
    Good getGoodById(int id) throws Exception;
    List<Good> getGoodList() throws Exception;
    boolean deleteGood(int id) throws Exception;
    boolean deleteAllGood() throws Exception;
}
