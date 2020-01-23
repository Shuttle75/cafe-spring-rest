package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.QBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.shuttle75.samples.cafe.model.Bill;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

public interface BillRepository
    extends JpaRepository<Bill, Integer>, QuerydslPredicateExecutor<Bill> {

    Bill findById(int id);
}
