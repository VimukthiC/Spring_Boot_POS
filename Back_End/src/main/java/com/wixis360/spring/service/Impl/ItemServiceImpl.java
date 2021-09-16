package com.wixis360.spring.service.Impl;

import com.wixis360.spring.dto.ItemDTO;
import com.wixis360.spring.entity.Item;
import com.wixis360.spring.repo.ItemRepo;
import com.wixis360.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public boolean saveItem(ItemDTO dto) {
        System.out.println("Call Item service ");
        System.out.println("Item service"+dto.getItemCode());
        if (!repo.existsById(dto.getItemCode())) {
            System.out.println("Call Item true service");
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
            return true;
        } else {
            throw new RuntimeException("Item already exist..!");
        }
    }

    @Override
    public boolean updateItem(ItemDTO dto) {
        if (repo.existsById(dto.getItemCode())) {
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
            return true;
        } else {
            throw new RuntimeException("No such Item for update..!");
        }
    }

    @Override
    public ItemDTO searchItem(String id) {
        Optional<Item> item = repo.findById(id);
        if (item.isPresent()) {
            return mapper.map(item.get(), ItemDTO.class);
        } else {
            throw new RuntimeException("No Item for id: " + id);
        }
    }

    @Override
    public boolean deleteItem(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("No Item for delete ID: " + id);
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDTO>>() {
        }.getType());
    }
}
