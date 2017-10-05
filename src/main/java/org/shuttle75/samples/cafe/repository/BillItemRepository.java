package org.shuttle75.samples.cafe.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.shuttle75.samples.cafe.model.BillItem;

import java.util.List;

public interface BillItemRepository extends Repository<BillItem, Integer> {

    public List<BillItem> findAll() throws DataAccessException;

    public List<BillItem> findByBillId(int id) throws DataAccessException;

    public BillItem findById(int id) throws DataAccessException;

    public void save(BillItem billItem) throws DataAccessException;

    public void delete(BillItem billItem) throws DataAccessException;


}
