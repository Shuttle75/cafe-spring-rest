package org.shuttle75.samples.cafe.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;

/**
 * Simple business object representing a pet.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 */
@Entity
@Table(name = "menu_items")
public class MenuItem extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "menu_group_id ")
    private MenuGroup menuGroup;

    @Column(name = "price")
    @NotEmpty
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
