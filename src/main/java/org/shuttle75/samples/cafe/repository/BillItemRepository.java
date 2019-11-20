package org.shuttle75.samples.cafe.repository;

import org.springframework.data.repository.Repository;
import org.shuttle75.samples.cafe.model.BillItem;

import java.util.List;

public interface BillItemRepository extends Repository<BillItem, Integer> {

    List<BillItem> findAll();

    List<BillItem> findByBillId(int id);

    BillItem findById(int id);

    void save(BillItem billItem);

    void delete(BillItem billItem);


}
