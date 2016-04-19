package swings.thread;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

class TaskFrame extends JFrame {

 private JLabel countLabel = new JLabel("0");
 private JLabel statusLabel = new JLabel("Task not completed.");
 private JButton startButton = new JButton("Start Now");

 public TaskFrame(String title) {
  super(title);

  setLayout(new FlowLayout());
  countLabel.setFont(new Font("Serif",Font.BOLD,30));
  statusLabel.setFont(new Font("Serif",Font.PLAIN,20));
  add(countLabel);
  add(statusLabel);
  add(startButton);

  startButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    start3();
   }
  });
  setSize(400, 200);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setVisible(true);
 }

 ////////////////////// Bad Way ///////////////////////////////////////////////
 private void start1() {
	 // The bad way. We are updating the GUI from our own thread, not the
	 // Event dispatch thread
	 Thread worker = new Thread() {
		   public void run() {
		    // This may be a long running task
		    for(int i=0; i<=10; i++) {
		     // Bad practice - we are updating the GUI from a thread other than EDT
		    	countLabel.setText(Integer.toString(i));
		     
		     try {
		      Thread.sleep(1000);
		     } catch (InterruptedException e) {
		      
		     }
		    }		    
		    // Bad practice - we are updating the GUI from a thread other than EDT
		    statusLabel.setText("Completed.");
		   }
		  };
		  
		  worker.start();
 }
///////////////////Correct Way -Using SwingUtilities.invokeLater()/////////////////////////
private void start2() {
	 /* A correct way. We are updating the GUI from the
	  Event dispatch thread, using SwingUtilities.invokeLater()
	 The invokeLater() method creates a special event that wraps around the runnable object
	  and places it on the event queue. 
	  When the event-dispatch thread processes that special event, 
	  it invokes the runnable object's run method in the same thread context, 
	  thus preserving thread safety.
	  */
	Thread worker = new Thread() {
		   public void run() {
		    
		    // Simulate a long running task
		    for(int i=0; i<=10; i++) {
		     
		     final int count = i;
		     
		     SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		       countLabel.setForeground(Color.RED);
		       countLabel.setText(Integer.toString(count));
		      }
		     });
		     
		     try {
		      Thread.sleep(1000);
		     } catch (InterruptedException e) {
		      
		     }
		    }
		    
		    SwingUtilities.invokeLater(new Runnable() {
		     public void run() {
		     statusLabel.setForeground(Color.BLUE);	 
		      statusLabel.setText("Done.");
		     }
		    });
		    
		   }
		  };		  
		  worker.start();
}
/* A SwingWorker is useful when a time-consuming task has to be performed 
Performs the task on a background thread and keeps the GUI responsive meanwhile.
It provides two methods that developers can override, the doInBackground() and the 
done() methods. The SwingWorker class creates a new thread to run the code within 
the doInBackground() method. 
The done() method's code runs on the event-dispatch thread after the doInBackground() 
method completes. 
In the event-handling logic, the developer can provide the implementation for these methods.
 in an anonymous class that inherits from the SwingWorker class.
 
The SwingWorker class is a generic class that takes two type parameters <T,V>, where T is 
the data type of the result returned by the doInBackground() method; 
and V is the data type of intermediate values to be published by the doInBackground() method. 
SwingWorker is only designed to be executed once. Executing a SwingWorker more than once will not result in invoking the doInBackground
 method twice. 
Ref: http://docs.oracle.com/javase/7/docs/api/javax/swing/SwingWorker.html
*/
///////////////////Correct Way -Using SwingWorker()/////////////////////////
private void start3() {	
	// Updates the GUI after the task is done
	SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
		   @Override
		   protected Boolean doInBackground() throws Exception {
		    for (int i = 0; i <= 10; i++) {
		    	Thread.sleep(1000);
		    	System.out.println("Running " + i);
		    }
		    // Here we can return some object of whatever type
		    // we specified for the first template parameter.
		    // 
		    return true;
		   }
		   // Runs on EDT and is allowed to update GUI
		   protected void done() {		    
			   boolean status;
			   try {
				   // Retrieve the return value of doInBackground().
				   status = get();   
				   statusLabel.setText("Done - status: " + status);
				   statusLabel.setForeground(Color.BLUE);	
		   		} catch (InterruptedException e) {}
		   		catch (ExecutionException e) {
		   			// This is thrown if we throw an exception
		   			// from doInBackground.
		   		}
		   }
		 		   
		  };		  
		  worker.execute();		  
}

//////////////Correct Way -Using SwingWorker() to show intermediate results//////////////////
private void start4() {
	// Updates the GUI as the task is performed
	 SwingWorker<Boolean, Integer> worker = new SwingWorker<Boolean, Integer>() {
		   @Override
		   protected Boolean doInBackground() throws Exception {
		    for (int i = 0; i <= 10; i++) {
		     Thread.sleep(1000);
		     
		     // The type we pass to publish() is determined
		     // by the second template parameter.
		     // This method is to be used from inside the doInBackground method to deliver 
		     // intermediate results for processing on the EDT inside 
		     // the process method. 
		     publish(i);
		    }

		    // Here we can return some object of whatever type
		    // we specified for the first template parameter.
		    return true;
		   }

		   // Can safely update the GUI from this method.
		   protected void done() {
		    
		    boolean status;
		    try {
		     // Retrieve the return value of doInBackground.
		     status = get();
		     statusLabel.setForeground(Color.BLUE);
		     statusLabel.setText("Done - status: " + status);
		     
		    } catch (InterruptedException e) {}
		      catch (ExecutionException e) {
		     // This is thrown if we throw an exception
		     // from doInBackground.
		    }
		   }
		   @Override
		   // Runs on EDT and is allowed to update GUI
		   protected void process(List<Integer> chunks) {
		    // Here we receive the values that we publish().
		    // They may come grouped in chunks.
		    int mostRecentValue = chunks.get(chunks.size()-1);
		    countLabel.setForeground(Color.RED);
		    countLabel.setText(Integer.toString(mostRecentValue));
		   }		   
		   
		  };
		  
		  worker.execute();	  
}
}

//////////////////////////////////////////////////////////////////////////////////////////
public class SwingWorkerDemo {

	 public static void main(String[] args) {
		  SwingUtilities.invokeLater(new Runnable() {		   
		   @Override
		   public void run() {
		    new TaskFrame("SwingThreads Demo");
		   }
		  });
		 }

}


