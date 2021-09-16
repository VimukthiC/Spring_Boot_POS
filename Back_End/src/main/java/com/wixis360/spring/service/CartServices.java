package com.wixis360.spring.service;

import com.wixis360.spring.dto.CartItemDTO;
import com.wixis360.spring.dto.CustomerDTO;
import com.wixis360.spring.entity.CartItem;
import com.wixis360.spring.entity.Customer;

import java.util.List;

public interface CartServices {
//    List<CartItemDTO> listCartItems(String id);
//    List<CartItem> findCartItemByCustomerID(Iterable id);

    boolean saveCart(CartItemDTO dto);
    boolean updateCart(CartItemDTO dto);
    boolean deleteCart(String id);
    List<CartItemDTO> getAllCart();
    CartItemDTO searchCart(String id);
}
