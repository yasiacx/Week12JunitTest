package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		
		if(a > 0 && b > 0 ) {
			return a+b;
		}else if( ( a < 0 || a == 0) || ( b < 0 || b == 0)  ) {
			
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
		
		return a+b;
	}
	
	
	/**
     * Checks if a number is even.
     *
     * @param number The number to be checked.
     * @return True if the number is even, false otherwise.
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    
    
    public int randomNumberSquared() {
    	
    	int storedNumber = getRandomInt();
    	
    	return storedNumber * storedNumber;
    }

	public int getRandomInt() {
	
	    Random random = new Random();
	
 	    
	    return random.nextInt(10) + 1;
	
	}

    
}

