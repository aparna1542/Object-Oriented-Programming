package swings.eventListenersDemo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonDemo2 extends JFrame {
   private JButton plainButton;

   public ButtonDemo2(){
      super( "ButtonDemo2" );
      // get content pane
      Container container = getContentPane();
      // set the layout
      container.setLayout( new FlowLayout() );
      // create buttons
      plainButton = new JButton( "Click Here" );
      plainButton.setActionCommand("Plain Button");
      container.add( plainButton );
      

      // create an instance of inner class ButtonHandler
      // to use for button event handling

      ButtonHandler handler = new ButtonHandler();
     
      plainButton.addActionListener( handler );

      setSize(600,300);
      setVisible( true );
   }
   
   // inner class for button event handling
   private class ButtonHandler implements ActionListener {
      // handle button event
      public void actionPerformed( ActionEvent event ){
         JOptionPane.showMessageDialog( null,
            "You pressed: " + event.getActionCommand() );
      }
   } // end private inner class ButtonHandler
     // execute application
   public static void main( String [] args ){
      ButtonDemo2 application = new ButtonDemo2();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }
}  // end class ButtonDemo2

