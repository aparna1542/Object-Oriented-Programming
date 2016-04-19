/**
 * 
 */
package cci.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Aparna Ganesh
 *
 */
public class LockATM implements Runnable {


	Lock lock;
	int balance = 200; //shared resource
	
	public LockATM() {
		 lock = new ReentrantLock();
		 
	}
	@Override
	public void run() {
	if(Thread.currentThread().getName().equals("withdraw")) {
		withdraw(10);
	}
	else
		deposit(20);
	}
	public void withdraw(int amt) {
		lock.lock();
		//int temp = balance;
		try {
			balance = balance - amt;
			System.out.println("Balance after withdrawal "+balance);
			Thread.sleep(1000);
			
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		
		
	}
	public void deposit(int amt) {
		lock.lock();
		
		try {
			balance = balance + amt;
			
			System.out.println("Balance after deposit "+balance);
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	public static void main(String args[]) {
		LockATM obj = new LockATM();
		Thread t1 = new Thread(obj,"withdraw");
		Thread t2 = new Thread(obj);
		t1.start();
		t2.start();
	}
}
