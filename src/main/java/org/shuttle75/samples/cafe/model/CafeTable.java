package org.shuttle75.samples.cafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cafe_tables")
public class CafeTable extends NamedEntity {

    @Column(name = "css_class")
    private String cssClass;

    @Column(name = "enabled")
    private Boolean enabled;

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
