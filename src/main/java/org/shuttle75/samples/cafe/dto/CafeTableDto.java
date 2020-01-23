package org.shuttle75.samples.cafe.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.shuttle75.samples.cafe.model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
public class CafeTableDto extends NamedEntity {

    private Integer id;

    private String name;

    private String cssClass;

    private Boolean enabled;

}
