package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.MenuGroup;
import org.shuttle75.samples.cafe.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping(value = "/api/menu-groups")
class MenuGroupRestController {

    @Autowired
    private CafeService cafeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MenuGroup>> findAllMenuGroups() {
        List<MenuGroup> results = cafeService.findAllMenuGroups();
        return new ResponseEntity<>(results, HttpStatus.OK);

    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MenuGroup> getMenuGroup(@PathVariable("Id") int Id) {
        MenuGroup MenuGroup = this.cafeService.findMenuGroupById(Id);
        if (MenuGroup == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(MenuGroup, HttpStatus.OK);
    }
}

