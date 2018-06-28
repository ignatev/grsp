package ru.grsp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oc_order_product")
public class OrderProduct {
    @Id
    @Column(name = "order_product_id")
    Integer id;

    @Getter @Setter
    @Column(name="product_id")
    Integer productId;

    @Getter @Setter
    @Column(name = "order_id")
    Integer orderId;
}
