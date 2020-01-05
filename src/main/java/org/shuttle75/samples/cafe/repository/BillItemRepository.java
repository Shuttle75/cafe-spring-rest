package org.shuttle75.samples.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.shuttle75.samples.cafe.model.BillItem;

import java.util.List;

public interface BillItemRepository extends JpaRepository<BillItem, Integer> {

    List<BillItem> findByBillId(int id);

    BillItem findById(int id);
}
