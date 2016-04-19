package SwingsGUI;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.swing.*;

import edu.scu.oop.assign2.Alpha2Oven;
import edu.scu.oop.assign2.OvenThermostat;

/**
 * GUI using Java Swings for Alpha2Oven COEN 275 Assignment 3
 * 
 * @author Aparna Ganesh 02/27/2015
 */

class Alpha2OvenUI {

	Alpha2Oven oven;
	private JFrame frameObj;
	private JLabel placeFoodLbl, setOvenTempLbl, setCookingTimeLbl,
	selectOvenTempLbl, testTimerLbl, dispOvenTempLbl, startTimeLbl,
	expecStopTimeLbl, actualStopTimeLbl;
	private JTextField ovenTempTxt, expecStopTimeTxt, actualStopTimeTxt,
	cookingTimeTxt, cookingTimeLeft, dispOvenTempTxt, startTimeTxt;
	private JCheckBox placeFoodChkBox;
	private JButton startStopButton;
	private JComboBox temperatureCombo;
	private JRadioButton c, f;
	private JPanel p1, p2, p3;
	private GridLayout g1, mainGrid;
	private FlowLayout fl;
	private Timer timer;
	int count = 0;

	Alpha2OvenUI() {
		oven = new Alpha2Oven();
	}

	public void initOvenUI() {

		frameObj = new JFrame("Smart Oven");
		// create Lables for SmartOven
		setOvenTempLbl = new JLabel("Set Oven Temperature");
		setCookingTimeLbl = new JLabel("Enter the cooking time(in min)");
		selectOvenTempLbl = new JLabel("Select Oven Temperature in F or C");
		dispOvenTempLbl = new JLabel("Oven Temperature");
		placeFoodLbl = new JLabel("Place Food");
		testTimerLbl = new JLabel("Cooking time left(in secs)");
		startTimeLbl = new JLabel("Start Time");
		actualStopTimeLbl = new JLabel("Actual Stop Time");
		expecStopTimeLbl = new JLabel("Expected Stop Time");

		// create TextFields for SmartOvenUI
		ovenTempTxt = new JTextField(40);
		cookingTimeTxt = new JTextField(5);
		cookingTimeLeft = new JTextField(10);
		cookingTimeLeft.setEditable(false);
		dispOvenTempTxt = new JTextField(40);
		dispOvenTempTxt.setEditable(false);
		startTimeTxt = new JTextField(40);
		startTimeTxt.setEditable(false);
		actualStopTimeTxt = new JTextField(10);
		actualStopTimeTxt.setEditable(false);
		expecStopTimeTxt = new JTextField(40);
		expecStopTimeTxt.setEditable(false);
		// create check box for Placing Food
		placeFoodChkBox = new JCheckBox();

		// Create Start Button to start the smart oven
		startStopButton = new JButton("Cook");

		// create combo box
		String[] temp = { "F", "C" };
		temperatureCombo = new JComboBox(temp);

		// create radio button
		ButtonGroup degreeGroup = new ButtonGroup();
		c = new JRadioButton("C");
		f = new JRadioButton("F");
		f.setSelected(true);
		degreeGroup.add(f);
		degreeGroup.add(c);

		// Create panels
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel(new BorderLayout());

		g1 = new GridLayout(11, 2);
		BorderLayout b = new BorderLayout();
		fl = new FlowLayout();
//Adding the components to the their respective Panels
		p1.setLayout(g1);
		p1.add(new JLabel());
		p1.add(new JLabel());
		p1.add(setOvenTempLbl);
		p1.add(ovenTempTxt);
		p1.add(new JLabel());
		p3.add(f, BorderLayout.WEST);
		p3.add(c, BorderLayout.CENTER);
		p1.add(p3);
		p1.add(setCookingTimeLbl);
		p1.add(cookingTimeTxt);
		p1.add(selectOvenTempLbl);
		p1.add(temperatureCombo);
		p1.add(dispOvenTempLbl);
		p1.add(dispOvenTempTxt);
		p1.add(placeFoodLbl);
		p1.add(placeFoodChkBox);
		p1.add(startTimeLbl);
		p1.add(startTimeTxt);
		p1.add(actualStopTimeLbl);
		p1.add(actualStopTimeTxt);
		p1.add(expecStopTimeLbl);
		p1.add(expecStopTimeTxt);

		p1.add(testTimerLbl);
		p1.add(cookingTimeLeft);

		p2.setLayout(fl);
		p2.add(startStopButton);

		
		frameObj.setLayout(b);
		frameObj.add(p1, b.NORTH);
		frameObj.add(p2, b.CENTER);
		frameObj.setSize(800, 400);
		frameObj.setVisible(true);
		frameObj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// add focus listener to Cooking Time field
		cookingTimeTxt.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// validate the oven temperature field if the focus is lost
				String errorMessage = validateCookingTime();
				if (!errorMessage.isEmpty()) {
					JOptionPane.showMessageDialog(null, errorMessage,
							"Validation Error", JOptionPane.ERROR_MESSAGE);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// add event listener for temperatureCombo
		temperatureCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object item = e.getItem();
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// Item selected. Set the display temperature field value
					// based on F or C
					if (item.toString() == "F") {
						if (f.isSelected()) {
							dispOvenTempTxt.setText(ovenTempTxt.getText());
						} else {
							// convert celcius to fahrenheit and then display
							int celcius = Integer.parseInt(ovenTempTxt
									.getText());
							dispOvenTempTxt.setText(""
									+ OvenThermostat
									.celciusToFahrenheit(celcius));
						}
					} else if (item.toString() == "C") {
						if (c.isSelected()) {
							dispOvenTempTxt.setText(ovenTempTxt.getText());
						} else {
							// convert fahrenheit to celcius and then display
							int fahrenheit = Integer.parseInt(ovenTempTxt
									.getText());
							dispOvenTempTxt.setText(""
									+ OvenThermostat
									.fahrenheitToCelcius(fahrenheit));
						}
					} else {
						// do nothing
					}
				}

			}
		});

		// add event listener to the button
		startStopButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				if (startStopButton.getText().equals("Cook")) {
		
					List<String> errorMessages = validate();
					if (errorMessages.size() > 0) {
						// There are validation errors.
						// Show the errors in a dialog
						showErrorMessage(errorMessages, "Validation Error");
						return;
					}

					oven.setTemperature(Integer.valueOf(ovenTempTxt.getText()));
					oven.setTime(Integer.valueOf(cookingTimeTxt.getText()));
					oven.placeFood();
					int cookingTime = oven.getCookingTimeInMinutes();
					long startTime = System.currentTimeMillis();
					startTimeTxt.setText(new SimpleDateFormat("HH:mm:ss")
					.format(new Date(startTime)));

					count = 60 * cookingTime;
					if (timer == null) {
						//start the Timer
						startTimer();

					}

				} else {
					//stop the timer
					stopTimer();
					//calulate actual stop time
					long stopTime = oven.getStartTime()
							+ oven.getCookingTimeInMinutes() * 60 * 1000;
					expecStopTimeTxt.setText(new SimpleDateFormat("HH:mm:ss")
					.format(new Date(stopTime)));
					actualStopTimeTxt.setText(new SimpleDateFormat("HH:mm:ss")
					.format(new Date(System.currentTimeMillis())));
					startStopButton.setEnabled(false);
				}
			}
		});

	}
	/**
	 * Method that defines the events for after timer starts
	 */

	public void startTimer() {
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {
				// Define an action listener to respond to events
				// from the timer. When an event is received, the

				public void actionPerformed(ActionEvent evt) {
					cookingTimeLeft.setText(String.valueOf(count));
					if (count == 0) {
						stopTimer();
						long stopTime = oven.getStartTime()
								+ oven.getCookingTimeInMinutes() * 60 * 1000;
						expecStopTimeTxt.setText(new SimpleDateFormat(
								"HH:mm:ss").format(new Date(stopTime)));
						actualStopTimeTxt.setText(new SimpleDateFormat(
								"HH:mm:ss").format(new Date(stopTime)));
					} else {
						count = count - 5;
					}
				}

			});
			timer.start(); // Make the time start running.
			startStopButton.setText("Stop");
		}
	}

	/**
	 * Timer stops here
	 */
	public void stopTimer() {

		if (timer != null) {
			timer.stop(); // Stop the timer.
			timer = null; // Set timer variable to null, so that we

		}
	}

	/**
	 * Validation for Oven Temperature field
	 * 
	 * @return the validation error message if any
	 */
	public String validateOvenTemperatureField() {
		String errorMessage = "";
		String ovenTemp = ovenTempTxt.getText();
		int temp;
		char degree;
		if (f.isSelected()) {
			degree = 'F';
		} else {
			degree = 'C';
		}

		try {
			temp = Integer.parseInt(ovenTemp);
		} catch (NumberFormatException e1) {
			errorMessage = "Temperature value must be an integer";
			return errorMessage;
		}

		if (!Alpha2Oven.isValidRange(temp, degree)) {
			errorMessage = "Temperature value not in valid range(30F - 110F or -1C to 43C)";
		}

		return errorMessage;
	}

	/**
	 * Validation for cooking time field
	 * 
	 * @return validation error message if any
	 */
	public String validateCookingTime() {
		String errorMessage = "";
		String cookingTime = cookingTimeTxt.getText();

		try {
			Integer.parseInt(cookingTime);
		} catch (NumberFormatException e) {
			errorMessage = "Enter a valid Cooking Time";
		}
		return errorMessage;
		// TODO
	}

	/**
	 * Validation for place food option
	 * 
	 * @return the validation error message if any
	 */
	public String validatePlaceFoodOption() {
		String errorMessage = "";
		if (!placeFoodChkBox.isSelected()) {
			errorMessage = "Place food is not selected";
		}
		return errorMessage;
	}
/**
 * Validates all the fields in the Smart Oven
 * @return
 */
	public List<String> validate() {
		List<String> validationErrors = new ArrayList<>();
		String errorMessage = "";
		errorMessage = validateOvenTemperatureField();
		if (!errorMessage.isEmpty()) {
			validationErrors.add(validateOvenTemperatureField());
		}
		errorMessage = validateCookingTime();
		if (!errorMessage.isEmpty()) {
			validationErrors.add(validateCookingTime());
		}
		errorMessage = validatePlaceFoodOption();
		if (!errorMessage.isEmpty()) {
			validationErrors.add(validatePlaceFoodOption());
		}
		return validationErrors;
	}

	/**
	 * Display Error message to the user using JDialoug 
	 * @param errorMessages
	 * @param alert
	 */
	public void showErrorMessage(List<String> errorMessages, String alert) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		for (String errorMsg : errorMessages) {
			errorMessageBuilder.append(errorMsg);
			errorMessageBuilder.append("\n");
		}
		JOptionPane.showMessageDialog(null, errorMessageBuilder.toString(),
				alert, JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		Alpha2OvenUI a1;
		a1 = new Alpha2OvenUI();
		a1.initOvenUI();
	}
}