package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.BillItem;
import org.shuttle75.samples.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/billItems")
public class BillItemRestController {

    private CafeService cafeService;

    @Autowired
    public BillItemRestController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<BillItem>> getBillItems() {
        List<BillItem> billItemList = cafeService.findAllBillItems();
        return new ResponseEntity<>(billItemList, HttpStatus.OK);
    }

    @GetMapping(value = "/{Id}/bill")
    public ResponseEntity<List<BillItem>> getBillItemsByBillId(@PathVariable("Id") int Id) {
        List<BillItem> billItemList = this.cafeService.findBillItemsByBillId(Id);
        if (billItemList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billItemList, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<BillItem> addBillItem(@RequestBody @Valid BillItem billItem, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        billItem.setOrderDate(new Date());
        this.cafeService.saveBillItem(billItem);
        headers.setLocation(ucBuilder.path("/api/billItems/{id}").buildAndExpand(billItem.getId()).toUri());
        return new ResponseEntity<>(billItem, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{billItemId}")
    public ResponseEntity<BillItem> updateBillItem(@PathVariable("billItemId") int billItemId,
                                    @RequestBody @Valid BillItem billItem) {
        BillItem currentBillItem = this.cafeService.findBillItemById(billItemId);
        if (currentBillItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBillItem.setBill(billItem.getBill());
        currentBillItem.setMenuItem(billItem.getMenuItem());
        currentBillItem.setOrderDate(new Date());
        currentBillItem.setPrice(billItem.getPrice());
        this.cafeService.saveBillItem(currentBillItem);
        return new ResponseEntity<>(currentBillItem, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{billItemId}")
    @Transactional
    public ResponseEntity<Void> deleteBill(@PathVariable("billItemId") int billItemId) {
        BillItem billItem = this.cafeService.findBillItemById(billItemId);
        if (billItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.cafeService.deleteBillItem(billItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
