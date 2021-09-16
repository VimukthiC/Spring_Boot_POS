package com.wixis360.spring.repo;

import com.wixis360.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepo extends JpaRepository<Customer,String> {
}











































































//    Customer findCustomerByName(String name);
//
//    List<Customer> findAllByAddress(String address);
//
//    long countAllById(String id);
//
//    Customer findCustomerByNameAndAddress(String name, String address);
//
//    List<Customer> findCustomerByAddressContaining(String address);
//
//    @Query(value="select * from customer where id='C001'",nativeQuery=true)
//    Customer getCustomer();
//
//
//    //Positional params
//    @Query(value="select * from customer where id=?1 and name=?2",nativeQuery=true)
//    Customer getCustomer2(String id, String name);
//
//    //Named patams
//    @Query(value="select * from customer where id=:myId and name=:myName",nativeQuery=true)
//    Customer getCustomer3(@Param("myId") String id,@Param("myName") String name);
//
//    //jpql
//    @Query(value="select C from Customer C")
//    List<Customer> allCustomer();
//
//    @Query(value = "select c from Customer c where c.id=?1 ")
//    Customer searchACustomerByJPQL(String id);
//
//    //hql
////    @Query(value="from Customer C")
////    List<Customer> allCustomer();


