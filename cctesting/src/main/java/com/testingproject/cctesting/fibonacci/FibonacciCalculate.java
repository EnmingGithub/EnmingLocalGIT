package com.testingproject.cctesting.fibonacci;

import org.springframework.stereotype.Component;

@Component
public class FibonacciCalculate {
    int[] result;
	public int[] calculate(Integer n){
		result = new int[n+1];
/*		result[0] = 0;
		result[1] = 1;
		for (int i = 2;i<=n;i++){
			result[i] = result[i-1] + result[i-2];
			
		}*/
		result[n] = fib(n);
		return result;
	}
    public int fib ( int n ){
    	if (n<=1){
    		result[n]=n;
    		return n;
    	}
    	result[n] = fib(n-1)+fib(n-2);
    	return result[n];
    }
}
