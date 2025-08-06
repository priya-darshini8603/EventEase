package com.example.EventManager.Service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.example.EventManager.Entity.orderTransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class orderServices {
	
	private static final String KEY="rzp_test_DH3wBzUKJQ00cF";
	private static final String KEY_SECRET="71jKZ8NYF5DQB39a5h5AWZ7a";
	private static final String CURRENCY="INR";
	public orderTransactionDetails orderCreateTransaction(double amount)
	{
	try {
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("amount", amount*100);
	jsonObject.put("currency", CURRENCY);
	RazorpayClient razorpayClient=new RazorpayClient(KEY,

	KEY_SECRET);

	Order order= razorpayClient.orders.create(jsonObject);
	return orderTransaction(order);
	} catch (Exception e) {
	System.out.println(e.getMessage());
	}
	return null;
	}
	private orderTransactionDetails orderTransaction(Order order)
	{
	String orderid=order.get("id");
	String currency=order.get("currency");
	int amount=order.get("amount");
	orderTransactionDetails orderTransactionDetails=new

	orderTransactionDetails(orderid, currency, amount,KEY);

	return orderTransactionDetails;
	}

}
