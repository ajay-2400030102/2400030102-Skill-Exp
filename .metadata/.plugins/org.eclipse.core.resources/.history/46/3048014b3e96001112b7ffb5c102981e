package soa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.service.CartService;

@RestController
@RequestMapping("/")

public class CartController {
	CartService CS;
	public CartController(CartService CS) {
		this.CS=CS;
		
	}
	@GetMapping("/cart")
	public Object cart() {
		return CS.getAllCartItems();
	}

}
