package com.homework.contestservices.deadlockmonitor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeadlockMonitorController {
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
}
