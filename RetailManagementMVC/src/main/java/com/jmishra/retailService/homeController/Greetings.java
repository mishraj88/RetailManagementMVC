package com.jmishra.retailService.homeController;

//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetings {

	@RequestMapping("/")
	public String greet(){
		return "Hello! Welcome to Shop service Rest Services!";
	}
	
}
