package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.MenuItem;
import org.shuttle75.samples.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping(value = "/api/menu-items")
class MenuItemRestController {

    private final CafeService cafeService;

    @Autowired
    public MenuItemRestController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("")
    public ResponseEntity<List<MenuItem>> findAllMenuItems() {
        List<MenuItem> results = cafeService.findAllMenuItems();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/{Id}/menu-group")
    public ResponseEntity<List<MenuItem>> findAllMenuItemsByMenuGroup(@PathVariable("Id") int Id) {
        List<MenuItem> results = cafeService.findMenuItemsByMenuGroup(Id);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable("Id") int Id) {
        MenuItem menuItem = this.cafeService.findMenuItemById(Id);
        if (menuItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menuItem, HttpStatus.OK);
    }
}

