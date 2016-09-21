package edu.bsuir.rest.services.impl;

import edu.bsuir.rest.dao.SupplierDAO;
import edu.bsuir.rest.model.Supplier;
import edu.bsuir.rest.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Alesha on 21.09.2016.
 */
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierDAO supplierDAO;

    @Override
    public boolean addSupplier(Supplier supplier) throws Exception {
        return supplierDAO.add(supplier);
    }

    @Override
    public boolean addSuppliers(List<Supplier> suppliers) throws Exception {
        return supplierDAO.addList(suppliers);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) throws Exception {
        return supplierDAO.update(supplier);
    }

    @Override
    public boolean updateSuppliers(List<Supplier> suppliers) throws Exception {
        return supplierDAO.updateList(suppliers);
    }

    @Override
    public Supplier getSupplierById(int id) throws Exception {
        return supplierDAO.getById(id);
    }

    @Override
    public List<Supplier> getSupplierList() throws Exception {
        return supplierDAO.getList();
    }

    @Override
    public boolean deleteSupplier(int id) throws Exception {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean deleteAllSupplier() throws Exception {
        return deleteAllSupplier();
    }
}
