package com.homework.contestservices.fibonacci.controllers;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homework.contestservices.fibonacci.services.FibonacciImpl;

@RestController
public class FibonacciController {
	 @GetMapping(path = {"/fibonacciArray", "/fibonacciArray/{length}"},
	            produces = {APPLICATION_JSON_VALUE})
	    public @ResponseBody List<BigInteger> getFibonacciArray(HttpServletResponse response, @PathVariable(required = false) Optional<Integer> length) {
	        try {
	        		return FibonacciImpl.getFibonacci(length.orElse(FibonacciImpl.LEN_MAX));
	        } catch (IllegalArgumentException ex) {
	            response.setStatus(FORBIDDEN.value());
	        }
	        return null;
	    }
}
