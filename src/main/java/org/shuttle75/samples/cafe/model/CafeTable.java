package org.shuttle75.samples.cafe.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cafe_tables")
@Data
@EqualsAndHashCode(callSuper = true)
public class CafeTable extends NamedEntity {

    @Column(name = "css_class")
    private String cssClass;

    @Column(name = "enabled")
    private Boolean enabled;

}
