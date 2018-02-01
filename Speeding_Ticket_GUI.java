/**
 * 
 * @author Ashley Escott, s4908683
 * Date: 07/04/2017
 * Task: Here is the Speeding ticket GUI for the Speeding_Ticket program
 */

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Speeding_Ticket_GUI {
	private JFrame frame, frameAwareness, frameFullFine;
	private JPanel panel, panelAwareness, panelFullFine;
	private Speeding_Ticket<?> Ticket = new Speeding_Ticket<Object>();
	private JLabel lblFirstOffence, lblSpeedGoing,  lblSpeedZone, lblFine, lblPaymentFine, lblAwarenessVehicle, lblVehicleReg, lblPicture, lblFineAmount , lblFullVehicleReg, lblFullFineAmount;
	private JTextField txtSpeed, txtSpeedZone, txtFullName, txtAddressLine,  txtVehicleReg, txtPaymentAddressLine, txtPostcode, txtCreditNumber,txtSecurityCode, txtPaymentFullName, txtPaymentPostcode;
	private JButton btnCalculateFine, btnSubmitDetails, btnLocatePlate, btnSubmitDetailsForPayment;
	private JComboBox<?> comboResponse;
	int fine;
	String speed, speedZone;
/**
 * Method that initializes each method when the program is launched.
 */
	public Speeding_Ticket_GUI()
	{
		formCreate();
		addSpeedText();
		addButtons();
		addLabels();
		addComboBox();
		frame.add(panel);
		frame.setVisible(true);
		frameAwareness.add(panelAwareness);
		frameFullFine.add(panelFullFine);
	}
/**
 * Method that creates the form, initializing the frames and panels
 */
	public void formCreate ()
	{
		frame = new JFrame();
		frame.setTitle("Speeding Ticket");
		frame.setSize(500,400);
		frame.setLocation(400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAwareness = new JFrame();
		frameAwareness.setTitle("Driving Awareness Form");
		frameAwareness.setSize(450,400);
		frameAwareness.setLocation(400, 250);
		frameAwareness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAwareness.setVisible(false);
		frameFullFine = new JFrame();
		frameFullFine.setTitle("Payment to Gov.UK");
		frameFullFine.setSize(450,400);
		frameFullFine.setLocation(400, 250);
		frameFullFine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFullFine.setVisible(false);
		panel = new JPanel();
		panel.setLayout(null);
		panelAwareness = new JPanel();
		panelAwareness.setLayout(null);
		panelFullFine = new JPanel();
		panelFullFine.setLayout(null);
	}
/*
 * Method initializing each text boxes in this class.
 */
	public void addSpeedText ()
	{
		
		txtSpeed = new JTextField("");
		txtSpeed.setBounds(75, 120, 100, 20);
		txtSpeed.setVisible(false);
		panel.add(txtSpeed);
		txtSpeedZone = new JTextField("");
		txtSpeedZone.setBounds(300, 120, 100, 20);
		txtSpeedZone.setVisible(false);
		panel.add(txtSpeedZone);
		txtFullName = new JTextField("Full Name");
		txtFullName.setBounds(100, 50, 100, 20);
		panelAwareness.add(txtFullName);
		txtAddressLine = new JTextField("Please enter your first line of address");
		txtAddressLine.setBounds(100, 100, 300, 35);
		panelAwareness.add(txtAddressLine);
		txtPostcode = new JTextField("Please enter Postcode");
		txtPostcode.setBounds(100, 150, 300, 25);
		panelAwareness.add(txtPostcode);
		
		txtPaymentAddressLine = new JTextField("Please enter your first line of address");
		txtPaymentAddressLine.setBounds(100, 80, 300, 35);
		panelFullFine.add(txtPaymentAddressLine);
		 txtPaymentFullName = new JTextField("Full Name");
		 txtPaymentFullName.setBounds(100, 50, 100, 20);
		panelFullFine.add(txtPaymentFullName);  
		txtVehicleReg = new JTextField("");
		txtVehicleReg.setBounds(100, 50, 100, 20);
		panel.add(txtVehicleReg);
		txtCreditNumber = new JTextField("Card number");
		txtCreditNumber.setBounds(100, 150, 300, 25);
		panelFullFine.add(txtCreditNumber);
		txtSecurityCode = new JTextField("Security code");
		txtSecurityCode .setBounds(100, 180, 100, 20);
		panelFullFine.add(txtSecurityCode);
		txtPaymentPostcode = new JTextField("Please enter Postcode");
		txtPaymentPostcode.setBounds(100, 130, 100, 20);  
		panelFullFine.add(txtPaymentPostcode);
	}
/**
 * Generates a combo box for the users response concerning whether it is there first offence committed or not. 
 * The action handler is also defined here.
 * 
 */
	public void addComboBox ()
	{
		String [] choice = {"Please Select", "Yes", "No"};
		comboResponse = new JComboBox<Object>(choice);
		comboResponse.setBounds(250, 210, 100, 35);
		comboResponse.setVisible(false);
		comboResponse.addActionListener(new SelectionHandler());
		panel.add(comboResponse);
	}
	
	/**
	 * Adds each label used throughout the class
	 */
	public void addLabels ()
	{
		lblFirstOffence = new JLabel ("Is this your first offence?");
		lblFirstOffence.setBounds(100, 125, 200,200);
		lblFirstOffence.setVisible(false);
		panel.add(lblFirstOffence);
		lblVehicleReg = new JLabel ("");
		lblVehicleReg.setBounds(340, 30, 100,70);
		panel.add(lblVehicleReg);	
		lblAwarenessVehicle = new JLabel ("");
		lblAwarenessVehicle.setBounds(300, 50, 100, 20);  
		panelAwareness.add(lblAwarenessVehicle);		
		lblSpeedGoing = new JLabel ("Please enter the speed you were travelling");
		lblSpeedGoing.setFont(new Font("Courier New", Font.ITALIC, 9));
		lblSpeedGoing.setBounds(25, 60, 250,100);
		lblSpeedGoing.setVisible(false);
		panel.add(lblSpeedGoing);
		lblSpeedZone = new JLabel ("Please enter the zspeed of the zone you broke");
		lblSpeedZone.setFont(new Font("Courier New", Font.ITALIC, 9));
		lblSpeedZone.setBounds(250, 60, 250,100);
		lblSpeedZone.setVisible(false);
		panel.add(lblSpeedZone);
		lblFine = new JLabel (Integer.toString(fine));
		lblFine.setBounds(250, 60, 130,200);
		lblFine.setVisible(false);
		panel.add(lblFine);	
		lblFullVehicleReg = new JLabel ("");
		lblFullVehicleReg.setBounds(280, 50, 100, 20);
		panelFullFine.add(lblFullVehicleReg);
		ImageIcon govImage = new ImageIcon ("gov.png");
		lblPicture = new JLabel(govImage);
		lblPicture.setBounds(1, 5, 120,120);
		panel.add(lblPicture);			
		lblPicture = new JLabel(govImage);
		lblPicture.setBounds(185, 10, 120,120);
		panelAwareness.add(lblPicture);	
		lblPicture = new JLabel(govImage);
		lblPicture.setBounds(185, -20, 120,120);
		panelFullFine.add(lblPicture);	
		lblFineAmount = new JLabel ("");
		lblFineAmount.setBounds(130,40, 250,300);
		panelAwareness.add(lblFineAmount);	
		lblPaymentFine = new JLabel ("");
		lblPaymentFine.setBounds(220,50, 250,300);
		panelFullFine.add(lblPaymentFine);
		lblFullFineAmount = new JLabel ("");
		lblFullFineAmount.setBounds(300,60, 250,300);
		panelFullFine.add(lblFullFineAmount);
	}

	
	/**
	 * Creates each button used throughout the class
	 */
	public void addButtons()
	{
		btnCalculateFine = new JButton ("Calculate Fine");
		btnCalculateFine.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculateFine.setBounds(75, 150, 130,50);
		btnCalculateFine.setVisible(false);
		btnCalculateFine.addActionListener(new FineHandler());
		panel.add(btnCalculateFine);
	 btnLocatePlate = new JButton ("Identify Vehicle");
		btnLocatePlate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLocatePlate.setBounds(200, 30, 130,50);
		btnLocatePlate.addActionListener(new LocateHandler());
		panel.add(btnLocatePlate); 
		btnSubmitDetails = new JButton ("Submit");
		btnSubmitDetails.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSubmitDetails.setBounds(170, 175, 130,50);
		btnSubmitDetails.addActionListener(new SubmitHandler());
		panelAwareness.add(btnSubmitDetails);
		btnSubmitDetailsForPayment = new JButton ("Submit");
		btnSubmitDetailsForPayment.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSubmitDetailsForPayment.setBounds(265, 175, 130,50);
		btnSubmitDetailsForPayment.addActionListener(new PaymentHandler());
		panelFullFine.add(btnSubmitDetailsForPayment);
	}
/**
 * ActionListener which when 'Submit" is pressed validates the text boxes for a input that is not empty and 
 * if each text box has an input the details are saved into a text file.
 * @author Ashley
 *
 */
	class PaymentHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			String  fullName = txtPaymentFullName.getText();
			String cardNumber= txtCreditNumber.getText();
			String securityCode = txtSecurityCode.getText();
			String postcode = txtPaymentPostcode.getText();
			String address = txtPaymentAddressLine.getText();
			String  vehReg = 	lblFullVehicleReg.getText();
			String fine = lblFine.getText();	
			try {
				Ticket.submitInfo(fullName, vehReg, address, postcode, cardNumber, securityCode, fine);
			} catch (IOException e) {
				System.err.println("File not found");
				e.printStackTrace();
			}
		}
		}	
	/**
	 * ActionListener class that searches for the registration plate in the text file
	 * and if it does exist the brand correlating with that plate is displayed in lblVehicleReg.
	 * @author Ashley
	 *
	 */
	 class LocateHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			boolean found = false;
			try {
				String plate = Ticket.search(txtVehicleReg.getText(), found, lblSpeedGoing, lblSpeedZone, txtSpeed, txtSpeedZone, btnCalculateFine, lblFine); 
				
				if (found = true)
				{
					lblVehicleReg.setText(plate);
					lblAwarenessVehicle.setText(txtVehicleReg.getText());
					lblFullVehicleReg.setText(txtVehicleReg.getText());				
				}	
			} catch (FileNotFoundException e) {
				System.err.println("File not found");
				e.printStackTrace();
			}
		}
	} 
/**
 * ActionListener which when 'Submit" is pressed validates the text boxes for a input that is not empty and 
 * if each text box has an input the details are saved into a text file. 
 * Credit card number and security code are not required for the driving awareness form
 * @author Ashley
 *
 */
	class SubmitHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String name = txtFullName.getText();
			String address = txtAddressLine.getText();
			String vehicle = lblAwarenessVehicle.getText();
			String postcode = txtPostcode.getText();		
			try {
				Ticket.submitInfo(name, vehicle, address, postcode, "NULL", "NULL", lblFine.getText());			
			} catch (IOException e) {
				System.err.println("File not found");
				e.printStackTrace();
			}
		}
	}
/**
 * ActionListener that seeks the users response from the combo box and if Yes or No are clicked their respective 
 * frames are opened.
 * @author Ashley
 *
 */
	class SelectionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String response = (String) comboResponse.getSelectedItem();
			txtSpeed.setText(response);
			switch (response)
			{
			case "Please Select":
				JOptionPane.showMessageDialog(panel, "Please select a valid option");
				break;
			case "Yes": 
				JOptionPane.showMessageDialog(panel, "As this is your first offence, you are required to fill out a driving awareness form");
				frameAwareness.setVisible(true);
				break;
			case "No" : 
				JOptionPane.showMessageDialog(panel, "Please enter your details ");
				frameFullFine.setVisible(true);
				break;
			}

		}
	}
	/**
	 * ActionListener class that determines the fine amount for the user else a dialog box is presented and the frame is closed.
	 * @author Ashley
	 *
	 */
	class FineHandler implements ActionListener { 
		public void actionPerformed(ActionEvent event) {
			speed = txtSpeed.getText();
			speedZone = txtSpeedZone.getText();
		int overSpeed = Ticket.calculateSpeed(Integer.parseInt(speed), Integer.parseInt(speedZone));
			fine =	Ticket.calculateFine(overSpeed);
			if (fine >= 50)
			{
				lblFirstOffence.setVisible(true);
				String fine1 = Integer.toString(fine);
				fine1 = "£" + fine1;
				lblFine.setText(fine1);
				lblFineAmount.setText(fine1);
				lblFullFineAmount.setText(fine1);
				lblPaymentFine.setText(fine1);
				comboResponse.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You have not been speeding, the system will now close");
				System.exit(0);
			}
		}

	}
	public static void main(String[] args) {
		new Speeding_Ticket_GUI();
	}
}
