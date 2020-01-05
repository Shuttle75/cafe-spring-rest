package org.shuttle75.samples.cafe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "bill_items")
public class BillItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_items_id ")
    private MenuItem menuItem;

    @Column(name = "order_date")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm", timezone = "GMT+3")
    private Date orderDate;

    @Column(name = "price")
    private Float price;
}
