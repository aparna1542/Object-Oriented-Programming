package swings.eventListenersDemo;
// Java core packages
import java.awt.*;
import java.awt.event.*;
// Java extension packages
import javax.swing.*;
import java.io.*;
import java.util.*;

class CheckBoxDemo extends JFrame implements ActionListener{
   private JButton plainButton;
   private JPanel selectionPanel, displayPanel;
   private Container contentPane;
   private JButton  okButton;
   private String [] btnText = {"Java", "C++", "C#", "Python"};
   private String [] btnText2;
   private String filename = "skills.txt";
    /*
     * An array of JCheckBox objects
     */
    private JCheckBox[] checkBoxList;
   public CheckBoxDemo(){
      super( "CheckBoxDemo" );
      // get content pane
      contentPane = getContentPane();
      // set the layout
      contentPane.setLayout( new BorderLayout() ); 
	 // Read the text for the checkboxs from a text file
      createBtnTextListFromFileData();
      createSelectionPanel();
      createDisplayPanel();    
      // add the panels to the content pane
      contentPane.add(selectionPanel, BorderLayout.CENTER);
      contentPane.add(displayPanel, BorderLayout.SOUTH);
      setSize(600,300);
      setDefaultCloseOperation( EXIT_ON_CLOSE );
      setVisible( true );
   }
   private void createBtnTextListFromFileData(){
		// Read data from a file
       File file = new File(filename);
       try{
           Scanner scanner = new Scanner (file);
           if (scanner.hasNextLine()){
               String line = scanner.nextLine();
               String [] tokens = line.split(":",0);
               btnText2 = new String[tokens.length];
               int cnt = 0;
               for (String str:tokens){
                   btnText2[cnt++] = str;
                }       
            }     
        }
        catch (FileNotFoundException e){e.printStackTrace(); }     
    }
   private void createSelectionPanel() {
        //create and place checkboxes        
        selectionPanel = new JPanel(new GridLayout(0,1));
        selectionPanel.setBorder(BorderFactory.createTitledBorder("My Skills"));
        checkBoxList = new JCheckBox[btnText2.length];
        for (int i = 0; i < checkBoxList.length; i++) {
            checkBoxList[i] = new JCheckBox(btnText2[i]);
            selectionPanel.add(checkBoxList[i]);          
        }           
   }
   private void createDisplayPanel(){
        //create and place the OK button
        displayPanel = new JPanel(new FlowLayout());
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        displayPanel.add(okButton);      
   }
   public void actionPerformed(ActionEvent event) {
        StringBuffer skills = new StringBuffer("The programming laguages I know are\n");
        for (int i = 0; i < checkBoxList.length; i++) {
            if (checkBoxList[i].isSelected()) {
                skills.append(checkBoxList[i].getText() + "\n");
            }
        }
        JOptionPane.showMessageDialog(this, skills.toString());
    }
     public static void main(String[] args) {
        CheckBoxDemo demoFrame = new CheckBoxDemo();      
    }
}  
