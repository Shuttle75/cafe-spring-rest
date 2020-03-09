package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.MenuGroup;
import org.shuttle75.samples.cafe.repository.MenuGroupRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/menu-groups")
class MenuGroupRestController {

    private final MenuGroupRepository menuGroupRepository;

    public MenuGroupRestController(MenuGroupRepository menuGroupRepository) {
        this.menuGroupRepository = menuGroupRepository;
    }

    @GetMapping
    public List<MenuGroup> findAllMenuGroups() {
        return menuGroupRepository.findAll();
    }

    @GetMapping("/{Id}")
    public MenuGroup getMenuGroup(@PathVariable("Id") int Id) {
        return this.menuGroupRepository.findById(Id);
    }
}

