package org.shuttle75.samples.cafe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "menu_items")
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuItem extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "menu_group_id ")
    private MenuGroup menuGroup;

    @Column(name = "price")
    @NotNull
    @Digits(fraction = 2, integer = 10)
    private float price;

}
