package swings.eventListenersDemo;
// Java core packages
import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;

public class ButtonDemo1 extends JFrame implements ActionListener{
   private JButton plainButton;
   private JButton pictureButton;
   
   public ButtonDemo1(){
      super( "ButtonDemo1" );

      // get content pane
      Container container = getContentPane();

      // set the layout
      container.setLayout( new FlowLayout() );

      // create buttons
      plainButton = new JButton( "Plain Button" );
      // You can set the label
      plainButton.setActionCommand("Show message button");
      plainButton.setToolTipText("A plain button");
      container.add( plainButton );

      // add an event handler
      plainButton.addActionListener( this );
      
      pictureButton = new JButton( new ImageIcon("button_blue.jpg"));
      pictureButton.setActionCommand("Blue Button");
      pictureButton.setToolTipText("A picture button");
      container.add( pictureButton );
	  
 	 // add an event handler
      pictureButton.addActionListener( this );
      setSize(600,300);
      setLocationRelativeTo(null);
      setVisible( true );
   }

   public void actionPerformed( ActionEvent event ){
         JOptionPane.showMessageDialog( null,
            "You pressed: " + event.getActionCommand() );
    }

    public static void main( String [] args ){
      ButtonDemo1 application = new ButtonDemo1();
      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }


}

