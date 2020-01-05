package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.BillItem;
import org.shuttle75.samples.cafe.repository.BillItemRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/billItems")
public class BillItemRestController {

    private BillItemRepository billItemRepository;

    public BillItemRestController(BillItemRepository billItemRepository) {
        this.billItemRepository = billItemRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<BillItem>> getBillItems() {
        List<BillItem> billItemList = billItemRepository.findAll();
        return new ResponseEntity<>(billItemList, HttpStatus.OK);
    }

    @GetMapping(value = "/{Id}/bill")
    public ResponseEntity<List<BillItem>> getBillItemsByBillId(@PathVariable("Id") int Id) {
        List<BillItem> billItemList = billItemRepository.findByBillId(Id);
        if (billItemList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billItemList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BillItem> addBillItem(@RequestBody @Valid BillItem billItem, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        billItem.setOrderDate(new Date());
        this.billItemRepository.save(billItem);
        headers.setLocation(ucBuilder.path("/api/billItems/{id}").buildAndExpand(billItem.getId()).toUri());
        return new ResponseEntity<>(billItem, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{billItemId}")
    @Transactional
    public BillItem updateBillItem(@PathVariable("billItemId") BillItem billItem) {
        return this.billItemRepository.save(billItem);
    }

    @DeleteMapping("/{billItemId}")
    @Transactional
    public void deleteBill(@PathVariable("billItemId") BillItem billItem) {
        this.billItemRepository.delete(billItem);
    }

}
