package edu.bsuir.rest.dao;

import java.util.List;

/**
 * Created by Alesha on 19.09.2016.
 */
public interface IDao<T> {

    boolean add(T element) throws Exception;
    boolean addList(List<T> elements) throws Exception;
    boolean update(T element) throws Exception;
    boolean updateList(List<T> elements) throws Exception;
    T getById(int id) throws Exception;
    List<T> getList() throws Exception;
    boolean delete(int id) throws Exception;
    boolean deleteAll() throws Exception;

}
