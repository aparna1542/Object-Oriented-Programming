/**
 * 
 */
package cci.Threads;

/**
 * @author Aparna Ganesh
 * Here the shared resource is foo() since 2 instances of this class are trying to access the same method
 * if diff ref of MyObj are passed to this class then both can call foo, if same ref is passed, then 
 * one has to wait
 */
public class SynchronizedMethod extends Thread {

	private String abc;
	private MyObj obj;
	
	public SynchronizedMethod(String str,MyObj obj) {
		this.abc = str;
		this.obj = obj;
	}
	
	
	public void run() {
		obj.foo(abc);
	}
	public static void main(String args[]) {
	//	 Difference references - both threads can call MyObject.foo() 
		MyObj obj1 = new MyObj();
		MyObj obj2 = new MyObj();
		SynchronizedMethod sc1 = new SynchronizedMethod("aparna", obj1);
		SynchronizedMethod sc2 = new SynchronizedMethod("sri", obj2);
		sc1.start();
		sc2.start();
		
		//Same ref, only one is allowed to call foo, other waits
		MyObj obj = new MyObj();
		SynchronizedMethod sc3 = new SynchronizedMethod("gunds", obj);
		SynchronizedMethod sc4 = new SynchronizedMethod("suja", obj);
		sc3.start();
		sc4.start();
		
	}
}

 class MyObj {

	//this method is the shared resource that will be accessed by 2 threads simutaneously
	public synchronized void foo(String abc) {
		System.out.println("Inside synchronised method"+abc);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
			e.printStackTrace();
		}
		System.out.println("Thread ends");
	}
	
	
}