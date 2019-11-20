package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.shuttle75.samples.cafe.model.CafeTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping(value = "/api/cafe-tables")
class CafeTableRestController {

    private final CafeService cafeService;

    @Autowired
    public CafeTableRestController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("")
    public ResponseEntity<List<CafeTable>> findAllCafeTables() {
        List<CafeTable> results = cafeService.findAllCafeTables();
        return new ResponseEntity<>(results, HttpStatus.OK);

    }

    @GetMapping("/{Id}")
    public ResponseEntity<CafeTable> getCafeTable(@PathVariable("Id") int Id) {
        CafeTable cafeTable = this.cafeService.findCafeTableById(Id);
        if (cafeTable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cafeTable, HttpStatus.OK);
    }
}
