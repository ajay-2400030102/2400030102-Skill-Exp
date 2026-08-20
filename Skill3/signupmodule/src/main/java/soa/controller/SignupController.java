package soa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import soa.model.Signup;
import soa.service.SignupService;


@RestController
@RequestMapping("/signup")
public class SignupController {
	SignupService SS;
	public SignupController(SignupService SS) {
		this.SS=SS;
	}
	@PostMapping
	public Object signup(@RequestBody Signup signup) {
		return SS.signup(signup);
	}
	@GetMapping("{username}")
	public Object getuser(@PathVariable String username) {
		return SS.getUser(username);
	}

}

