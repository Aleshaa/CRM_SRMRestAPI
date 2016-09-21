package edu.bsuir.rest.services;

import edu.bsuir.rest.model.Supplier;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public interface SupplierService {
    boolean addSupplier(Supplier supplier) throws Exception;
    boolean addSuppliers(List<Supplier> suppliers) throws Exception;
    boolean updateSupplier(Supplier supplier) throws Exception;
    boolean updateSuppliers(List<Supplier> suppliers) throws Exception;
    Supplier getSupplierById(int id) throws Exception;
    List<Supplier> getSupplierList() throws Exception;
    boolean deleteSupplier(int id) throws Exception;
    boolean deleteAllSupplier() throws Exception;
}
