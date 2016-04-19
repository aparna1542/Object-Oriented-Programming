package swings.eventListenersDemo;
import javax.swing.*;   
import java.awt.*;      
import java.util.*;      
import java.awt.event.*; 

class Listeners2 extends JFrame{ 
  
	//Data Members
  private JTextField output = new JTextField( "", 10 );
  private Random rnd = new Random(); 

  public Listeners2() {

    super( "Listeners - 2" );

    getContentPane().setLayout( new FlowLayout() );

    // Create the buttons with the labels
    JButton next  = new JButton( "Next" );
    JButton clear = new JButton( "Clear" );
    
    // Add the buttons and the text field to the content pane of the frame
    getContentPane().add( next );
    getContentPane().add( clear );
    getContentPane().add(output );
   
    // Add the event listeners which are objects of the inner classes
   next.addActionListener( new NextActionListener() ); 
   clear.addActionListener( new ClearActionListener() );

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pack();                 

    setVisible(true);
  }
 
  	// Inner classes to handle the events
 private class NextActionListener implements ActionListener {
     public void actionPerformed( ActionEvent e ) {
    	 int min = 10;
    	 int max = 80;
    	 output.setText( "" + (rnd.nextInt(max-min+1)+min ) );
     }
   }  
 private class ClearActionListener implements ActionListener {
   public void actionPerformed( ActionEvent e ) {
     output.setText( "" );
   }
 }

 
}
public class ListenerDemo2 {

	public static void main( String args[] ) { 
		  new Listeners2(); 
	  }


}
