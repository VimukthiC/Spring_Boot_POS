package com.wixis360.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private String cartId;
    private String customerId;
    private String itemCode;
    private double unitPrice;
    private int cartItemQuantity;
    private String date;
}
