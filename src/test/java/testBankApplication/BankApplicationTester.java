package testBankApplication;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import BankApplication.InterestCalculation;
import BankApplication.InterestService;
import org.junit.Assert;

public class BankApplicationTester {

	InterestCalculation ic = null;
	InterestService service = null;
	
	@Before
	public void setUp() {
		ic = new InterestCalculation();
		service = mock(InterestService.class);
		ic.setInterestService(service);
	}

	@Test
	public void testSavingsAccountBalance() {
		when(service.getBaseRate()).thenReturn(5);
		
		int grossBalance = ic.savingsAccount(500);
		
		Assert.assertEquals(2500, grossBalance);
	}
}
