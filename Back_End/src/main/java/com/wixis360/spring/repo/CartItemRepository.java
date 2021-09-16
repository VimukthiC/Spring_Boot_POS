package com.wixis360.spring.repo;


import com.wixis360.spring.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemRepository extends JpaRepository<CartItem,String> {
}
