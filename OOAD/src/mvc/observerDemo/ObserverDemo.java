package mvc.observerDemo;       
import java.util.*;

/* Demonstrates the Observer pattern - version 1 */

/////////////////////////////////////////////////////////////////////////////
class Stock extends java.util.Observable
{
	private String name;
	private double price;
	
	public Stock(String name, double price)
	{
		this.name = name;
		this.price = price;
		System.out.println("Stock created " + name + "," + price);
	}
	
	public String toString(){return name;}
	
	public String getName(){return name;}
	public double getPrice(){return price;}
	
	public void setPrice(double price){
		double oldPrice = this.price;
		this.price = price;
		
		setChanged();
		notifyObservers(new Double (oldPrice));
			
		
	}		
}


///////////////////////////////////////////////////////////////////////////////
class StockView implements Observer {
	
	private Stock stockToWatch;
	
	
	public StockView(Stock stock) {
		
		this.stockToWatch = stock;
		stock.addObserver(this);
			
	}
	
	public void update (Observable ob,Object oldPrice ){
		
		double price = ((Stock)ob).getPrice();
		
		System.out.println("Stock price changed from  " + oldPrice + " to " + price);
		
	}
	
	
}

//XML representation of the changed price
class StockView1 implements Observer {
	
	private Stock stockToWatch;
	
	
	public StockView1(Stock stock) {
		
		this.stockToWatch = stock;
		stock.addObserver(this);
			
	}
	
	public void update (Observable ob,Object oldPrice ){
		
		double price = ((Stock)ob).getPrice();
		
		System.out.println("<price>"+ price + "</price>");
		
		
	}
	
	
}

/////////////////////////////////////////////////////////////////////////////
public class ObserverDemo {
	
	public static void main(String [] args){
		
	
		Stock stock1 = new Stock ("IBM",75.00);
		
		StockView view1 = new StockView(stock1);
		StockView1 view2 = new StockView1(stock1);
						
		
		for (int i = 30; i < 100; i+=10){
			
			stock1.setPrice(i);
			
			
		}
		
	}	

}
