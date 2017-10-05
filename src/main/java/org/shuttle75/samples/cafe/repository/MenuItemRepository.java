package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.MenuItem;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MenuItemRepository extends Repository<MenuItem, Integer> {
	
	List<MenuItem> findAll() throws DataAccessException;

    List<MenuItem> findByMenuGroupId(int id) throws DataAccessException;

    MenuItem findById(int id) throws DataAccessException;
}
