package swings.eventListenersDemo;
// Java core packages
import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;

public class ButtonDemo3 extends JFrame {
   private JButton plainButton;
  
   public ButtonDemo3(){
      super( "ButtonDemo3" );

      // get content pane
      Container container = getContentPane();

      // set the layout
      container.setLayout( new FlowLayout() );

      // create buttons
      plainButton = new JButton( "Plain Button" );
      plainButton.setActionCommand("Plain Button");
      container.add( plainButton );    

      // Use an anonymous class as an event handler
      plainButton.addActionListener( new ActionListener() 
      {     	
      		public void actionPerformed(ActionEvent event){    				
      			JOptionPane.showMessageDialog( null,
            "You pressed: " + event.getActionCommand() );
      		}
      
      });

      setSize(600,300);
      setVisible( true );
   }

   // execute application
   public static void main( String [] args )
   {
      ButtonDemo3 application = new ButtonDemo3();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

   

}  // end class ButtonDemo3

