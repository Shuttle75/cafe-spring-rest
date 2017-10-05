package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.CafeTable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CafeTableRepository  extends Repository<CafeTable, Integer> {
	
	List<CafeTable> findAll() throws DataAccessException;

    CafeTable findById(int id) throws DataAccessException;
}
