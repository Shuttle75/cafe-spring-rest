package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.repository.BillRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.shuttle75.samples.cafe.model.Bill;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/bills")
public class BillRestController {

    private final BillRepository billRepository;

    public BillRestController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @GetMapping
    public Page<Bill> getBills(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @GetMapping("/{billId}")
    public Bill getBill(@PathVariable("billId") int billId) {
        return this.billRepository.findById(billId);
    }

    @PostMapping
    @Transactional
    public Bill addBill(@RequestBody @Valid Bill bill) {
        return this.billRepository.save(bill);
    }

    @PutMapping("/{billId}")
    @Transactional
    public Bill updateBill(@PathVariable("billId")  Bill bill) {
        return this.billRepository.save(bill);
    }

    @DeleteMapping("/{billId}")
    @Transactional
    public void deleteBill(@PathVariable("billId") Bill bill) {
        this.billRepository.delete(bill);
    }

}
