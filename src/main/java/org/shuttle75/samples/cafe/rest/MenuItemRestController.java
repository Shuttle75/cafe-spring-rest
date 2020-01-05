package org.shuttle75.samples.cafe.rest;

import org.shuttle75.samples.cafe.model.MenuItem;
import org.shuttle75.samples.cafe.repository.MenuItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu-items")
class MenuItemRestController {

    private final MenuItemRepository menuItemRepository;

    public MenuItemRestController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @GetMapping
    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @GetMapping("/{Id}/menu-group")
    public List<MenuItem> findAllMenuItemsByMenuGroup(@PathVariable("Id") int Id) {
        return menuItemRepository.findByMenuGroupId(Id);
    }

    @GetMapping("/{Id}")
    public MenuItem getMenuItem(@PathVariable("Id") int Id) {
        return this.menuItemRepository.findById(Id);
    }
}

