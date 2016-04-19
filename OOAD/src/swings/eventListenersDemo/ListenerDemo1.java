package swings.eventListenersDemo;
import javax.swing.*;   
import java.awt.*;      
import java.util.*;      
import java.awt.event.*;

// Event Management where the top-level container window acts 
// as the event listener
class Listeners1 extends JFrame implements ActionListener { 
	
  // Data members
  private JTextField output = new JTextField( "", 10 );

  private Random rnd = new Random(); 

  // Constructor
  public Listeners1() {
    super( "Listeners - 1" );

    // set teh layout manager
    getContentPane().setLayout( new FlowLayout() );

    // Create the buttons with the labels
    JButton next  = new JButton( "Next" );
    JButton clear = new JButton( "Clear" );
    
    
    
    // Add the buttons and the text field to the content pane
    // of the frame
    getContentPane().add( next );
    getContentPane().add( clear );
    getContentPane().add(output );
   
    // Register the event handler
    next.addActionListener( this );  
    clear.addActionListener( this );

    // Set the action commands - different from the labels.
    next.setActionCommand( "n" ); 
    clear.setActionCommand( "c" );
        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();         
    setVisible(true);
  }

// Code to handle the button -clicks
 public void actionPerformed( ActionEvent e ){
    
	 // Get the command to check which button object
	 // it is coming from
	 String command = e.getActionCommand();

    int min = 10;
    int max = 80;
    
    if (command.equals( "n" )) {
      output.setText( "" + (rnd.nextInt(max-min+1)+min ) );
    }
    else if (command.equals( "c" )) {
      output.setText( "" );
    }
  }
}
public class ListenerDemo1 {

	public static void main( String args[] ) { 
		  new Listeners1(); 
	  }


}
