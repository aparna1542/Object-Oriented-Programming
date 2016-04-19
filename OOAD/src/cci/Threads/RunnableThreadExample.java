/**
 * 
 */
package cci.Threads;

/**
 * @author Aparna Ganesh
 * Demo class to show how to use threading using Runnable interface
 */
public class RunnableThreadExample implements Runnable {

	private int count = 0;
	@Override
	public void run() {
		System.out.println("Thread exec starts");
		while(count<0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
				e.printStackTrace();
			}
			count++;
		}
		System.out.println("thread exec ends");
	}
	public static void main(String args[]) {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread t = new Thread(instance);
		t.start();
	}

}
