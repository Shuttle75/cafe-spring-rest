package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.repository.CafeTableRepository;
import org.shuttle75.samples.cafe.model.CafeTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cafe-tables")
class CafeTableRestController {

    private final CafeTableRepository cafeTableRepository;

    public CafeTableRestController(CafeTableRepository cafeTableRepository) {
        this.cafeTableRepository = cafeTableRepository;
    }

    @GetMapping
    public List<CafeTable> findAllCafeTables() {
        return cafeTableRepository.findAll();
    }

    @GetMapping("/{Id}")
    public CafeTable getCafeTable(@PathVariable("Id") int Id) {
        return this.cafeTableRepository.findById(Id);
    }
}
