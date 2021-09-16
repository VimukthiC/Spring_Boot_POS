package com.wixis360.spring.service.Impl;

import com.wixis360.spring.dto.OrderDetailDTO;
import com.wixis360.spring.entity.OrderDetails;
import com.wixis360.spring.repo.OrderDetailsRepo;
import com.wixis360.spring.repo.OrderRepo;
import com.wixis360.spring.service.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ModelMapper mapper;

    @Transactional
    @Override
    public boolean saveOrderDetails(OrderDetailDTO dto) {

        if (orderRepo.existsById(dto.getOrderId())){
            if (!orderDetailsRepo.existsById(dto.getOrderId())) {
                OrderDetails details = mapper.map(dto, OrderDetails.class);
                orderDetailsRepo.save(details);
                return true;
            } else {
                throw new RuntimeException("Order Details already exist..!");
            }
        }else {
            throw new  RuntimeException("Plz check your order added....? ");
        }
    }

    @Override
    public boolean updateOrderDetails(OrderDetailDTO dto) {
        if (orderDetailsRepo.existsById(dto.getOrderId())) {
            OrderDetails order = mapper.map(dto, OrderDetails.class);
            orderDetailsRepo.save(order);
            return true;
        } else {
            throw new RuntimeException("No such Order for update..!");
        }
    }

    @Override
    public OrderDetailDTO searchOrderDetails(String id) {
        Optional<OrderDetails> details = orderDetailsRepo.findById(id);
        if (details.isPresent()) {
            return mapper.map(details.get(), OrderDetailDTO.class);
        } else {
            throw new RuntimeException("No Order Details for id: " + id);
        }
    }

    @Override
    public boolean deleteOrderDetails(String id) {
        if (orderDetailsRepo.existsById(id)) {
            orderDetailsRepo.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("No Order Details for delete ID: " + id);
        }
    }

    @Override
    public List<OrderDetailDTO> getAllOrderDetails() {
        List<OrderDetails> all = orderDetailsRepo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDetailDTO>>() {
        }.getType());
    }
}
