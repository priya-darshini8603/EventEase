package com.example.EventManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventManager.Entity.orderTransactionDetails;
import com.example.EventManager.Service.orderServices;

@RestController
public class paymentTransactionController 
{
	@Autowired
	private orderServices orderservices;
	@CrossOrigin(origins = "*")
	@GetMapping("/getTransaction/{amount}")
	public orderTransactionDetails getTransaction(@PathVariable(name="amount") double amount) {
        orderTransactionDetails transactionDetails = orderservices.orderCreateTransaction(amount);
        if (transactionDetails != null) {
            return transactionDetails;
        } else {
            return null;  
        }
    }
	
	

}
