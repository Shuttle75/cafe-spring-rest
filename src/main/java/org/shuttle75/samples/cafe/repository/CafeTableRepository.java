package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.CafeTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeTableRepository  extends JpaRepository<CafeTable, Integer> {

    CafeTable findById(int id);
}
