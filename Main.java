import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel increaseLabel;
  JLabel counterLabel;

  JTextField increaseNum;
  JTextField counterNum;

  JButton incButton;
  JButton resetButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main panel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);

    // create lables
    increaseLabel = new JLabel("Increase By:");
    counterLabel = new JLabel("Counter:");

    // layout the labels with cordinates and size
    increaseLabel.setBounds(100, 300, 200, 80);
    counterLabel.setBounds(100, 400, 200, 80);

    // add the labels to the main panel
    mainPanel.add(increaseLabel);
    mainPanel.add(counterLabel);

    // initialize text fields
    increaseNum = new JTextField();
    counterNum = new JTextField();

    // layout the text fields with cordinates and size
    increaseNum.setBounds(310, 300, 200, 80);
    counterNum.setBounds(310, 400, 200, 80);

    // add the text fields to the main panel
    mainPanel.add(increaseNum);
    mainPanel.add(counterNum);

    // create buttons
    incButton = new JButton("Increase");
    resetButton = new JButton("Reset");

    // layout buttons with their size and cordinates
    incButton.setBounds(100, 100, 200, 80);
    resetButton.setBounds(400, 100, 200, 80);

    // add buttons to the main panel
    mainPanel.add(incButton);
    mainPanel.add(resetButton);

    // add action listener to buttons
    incButton.addActionListener(this);
    resetButton.addActionListener(this);

    // disable text in the counter text field
    counterNum.setEnabled(false);

    // add main panel to window
    frame.add(mainPanel);
  
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // create if statment to increase the integer that the user inputs
    if(command.equals("Increase")){
     
      String firstText = increaseNum.getText();
      String secondText = counterNum.getText();

      int first = Integer.parseInt(firstText);
      int second = Integer.parseInt(secondText);

      int counter = 0;

      if(first <= 10 && second <= 10){
        int total = second + first;
        counterNum.setText("" + total);
      }
      
    }

    if(command.equals("Reset")){
      counterNum.setText("0");

    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
