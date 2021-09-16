package com.wixis360.spring.service;

import com.wixis360.spring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    boolean saveItem(ItemDTO dto);
    boolean updateItem(ItemDTO dto);
    ItemDTO searchItem(String id);
    boolean deleteItem(String id);
    List<ItemDTO> getAllItem();
}
