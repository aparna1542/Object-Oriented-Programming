package covar_contravar_innerClasses;

class Payment {   }
class CashPayment extends Payment{   } 
class CreditPayment extends Payment {} 
class Store{        

	public void acceptPayment (Payment p)     
	{
		System.out.println ("Store::Payment");
	}     
} 

class FastFoodStore extends Store 
{     
	public void acceptPayment (CashPayment c)     
	{
		System.out.println ("FastFoodStore::CashPayment");

	}          

	public void acceptPayment (Payment p)     

	{
		System.out.println ("FastFoodStore::Payment");}          

	public void giveChange()  {
		System.out.println ("FastFoodStore::giveChange()");
	}       

} /////////////////////////////////////////////////////////////// 

public class Q3 {   

	public static void main(String [] args)
	{      
		Store store1 = new Store();         
		FastFoodStore sandwitchPlace = new FastFoodStore ();         
		Store store2 = new FastFoodStore();                  
		Payment p1 = new Payment();         
		CashPayment cp = new CashPayment();         
		Payment p2 = new CashPayment();                     
		store1.acceptPayment (p1);         
		store1.acceptPayment (cp);         
		store1.acceptPayment (p2);                          
		sandwitchPlace.acceptPayment (p1);         
		sandwitchPlace.acceptPayment (cp);         
		sandwitchPlace.acceptPayment (p2);                  
		store2.acceptPayment (p1);         
		store2.acceptPayment (cp);         
		store2.acceptPayment (p2);    
	//	store2.giveChange();   //compile err coz there is not method giveChange() in Store class
	} }