package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.shuttle75.samples.cafe.model.Bill;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/bills")
public class BillRestController {

    private final CafeService cafeService;

    @Autowired
    public BillRestController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("")
    public ResponseEntity<Page<Bill>> getBills(Pageable pageable) {
        Page<Bill> page = cafeService.findAllBills(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBill(@PathVariable("billId") int billId) {
        Bill bill = this.cafeService.findBillById(billId);
        if (bill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Bill> addBill(@RequestBody @Valid Bill bill, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        bill.setOpenDate(new Date());
        this.cafeService.saveBill(bill);
        headers.setLocation(ucBuilder.path("/api/bills/{id}").buildAndExpand(bill.getId()).toUri());
        return new ResponseEntity<Bill>(bill, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{billId}")
    public ResponseEntity<Bill> updateBill(@PathVariable("billId") int billId, @RequestBody @Valid Bill bill) {
        Bill currentBill = this.cafeService.findBillById(billId);
        if (currentBill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBill.setCafeTable(bill.getCafeTable());
        currentBill.setWaiter(bill.getWaiter());
        currentBill.setPersons(bill.getPersons());
        currentBill.setOpenDate(bill.getOpenDate());
        currentBill.setCloseDate(bill.getCloseDate());
        this.cafeService.saveBill(currentBill);
        return new ResponseEntity<>(currentBill, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{billId}")
    @Transactional
    public ResponseEntity<Void> deleteBill(@PathVariable("billId") int billId) {
        Bill bill = this.cafeService.findBillById(billId);
        if (bill == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cafeService.deleteBill(bill);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
