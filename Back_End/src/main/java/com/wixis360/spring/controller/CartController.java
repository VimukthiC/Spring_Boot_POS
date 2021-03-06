package com.wixis360.spring.controller;

import com.wixis360.spring.dto.CartItemDTO;

import com.wixis360.spring.dto.OrderDTO;
import com.wixis360.spring.service.CartServices;
import com.wixis360.spring.service.CustomerService;
import com.wixis360.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartServices cartServices;

    @Autowired
    ModelMapper mapper;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> addCart(@RequestBody CartItemDTO dto){
        System.out.println(dto);
        try {
            boolean b = cartServices.saveCart(dto);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(params = {"id"})
    public ResponseEntity<Boolean> deleteCart(@RequestParam String id) {
        try {
            boolean b = cartServices.deleteCart(id);
            return new ResponseEntity<>(b, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Boolean> updateCart(@RequestBody CartItemDTO dto) {
        try {
            boolean b = cartServices.updateCart(dto);
            return new ResponseEntity<>(b, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCart(@PathVariable String id) {
        try {
            CartItemDTO cartItemDTO = cartServices.searchCart(id);
            return new ResponseEntity(cartItemDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity getAllCart() {
        try {
            List<CartItemDTO> allCustomers = cartServices.getAllCart();


            return new ResponseEntity(allCustomers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
