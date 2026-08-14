package soa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soa.model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long>{

}
