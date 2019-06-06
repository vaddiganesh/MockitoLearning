package testBankApplication;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import BankApplication.InterestCalculation;
import BankApplication.InterestService;

public class BankApplicationTester1 {

	@InjectMocks
	InterestCalculation ic = new InterestCalculation();
	
	@Mock
	InterestService service;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCurrentAccountBalance() {
		when(service.getBaseRate()).thenReturn(10);
		
		System.out.println(ic.currentAccount(1000));
	}
	
}
