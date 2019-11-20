package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.MenuGroup;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MenuGroupRepository extends Repository<MenuGroup, Integer> {

	List<MenuGroup> findAll();

    MenuGroup findById(int id);
}
