package com.wixis360.spring.repo;

import com.wixis360.spring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {
}
