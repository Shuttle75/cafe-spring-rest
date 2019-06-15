package org.shuttle75.samples.cafe.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "menu_items")
public class MenuItem extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "menu_group_id ")
    private MenuGroup menuGroup;

    @Column(name = "price")
    @NotNull
    @Digits(fraction = 2, integer = 10)
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public MenuGroup getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroup menuGroup) {
        this.menuGroup = menuGroup;
    }
}
