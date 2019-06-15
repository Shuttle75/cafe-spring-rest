package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.Waiter;
import org.shuttle75.samples.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping(value = "/api/waiters")
class WaiterRestController {

    @Autowired
    private CafeService cafeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Waiter>> findAllWaiters() {
        List<Waiter> results = cafeService.findAllWaiters();
        return new ResponseEntity<>(results, HttpStatus.OK);

    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Waiter> getWaiter(@PathVariable("Id") int Id) {
        Waiter waiter = this.cafeService.findWaiterById(Id);
        if (waiter == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(waiter, HttpStatus.OK);
    }
}

