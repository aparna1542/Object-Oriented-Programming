package mvc.observerDemo;       
import java.util.*;

/* Demonstrates the observer pattern - Version 2 */

class Asset {};

/////////////////////////////////////////////////////////////////////////////
class Stock1 extends Asset 
{
	private String name;
	private double price;
	
	private ObservableDelegate delegate;
	
	public Stock1(String name, double price)
	{
		this.name = name;
		this.price = price;
		delegate = new ObservableDelegate();
	}
	
	public String toString(){return name;}
	
	public String getName(){return name;}
	public double getPrice(){return price;}
	
	public void setPrice(double price){
		
		this.price = price;
		
		delegate.setChanged();
		delegate.notifyObservers(new Double (price));			
		
	}
	
	public Observable getObservable() { 
		return delegate;
		}
	public void addObserver (Observer ob) { 
		delegate.addObserver(ob);
		}
	
			
}
/////////////////////////////////////////////////////////////////////////////
class ObservableDelegate extends java.util.Observable {
	
	/* Open up the access permissions of these methods
	 * Defined as protected methods in super class */
	
	public void clearChanged() { super.clearChanged();}
	
	public void setChanged() { super.setChanged();}
		
}
///////////////////////////////////////////////////////////////////////////////
class StockView2 implements Observer {
	
	private Stock1 stockToWatch;
	
	
	public StockView2(Stock1 stock) {
		
		this.stockToWatch = stock;
		
		stock.addObserver(this);
			
	}	
	public void update (Observable ob,Object stockPrice ){
		
		String price = ((Double)stockPrice).toString();
		
		System.out.println("Stock price changed: " +price);
		
	}	
	
}
/////////////////////////////////////////////////////////////////////////////
public class ObserverDemo2 {
	
	public static void main(String [] args){
	
		
		Stock1 stock1 = new Stock1 ("IBM",75.00);
		
		StockView2 view1 = new StockView2(stock1);
		
		//stock1.getObservable().addObserver(view1);				
		
		for (int i = 30; i < 100; i+=10){
			
			stock1.setPrice(i);
			
			
		}
		
	}	

}
