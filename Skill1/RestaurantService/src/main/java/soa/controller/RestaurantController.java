package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.service.RestaurantService;

@RestController
@RequestMapping("api")
public class RestaurantController {
@Autowired
RestaurantService RS;

public RestaurantController(RestaurantService RS) {
	this.RS=RS;
}
@GetMapping("restaurants")
public Object restaurant() {
	return RS.getAllRestaurants();
}
}
