package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

    List<MenuItem> findByMenuGroupId(int id);

    MenuItem findById(int id);
}
