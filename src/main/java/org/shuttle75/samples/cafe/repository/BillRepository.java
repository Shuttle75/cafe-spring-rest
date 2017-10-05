package org.shuttle75.samples.cafe.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.shuttle75.samples.cafe.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    Page<Bill> findAll(Pageable pageable) throws DataAccessException;

    Bill findById(int id) throws DataAccessException;

//    public save(Bill bill) throws DataAccessException;

    void delete(Bill bill) throws DataAccessException;


}
