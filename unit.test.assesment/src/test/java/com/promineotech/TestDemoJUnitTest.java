package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectedException) {
		
		if(!expectedException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
		static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
			// works with no exception triggered
			arguments(2, 4, 6, false),
			// works with an exception triggered by negative number
			arguments(-1, 3, 2, true),
			// works with 0 and triggered exception
			arguments(0, 1, 1, true),
			// doesn't work because no exception triggered but expecting exception change "true" to false if you want no error
			arguments(1, 1, 2, true),
			// doesn't work because the expected output isn't correct. change the "9" to an 8 if you want no errors
			arguments(4, 4, 9, false)
		);
		// @formatter:on
		
	}

		@Test
		void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
			assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
			assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
			}
		
		// my work for section 3
		@Test
		void assertThatPairsOfPositiveNumbersAreMulitplied() {
			assertThat(testDemo.multiplyPositive(4, 5)).isEqualTo(20);
			assertThat(testDemo.multiplyPositive(1, 15)).isEqualTo(15);
			assertThat(testDemo.multiplyPositive(3, 8)).isEqualTo(24);
			assertThat(testDemo.multiplyPositive(4, 10)).isEqualTo(40);
		}
		
		@Test
		void assertThatNumberSquaredIsCorrect() {
			TestDemo mockDemo = spy(testDemo);
			
			doReturn(6).when(mockDemo).getRandomInt();
			int sixSquared = mockDemo.randomNumberSquared();
			assertThat(sixSquared).isEqualTo(36);
		}
}
