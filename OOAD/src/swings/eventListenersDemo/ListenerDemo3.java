package swings.eventListenersDemo;
import javax.swing.*;   
import java.awt.*;      
import java.util.*;      
import java.awt.event.*; 

class Listeners3 extends JFrame{ 
  
	// Data members
  private JTextField output = new JTextField( "", 10 );
  private Random rnd = new Random(); 

  public Listeners3() {
    super( "Listeners - 3" );

    getContentPane().setLayout( new FlowLayout() );

    // Create the buttons with the labels
    JButton next  = new JButton( "Next" );
    JButton clear = new JButton( "Clear" );
    
    // Add the buttons and the text field to the content pane of the frame
    getContentPane().add( next );
    getContentPane().add( clear );
    getContentPane().add(output );
   
    // Add an instance of an anonymous action listener
    
    ActionListener next_al = new ActionListener() { 
	  public void actionPerformed( ActionEvent e ) {
		  int min = 10;
	    	 int max = 80;
	    	 output.setText( "" + (rnd.nextInt(max-min+1)+min ) );
	  }
	};
   next.addActionListener( next_al );
   
   clear.addActionListener( 
			new ActionListener() { 
			  public void actionPerformed( ActionEvent e ) {
			    output.setText( "" );
			  }
			}
   );  

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    pack();                 

    setVisible(true);
  }
 
 
 
}
public class ListenerDemo3 {

	public static void main( String args[] ) { 
		  new Listeners3(); 
	  }


}
