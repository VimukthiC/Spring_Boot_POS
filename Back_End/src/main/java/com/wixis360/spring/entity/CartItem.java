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
public class CartItem implements Serializable {
    @Id
    private String cartId;
    private String customerId;
    private String itemCode;
    private double unitPrice;
    private String date;

    @ManyToOne()
    @JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,updatable = false)
    private Customer customer1;

    @ManyToOne()
    @JoinColumn(name = "itemCode", referencedColumnName = "itemCode",insertable = false,updatable = false)
    private Item item1;

    private int cartItemQuantity;

//    @ManyToMany(mappedBy = "customer",cascade = CascadeType.ALL)
//    private List<History> histories = new ArrayList<>();
}
