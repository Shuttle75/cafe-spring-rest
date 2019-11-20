package org.shuttle75.samples.cafe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.shuttle75.samples.cafe.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    Page<Bill> findAll(Pageable pageable);

    Bill findById(int id);

    void delete(Bill bill);


}
