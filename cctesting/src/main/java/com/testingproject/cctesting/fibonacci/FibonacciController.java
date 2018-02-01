package com.testingproject.cctesting.fibonacci;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

	@Autowired
	private FibonacciCalculate fibcal;
	
	@GetMapping(path = "/fibonacci/{number}")

	public Map fibonacci(@PathVariable("number") int n){
		return Collections.singletonMap("N Fibonacci numbers", fibcal.calculate(n));
	}
}
