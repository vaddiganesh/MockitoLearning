package testCalcApplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;

import calcApplication.CalculatorService;
import calcApplication.MathApplication;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester1 {

	private MathApplication mathApplication;
	private CalculatorService calcService;
	
	@Before
	public void setUp() {
		mathApplication = new MathApplication();
		calcService = mock(CalculatorService.class);
		mathApplication.setCalculatorService(calcService);
	}
	
	@Test @Ignore
	public void test() {
		when(calcService.add(10.0, 20.0)).thenReturn(30.0);
		
		when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);
		
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
	}
	
	@Test
	public void testInorder() {
		when(calcService.add(10.0, 20.0)).thenReturn(30.0);
		
		when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);
		
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
		
//		//create an inOrder verifier for a single mock
//		InOrder inOrder = inOrder(calcService);
//		
//		//following will make sure that add is first called then subtract is called.
//		inOrder.verify(calcService).subtract(20.0, 10.0);
//		inOrder.verify(calcService).add(10.0, 20.0);
	}

}
