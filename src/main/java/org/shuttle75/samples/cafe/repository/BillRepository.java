package org.shuttle75.samples.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.shuttle75.samples.cafe.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    Bill findById(int id);
}
