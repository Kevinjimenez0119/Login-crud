package com.example.demo.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.User;





@Controller
public class AppController {
	
	
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public  String hello(){
		return "menu";
	}
	
	
	
	@GetMapping("/user")
	public  String user(){
		return "user";
	}
	
	@GetMapping("/admin")
	public  String admin(){
		return "admin";
	}
	
}
