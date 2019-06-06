package testCalcApplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calcApplication.CalculatorService;
import calcApplication.MathApplication;
import static org.mockito.Mockito.spy;

public class MathApplicationTester2 {

	private MathApplication mathApplication;
	private CalculatorService calcService;
	
	@Before
	public void setUp() {
		mathApplication = new MathApplication();
		Calculator calc = new Calculator();
		calcService = spy(calc);
		mathApplication.setCalculatorService(calcService);
	}
	
	@Test
	public void test() {
		//perform operation on real object
	    //test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
	}
	
	class Calculator implements CalculatorService {

		@Override
		public double add(double input1, double input2) {
			return input1 + input2;
		}

		@Override
		public double subtract(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}

		@Override
		public double multiply(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}

		@Override
		public double divide(double input1, double input2) {
			throw new UnsupportedOperationException("Method not implemented yet!");
		}
		
	}
}
