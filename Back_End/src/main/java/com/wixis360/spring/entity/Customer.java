package com.wixis360.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer implements Serializable {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String customerPic;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "customer1")
    private List<CartItem> cartItems;

}


