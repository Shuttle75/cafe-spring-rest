package org.shuttle75.samples.cafe.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bills")
public class Bill extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "table_id")
    private CafeTable cafeTable;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Waiter waiter;

    @Column(name = "open_date")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm", timezone = "GMT+3")
    private Date openDate;

    @Column(name = "close_date")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm", timezone = "GMT+3")
    private Date closeDate;

    @Column(name = "persons")
    private Integer persons;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    @Column(name = "discount_amount")
    private Float discountAmount;

    @Column(name = "bill_amount")
    private Float billAmount;

    @Column(name = "whole_amount")
    private Float wholeAmount;

    @Column(name = "payment_type")
    private Integer paymentType;

    @Column(name = "transact_number")
    private String transactNumber;

    public CafeTable getCafeTable() {
        return cafeTable;
    }

    public void setCafeTable(CafeTable cafeTable) {
        this.cafeTable = cafeTable;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Float getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Float orderAmount) {
        this.billAmount = billAmount;
    }

    public Float getWholeAmount() {
        return wholeAmount;
    }

    public void setWholeAmount(Float wholeAmount) {
        this.wholeAmount = wholeAmount;
    }
}
