package soa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import soa.model.Cart;
import soa.repo.CartRepo;
@Service

public class CartService {
	CartRepo CR;
	public CartService(CartRepo CR) {
		this.CR=CR;
	}
	public Object getAllCartItems() {
		Map<String, Object> response=new HashMap<>();
		try {
			List<Cart> carts=CR.findAll();
			response.put("carts", carts);
	
		}catch(Exception e) {
			response.put("code", 500);
		     response.put("message", e.getMessage());

		}
		return response;
		
	}

}

