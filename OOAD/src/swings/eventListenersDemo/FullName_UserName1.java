package swings.eventListenersDemo;
// Java core packages
import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;
// GUI has multiple buttons, labels and text fields
// Event handling by an inner class

public class FullName_UserName1 extends JFrame{
   private JButton fullNameBtn;
   private JButton userNameBtn;
   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField resultField;
   private JLabel outputStrLabel;
   private JLabel outputStr;
   private ButtonEventHandler eventHandler;
   
   public FullName_UserName1(){
      super( "TwoButtonDemo" );

      // get content pane
      Container container = getContentPane();
	  container.setLayout( new GridLayout(4,2) );
	  
	  // create  labels
	  JLabel firstNameTxt = new JLabel("FirstName");
	  JLabel lastNameTxt = new JLabel("LastName");
	  outputStrLabel = new JLabel("Result: ");
	  outputStr = new JLabel("-----");
	  
	  // create  textfields
	  firstNameField = new JTextField(10);
	  lastNameField = new JTextField(10);
	  resultField = new JTextField(22);
	  
      // create buttons
      fullNameBtn = new JButton( "Fullname" );
      fullNameBtn.setActionCommand("fullname"); 
      	
      userNameBtn = new JButton("UserName");
      userNameBtn.setActionCommand("username");
     
      // add them all to the container
      container.add( firstNameTxt );
      container.add( firstNameField );	
      container.add( lastNameTxt );
      container.add( lastNameField );	
      	
      container.add( fullNameBtn );	    
      container.add( userNameBtn );
      
      container.add( outputStrLabel );
	  container.add( resultField);
      // Create an EventHandler
     eventHandler = new ButtonEventHandler();
      
      // add event handlers
      fullNameBtn.addActionListener( eventHandler );
      userNameBtn.addActionListener(eventHandler);
      pack();
      setSize(200,200);
      setLocationRelativeTo(null);
      setVisible( true );
   }

   class ButtonEventHandler implements ActionListener { 	
   		public void actionPerformed( ActionEvent event ){
   				
            if (event.getSource() == fullNameBtn){
                resultField.setText(fullName(firstNameField.getText(),
                lastNameField.getText()));           	
            }	
            else if (event.getSource() == userNameBtn){
            	resultField.setText(userName(firstNameField.getText(),
                lastNameField.getText()));  
            }	          	
    	}
    	public String fullName(String first, String last){
    		return last+", "+first;
    	}
    	public String userName(String first, String last){
    		return first.substring(0,1)+last;
    	}   	
   }
   
    public static void main( String [] args ){
     FullName_UserName1 application = new FullName_UserName1();
      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }
}

