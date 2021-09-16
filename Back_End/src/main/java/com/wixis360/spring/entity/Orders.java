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
public class Orders implements Serializable {
    @Id
    private String orderId;
    private String orderDate;
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
}
