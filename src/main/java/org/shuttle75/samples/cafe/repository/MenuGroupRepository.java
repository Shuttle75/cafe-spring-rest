package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuGroupRepository extends JpaRepository<MenuGroup, Integer> {

    MenuGroup findById(int id);
}
