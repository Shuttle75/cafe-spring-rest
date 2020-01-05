package org.shuttle75.samples.cafe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "waiters")
@Data
@EqualsAndHashCode(callSuper = true)
public class Waiter extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

}
