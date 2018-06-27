package ru.grsp.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oc_order")
public class Order {
    @Id
    Integer id;
}
