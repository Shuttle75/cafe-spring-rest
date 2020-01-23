package org.shuttle75.samples.cafe.dto;

import lombok.Data;

@Data
public class BillDto {

    private Integer id;

    private CafeTableDto cafeTable;

    private String cafeTableCssClass;

    private Boolean cafeTableEnabled;

    private String wrongField;

}
