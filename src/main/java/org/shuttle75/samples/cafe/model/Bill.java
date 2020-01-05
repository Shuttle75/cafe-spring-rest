package org.shuttle75.samples.cafe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bills")
@Data
@EqualsAndHashCode(callSuper = true)
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

}
