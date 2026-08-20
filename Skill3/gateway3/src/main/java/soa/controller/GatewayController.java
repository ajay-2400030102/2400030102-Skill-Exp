package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.service.GatewayService;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    GatewayService service;

    @GetMapping("/signup/{username}")
    public Object getUser(@PathVariable String username) {
        return service.invokeService("signupmodule", "signup/" + username);
    }

    @PostMapping("/login")
    public Object login(@RequestBody Object login) {
        return service.invokePostService("loginmodule", "login", login);
    }

    @PostMapping("/signup")
    public Object signup(@RequestBody Object signup) {
        return service.invokePostService("signupmodule", "signup", signup);
    }
}