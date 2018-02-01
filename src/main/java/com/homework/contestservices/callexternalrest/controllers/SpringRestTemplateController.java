package com.homework.contestservices.callexternalrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestTemplateController {
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
}
