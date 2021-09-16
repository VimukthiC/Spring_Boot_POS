package com.wixis360.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item implements Serializable {
    @Id
    private String itemCode;
    private String itemName;
    private double unitPrice;
    private int qtyOnHand;
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "item1",cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();
}

