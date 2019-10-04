package org.quarkus.xcc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Todo
 */
@Entity
public class Todo extends PanacheEntity {

    @NotBlank
    public String title;
    public boolean completed;
    @Column(name = "ordering")
    public int order;

}