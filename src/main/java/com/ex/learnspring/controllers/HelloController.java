package com.ex.learnspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
	
	@GetMapping("hello/{id}")
	public String sayInput(@PathVariable("id") String id)
	{
		return "Hello " + id;
	}
}
