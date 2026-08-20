package soa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import soa.model.Signup;

public interface SignupRepo extends JpaRepository<Signup, String> {
	Signup findByUsername(String username); 

}