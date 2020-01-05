package org.shuttle75.samples.cafe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {

    @Column(name = "first_name")
    @NotNull
    protected String firstName;

    @Column(name = "last_name")
    @NotNull
    protected String lastName;

}
