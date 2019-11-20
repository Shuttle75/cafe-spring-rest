package org.shuttle75.samples.cafe.repository;

import org.shuttle75.samples.cafe.model.Waiter;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface WaiterRepository extends Repository<Waiter, Integer> {

	List<Waiter> findAll();

    Waiter findById(int id);
}
