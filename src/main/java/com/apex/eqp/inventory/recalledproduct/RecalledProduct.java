package com.apex.eqp.inventory.recalledproduct;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class RecalledProduct {
    @Id
    @GeneratedValue
    Integer id;

    @Column(unique=true)
    String name;
}
