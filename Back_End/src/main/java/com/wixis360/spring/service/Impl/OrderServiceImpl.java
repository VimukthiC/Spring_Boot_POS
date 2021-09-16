package com.wixis360.spring.service.Impl;

import com.wixis360.spring.dto.CartItemDTO;
import com.wixis360.spring.dto.OrderDTO;
import com.wixis360.spring.dto.OrderDetailDTO;
import com.wixis360.spring.entity.Item;
import com.wixis360.spring.entity.OrderDetails;
import com.wixis360.spring.entity.Orders;
import com.wixis360.spring.repo.*;
import com.wixis360.spring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    OrderRepo repo;

    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public boolean saveOrder(OrderDTO dto) {
        if (customerRepo.existsById(dto.getCustomerId())) {
            boolean b = customerRepo.existsById(dto.getCustomerId());
            System.out.println(b);
            if (!repo.existsById(dto.getOrderId())) {
                Orders order = mapper.map(dto, Orders.class);
                repo.save(order);
                if (dto.getOrderDetails().size() > 0) {

                    for (OrderDetailDTO orderDetailDTO : dto.getOrderDetails()) {

                        OrderDetails orderDetails = new OrderDetails();
                        orderDetails.setOrderId(orderDetailDTO.getOrderId());
                        orderDetails.setQty(orderDetailDTO.getQty());
                        orderDetails.setUnitePrice(orderDetailDTO.getUnitePrice());
                        orderDetails.setItemCode(orderDetailDTO.getItemCode());
                        orderDetailsRepo.save(orderDetails);

                        Item item = itemRepo.getOne(orderDetailDTO.getItemCode());
                        int qty = item.getQtyOnHand() - orderDetailDTO.getQty();
                        item.setQtyOnHand(qty);
                    }

                    return true;
                } else {
                    throw new RuntimeException("Plz check Order Details .....?");
                }
            }else{
                throw new RuntimeException("Plz add Order .....?");
            }
        }else {
            throw new RuntimeException("Plz add Customer .....?");
        }
    }


    @Override
    public boolean updateOrder(OrderDTO dto) {
        if (repo.existsById(dto.getOrderId())) {
            Orders order = mapper.map(dto, Orders.class);
            repo.save(order);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OrderDTO searchOrder(String id) {
        Optional<Orders> order= repo.findById(id);
        if (order.isPresent()) {
            return mapper.map(order.get(), OrderDTO.class);
        } else {
            throw new RuntimeException("No Order for id: " + id);
        }
    }

    @Override
    public boolean deleteOrder(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<Orders> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<OrderDTO>>() {
        }.getType());
    }

    @Override
    public boolean saveCartOrder(CartItemDTO dto) {
        return false;
    }
}
