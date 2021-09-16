package com.wixis360.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oDId;
    private String orderId;
    private int qty;
    private double unitePrice;
    private String itemCode;
    @ManyToOne()
    @JoinColumn(name = "orderId", referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders orders;
    @ManyToOne()
    @JoinColumn(name = "itemCode", referencedColumnName = "itemCode",insertable = false,updatable = false)
    private Item item;
}
