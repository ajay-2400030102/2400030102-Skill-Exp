package soa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soa.models.Order;

@Repository
public interface Orderservicerepo extends JpaRepository<Order, Long> {

}