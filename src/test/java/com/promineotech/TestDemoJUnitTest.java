package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy; 

 class TestDemoJUnitTest {

	
	private TestDemo  testDemo; 
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

		
	@Test
	@MethodSource("com.promineotech.TestDemoJUnitTest#assertThatPairsOfPositiveNumbersAreAddedCorrectly")
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {


		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);


		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);

		assertThat(testDemo.addPositive(10,20)).isEqualTo(30);
		
		
		

	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a , int b , int expected , boolean expectException) {



		if(!expectException) {
		
		  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);


			assertThatThrownBy( () -> testDemo.addPositive(a, b) )
			.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	
	static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
				arguments(2, 4, 6, true),
				arguments(0, 0, 0, true),
				arguments(-1, 2, -1, false),
				arguments(1, -2, 0, true)
         );
		
		
		
	}
	
		/* My own jUnit TEst for "isEven()"
		 *  The goal here is to test all cases where a number can't be even or has an illegal parameter input
		 */ 
		
	   @ParameterizedTest
	    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForEvenNumbers")
	    void assertThatNumberIsEven(int a, boolean expected, boolean expectException) {
	        if (!expectException) {
	            assertThat(testDemo.isEven(a)).isEqualTo(expected);
	        } else {
	            assertThatThrownBy(() -> testDemo.isEven(a))
	                    .isInstanceOf(IllegalArgumentException.class);
	        }
	    }

	    static Stream<Arguments> argumentsForEvenNumbers() {
	        return Stream.of(
	                // arguments: a, expected, expectException
	                Arguments.of(2, true, false),
	                Arguments.of(-1, false, false),
	                Arguments.of(0, true, false),
	                Arguments.of(1, false, false)
	        );
	    }
		
 
	
	    @Test
	    @MethodSource("com.promineotech.TestDemoJUnitTest#assertThatNumberSquaredIsCorrect")
	    void assertThatNumberSquaredIsCorrect() {
	    	TestDemo mockDemo = spy(testDemo);
	    	
	    	doReturn(5).when(mockDemo).getRandomInt();
	    	
	    	int fiveSquared = mockDemo.randomNumberSquared();
	    	
	    	assertThat(fiveSquared).isEqualTo(25);
	    	
	    	
	    }
	
	
}
