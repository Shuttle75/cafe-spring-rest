package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.Waiter;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface WaiterRepository extends Repository<Waiter, Integer> {
	
	List<Waiter> findAll() throws DataAccessException;

    Waiter findById(int id) throws DataAccessException;
}
