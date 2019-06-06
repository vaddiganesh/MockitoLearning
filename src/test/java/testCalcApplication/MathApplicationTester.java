package testCalcApplication;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import calcApplication.CalculatorService;
import calcApplication.MathApplication;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication  = new MathApplication();
	
	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;
	
	@Test @Ignore
	public void testAdd() {
		// add the behavior of calc service to add two numbers
		when(calcService.add(10.0, 20.0)).thenReturn(30.00);

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		//verify call to calcService is made or not with same arguments.
		verify(calcService).add(10.0, 20.0);
		
		//verify if add function is called 1 times
		verify(calcService, times(1)).add(10.0, 20.0);
	}
	
	@Test @Ignore
	public void testDivide() {
		when(calcService.divide(20.0, 10.0)).thenReturn(2.0);
		Assert.assertEquals(mathApplication.divide(20.0, 10.0), 2.0, 0);
		Assert.assertEquals(mathApplication.divide(20.0, 10.0), 2.0, 0);
		
		verify(calcService, times(2)).divide(20.0, 10.0);
		
		verify(calcService, never()).multiply(10.0,20.0);
	}
	
	@Test @Ignore
	public void testMultiply() {
		when(calcService.multiply(30.0, 30.0)).thenReturn(90.0);
		Assert.assertEquals(mathApplication.multiply(30.0, 30.0), 90.0, 0);
		Assert.assertEquals(mathApplication.multiply(30.0, 30.0), 90.0, 0);
		Assert.assertEquals(mathApplication.multiply(30.0, 30.0), 90.0, 0);
		
		verify(calcService, atLeastOnce()).multiply(30.0, 30.0);
		
		verify(calcService, atLeast(2)).multiply(30.0, 30.0);
		
		verify(calcService, atMost(3)).multiply(30.0, 30.0);
	}
	
	@Test(expected = RuntimeException.class)
	public void testExceptions() {
		doThrow(new RuntimeException("Substract operation not implemented"))
			.when(calcService).subtract(20.0, 10.0);
		
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
	}
	
	@Test
	public void testExceptions1() {
		doThrow(new RuntimeException("Substract operation not implemented"))
			.when(calcService).subtract(20.0, 10.0);
		
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
	}
}
