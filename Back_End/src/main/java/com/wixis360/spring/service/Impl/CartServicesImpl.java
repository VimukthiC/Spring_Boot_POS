package com.wixis360.spring.service.Impl;

import com.wixis360.spring.dto.CartItemDTO;
//import com.wixis360.spring.dto.HistoryDTO;
import com.wixis360.spring.entity.CartItem;
//import com.wixis360.spring.entity.History;
import com.wixis360.spring.entity.Item;
import com.wixis360.spring.repo.CartItemRepository;
import com.wixis360.spring.repo.CustomerRepo;
//import com.wixis360.spring.repo.HistoryRepo;
import com.wixis360.spring.repo.ItemRepo;
import com.wixis360.spring.service.CartServices;
//import com.wixis360.spring.service.HistoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServicesImpl implements CartServices {

//    @Autowired
//    private HistoryRepo historyRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    ModelMapper mapper;


    @Override
    public boolean saveCart(CartItemDTO dto) {
        if (!cartItemRepository.existsById(dto.getCartId())) {
            CartItem c = mapper.map(dto, CartItem.class);
            cartItemRepository.save(c);


//            if(!historyRepo.existsById(dto.getCartId())) {
//
//
//                    HistoryDTO historyDTO = new HistoryDTO();
//                    historyDTO.setCartId(dto.getCartId());
//                    historyDTO.setCustomerId(dto.getCustomerId());
//                    historyDTO.setUnitPrice(dto.getUnitPrice());
//                    historyDTO.setCartItemQuantity(dto.getCartItemQuantity());
//                    historyDTO.setDate(dto.getDate());
//                    History h=mapper.map(historyDTO,History.class);
//                    historyRepo.save(h);
//
//
//
                Item item = itemRepo.getOne(dto.getItemCode());
                int qty = item.getQtyOnHand() - dto.getCartItemQuantity();
                item.setQtyOnHand(qty);






            return true;
        } else {
            throw new RuntimeException("Cart already exist..!");
        }
    }

    @Override
    public boolean updateCart(CartItemDTO dto) {
        if (cartItemRepository.existsById(dto.getCartId())) {
            CartItem c = mapper.map(dto, CartItem.class);
            cartItemRepository.save(c);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CartItemDTO searchCart(String id) {
        Optional<CartItem> c = cartItemRepository.findById(id);
        if (c.isPresent()) {
            return mapper.map(c.get(), CartItemDTO.class);
        } else {
            throw new RuntimeException("No customer for id: " + id);
        }
    }


    @Override
    public boolean deleteCart(String id) {
        if (cartItemRepository.existsById(id)){
            cartItemRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<CartItemDTO> getAllCart() {
        List<CartItem> all = cartItemRepository.findAll();
        return mapper.map(all, new TypeToken<List<CartItemDTO>>() {
        }.getType());
    }

    //public List<>
}
