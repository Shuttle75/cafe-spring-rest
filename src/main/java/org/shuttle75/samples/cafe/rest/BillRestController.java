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

    @Autowired
    private CafeService cafeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Bill>> getBills(Pageable pageable) {
        Page<Bill> page = cafeService.findAllBills(pageable);
        return new ResponseEntity<Page<Bill>>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/{billId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Bill> getBill(@PathVariable("billId") int billId) {
        Bill bill = this.cafeService.findBillById(billId);
        if (bill == null) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Bill> addBill(@RequestBody @Valid Bill bill , BindingResult bindingResult,
                                        UriComponentsBuilder ucBuilder) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (bill == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<Bill>(headers, HttpStatus.BAD_REQUEST);
        }
        bill.setOpenDate(new Date());
        bill.setCloseDate(new Date());
        this.cafeService.saveBill(bill);
        headers.setLocation(ucBuilder.path("/api/bills/{id}").buildAndExpand(bill.getId()).toUri());
        return new ResponseEntity<Bill>(bill, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{billId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Bill> updateBill(@PathVariable("billId") int billId, @RequestBody @Valid Bill bill,
                                            BindingResult bindingResult) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (bill == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<Bill>(headers, HttpStatus.BAD_REQUEST);
        }
        Bill currentBill = this.cafeService.findBillById(billId);
        if (currentBill == null) {
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }
        currentBill.setCafeTable(bill.getCafeTable());
        currentBill.setWaiter(bill.getWaiter());
        currentBill.setPersons(bill.getPersons());
        currentBill.setOpenDate(bill.getOpenDate());
        currentBill.setCloseDate(bill.getCloseDate());
        this.cafeService.saveBill(currentBill);
        return new ResponseEntity<Bill>(currentBill, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{billId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional
    public ResponseEntity<Void> deleteBill(@PathVariable("billId") int billId) {
        Bill bill = this.cafeService.findBillById(billId);
        if (bill == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.cafeService.deleteBill(bill);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
