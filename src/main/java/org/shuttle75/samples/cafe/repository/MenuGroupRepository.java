package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.MenuGroup;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MenuGroupRepository extends Repository<MenuGroup, Integer> {
	
	List<MenuGroup> findAll() throws DataAccessException;

    MenuGroup findById(int id) throws DataAccessException;
}
