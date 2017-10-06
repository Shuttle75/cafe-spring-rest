package org.shuttle75.samples.cafe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill_items")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BillItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "menu_items_id ")
    private MenuItem menuItem;

    @Column(name = "order_date")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm", timezone = "GMT+3")
    private Date orderDate;

    @Column(name = "price")
    private Float price;


    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String getOrderDateString() {
        return orderDate.toString();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
