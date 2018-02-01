package com.homework.contestservices.helloworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
}
