package swings.eventListenersDemo;
// Java core packages
import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;

// GUI has multiple buttons, labels and text fields
// Event handling by anonymous classes

public class FullName_UserName2 extends JFrame{
   private JButton fullNameBtn;
   private JButton userNameBtn;
   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField resultField;
   private JLabel outputStrLabel;
   private JLabel outputStr;
   private NameBuilder nameBuilder;
   
   public FullName_UserName2(){
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
	  
      // Create an instance of NameBuilder
     nameBuilder = new NameBuilder();
      
      // add anonymous event handlers
      fullNameBtn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {            	  
                    resultField.setText(nameBuilder.fullName(firstNameField.getText(),
                lastNameField.getText()));                               
                }
            }
        );
      userNameBtn.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {            	  
                    resultField.setText(nameBuilder.userName(firstNameField.getText(),
                lastNameField.getText()));                               
                }
            }
        );
      pack();
      setSize(200,200);
      setLocationRelativeTo(null);
      setVisible( true );
   }
//////////////////////////////////////////////////////////
	// An inner class
   private class NameBuilder  { 	
    	
    	public String userName(String first, String last){
    		return first.substring(0,1)+last;
    	}   	 
   		public String fullName(String first, String last){
    		return last+", "+first;
    	}
   }
  //////////////////////////////////////////////////////////// 
    public static void main( String [] args ){
     FullName_UserName2 application = new FullName_UserName2();
      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }


}

