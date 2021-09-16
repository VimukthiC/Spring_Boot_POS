package com.wixis360.spring.service;

import com.wixis360.spring.dto.OrderDetailDTO;

import java.util.List;

public interface OrderDetailsService {
    boolean saveOrderDetails(OrderDetailDTO dto);
    boolean updateOrderDetails(OrderDetailDTO dto);
    OrderDetailDTO searchOrderDetails(String id);
    boolean deleteOrderDetails(String id);
    List<OrderDetailDTO> getAllOrderDetails();
}
