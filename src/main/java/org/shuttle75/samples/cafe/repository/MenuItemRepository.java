package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.MenuItem;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MenuItemRepository extends Repository<MenuItem, Integer> {

	List<MenuItem> findAll();

    List<MenuItem> findByMenuGroupId(int id);

    MenuItem findById(int id);
}
