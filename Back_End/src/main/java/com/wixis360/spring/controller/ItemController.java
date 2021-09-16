package com.wixis360.spring.controller;

import com.wixis360.spring.dto.ItemDTO;
import com.wixis360.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> addItem(@RequestBody ItemDTO dto){
        System.out.println("Item controller called");
        System.out.println("item controller id "+dto.getItemCode());
        try {
            System.out.println("item controller id "+dto.getItemCode());
            boolean b = itemService.saveItem(dto);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("item controller id "+dto.getItemCode());
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<Boolean> deleteItem(@RequestParam String id) {
        try{
            boolean b = itemService.deleteItem(id);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> updateItem(@RequestBody ItemDTO dto) {
        try{
            boolean b = itemService.updateItem(dto);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchItem(@PathVariable String id) {
        try{
            ItemDTO itemDTO = itemService.searchItem(id);
            return new ResponseEntity( itemDTO,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        try{
            List<ItemDTO> allItem = itemService.getAllItem();
            return new ResponseEntity(allItem,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
