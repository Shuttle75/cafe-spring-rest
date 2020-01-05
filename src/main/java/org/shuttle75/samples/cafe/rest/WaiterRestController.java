package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.Waiter;
import org.shuttle75.samples.cafe.repository.WaiterRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waiters")
class WaiterRestController {

    private final WaiterRepository waiterRepository;

    public WaiterRestController(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    @GetMapping
    public List<Waiter> findAll() {
        return waiterRepository.findAll();
    }

    @GetMapping("/{Id}")
    public Waiter getWaiter(@PathVariable("Id") int Id) {
        return this.waiterRepository.findById(Id);
    }
}

