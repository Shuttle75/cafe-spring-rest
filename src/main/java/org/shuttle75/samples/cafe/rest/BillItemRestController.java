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

    @Autowired
    private CafeService cafeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BillItem>> getBillItems() {
        List<BillItem> billItemList = cafeService.findAllBillItems();
        return new ResponseEntity<List<BillItem>>(billItemList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{Id}/bill", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<BillItem>> getBillItemsByBillId(@PathVariable("Id") int Id) {
        List<BillItem> billItemList = this.cafeService.findBillItemsByBillId(Id);
        if (billItemList == null) {
            return new ResponseEntity<List<BillItem>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<BillItem>>(billItemList, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BillItem> addBillItem(@RequestBody @Valid BillItem billItem, BindingResult bindingResult,
                                        UriComponentsBuilder ucBuilder) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (billItem == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<BillItem>(headers, HttpStatus.BAD_REQUEST);
        }
        billItem.setOrderDate(new Date());
        this.cafeService.saveBillItem(billItem);
        headers.setLocation(ucBuilder.path("/api/billItems/{id}").buildAndExpand(billItem.getId()).toUri());
        return new ResponseEntity<BillItem>(billItem, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BillItem> updateBillItem(@PathVariable("billItemId") int billItemId, @RequestBody @Valid BillItem billItem,
                                            BindingResult bindingResult) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (billItem == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<BillItem>(headers, HttpStatus.BAD_REQUEST);
        }
        BillItem currentBillItem = this.cafeService.findBillItemById(billItemId);
        if (currentBillItem == null) {
            return new ResponseEntity<BillItem>(HttpStatus.NOT_FOUND);
        }
        currentBillItem.setBill(billItem.getBill());
        currentBillItem.setMenuItem(billItem.getMenuItem());
        currentBillItem.setOrderDate(new Date());
        currentBillItem.setPrice(billItem.getPrice());
        this.cafeService.saveBillItem(currentBillItem);
        return new ResponseEntity<BillItem>(currentBillItem, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{billItemId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional
    public ResponseEntity<Void> deleteBill(@PathVariable("billItemId") int billItemId) {
        BillItem billItem = this.cafeService.findBillItemById(billItemId);
        if (billItem == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.cafeService.deleteBillItem(billItem);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
