/**
 * 
 */
package cci.Threads;

/**
 * @author Aparna Ganesh
 *
 */
public class SynchronisedBlock extends Thread {
	
	private MyObject obj;
	private String name =null;
	
	public SynchronisedBlock(String name,MyObject obj){
		this.name = name;
		this.obj = obj;
			}
	public void run() {
		obj.foo();
	}
	public static void main(String args[]) {
		MyObject obj = new MyObject();
		
		SynchronisedBlock thread1 =new SynchronisedBlock("aparna", obj);
		SynchronisedBlock thread2 =new SynchronisedBlock("sri", obj);
		//both threads are calling the foo on same object,one waits for other
		thread1.start();
		thread2.start();
	}

}

class MyObject {

	//shared resource,synchronized block
	
	public void foo() {
		synchronized (this) {
			try {
				System.out.println("thread starts");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
				e.printStackTrace();
			}
			System.out.println("Thread ends");	
		}
		
	}
}