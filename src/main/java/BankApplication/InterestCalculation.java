package BankApplication;

public class InterestCalculation {

	private InterestService ser = null;
	
	public void setInterestService(InterestService service) {
		this.ser = service;
	}
	
	public int getInterestRate() {
		return ser.getBaseRate();
	}
	
	public int savingsAccount(int balance) {
		return balance * getInterestRate();
	}
	
	public int currentAccount (int balance) {
		return balance * (getInterestRate()/2);
	}
	
	public int fixedDeposit (int balance) {
		return balance * (getInterestRate()*2);
	}
}
