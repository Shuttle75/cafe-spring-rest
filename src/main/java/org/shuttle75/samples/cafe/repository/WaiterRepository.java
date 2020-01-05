package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter, Integer> {

    Waiter findById(int id);
}
