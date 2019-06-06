package testStockApplication;

import java.util.ArrayList;
import java.util.List;

import stockApplication.*;

import static org.mockito.Mockito.*;

public class PortfolioTester {

	Portfolio portfolio;
	StockService stockService;
	
	public static void main(String[] args) {
		PortfolioTester tester = new PortfolioTester();
		tester.setUp();
		System.out.println(tester.testMarketValue()?"pass":"fail");
	}

	public void setUp() {
		portfolio = new Portfolio();
		stockService = mock(StockService.class);
		portfolio.setStockService(stockService);
	}
	
	public boolean testMarketValue() {
		List<Stock> stocks = new ArrayList<Stock>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock fbStock = new Stock("2", "Facebook", 20);
		
		stocks.add(googleStock);
		stocks.add(fbStock);
		
		portfolio.setStocks(stocks);
		
		when(stockService.getPrice(googleStock)).thenReturn(50.00);
		when(stockService.getPrice(fbStock)).thenReturn(1000.00);
		
		double marketValue = portfolio.getMarketValue();
		
		return marketValue == 20500.0;
	}
}
