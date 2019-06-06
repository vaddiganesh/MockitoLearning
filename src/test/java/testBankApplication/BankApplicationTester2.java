package testBankApplication;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BankApplication.InterestCalculation;
import BankApplication.InterestService;

public class BankApplicationTester2 {

	InterestCalculation ic = null;
	InterestService service = new InterestService();
	
	@Before
	public void setUp() {
		ic = new InterestCalculation();
		service = spy(service);
		ic.setInterestService(service);
	}
	
	@Test
	public void testSavingsAccountBalance() {
		when(service.getBaseRate()).thenReturn(5);
		
		int grossBalance = ic.savingsAccount(500);
		
		Assert.assertEquals(2500, grossBalance);
		
		System.out.println(service.getFloatingRate());
	}
}
