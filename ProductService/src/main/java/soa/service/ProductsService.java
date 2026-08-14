package soa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import soa.model.Products;
import soa.repo.ProductRepo;

@Service
public class ProductsService {

	ProductRepo PR;
	public ProductsService(ProductRepo PR) {
		this.PR=PR;
	}
	public Object getAllProducts() {
		Map<String, Object> response=new HashMap<>();
		try {
			List<Products> products=PR.findAll();
			response.put("products", products);
			
		}catch(Exception e) {
			response.put("code", 500);
		    response.put("message", e.getMessage());

		}
		return response;
	}
}
