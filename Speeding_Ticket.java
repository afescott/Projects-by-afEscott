/**
 * 
 * @author Ashley Escott, s4908683
 * Date: 07/04/2017
 * Task: Here is the Speeding ticket code for the Speeding_Ticket_GUI
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
/** Here is the class
 * @param <speedGoing>*/
public class Speeding_Ticket<speedGoing> {
	static Scanner scan = null;
	/**
	 * Method that submits the data collected by either frameAwareness and frameFullFine
	 * @param FullName Name of the user
	 * @param VehicleNo Vehicle registration number belonging to the user
	 * @param AddressLine Address line of the user
	 * @param Postcode postcode of the user
	 * @param creditNumber Credit card number if frameFullFine is used
	 * @param securityCode Security code of the card number if frameFullFine is used
	 * @param fine Fine of the user saved using string as '£' is used.
	 * @throws IOException
	 */
	public void submitInfo(String fullName, String VehicleNo, String AddressLine, String Postcode, String creditNumber, String securityCode, String fine ) throws IOException
	{
		PrintWriter in = new PrintWriter ( new BufferedWriter (new FileWriter ("Driving_Info.txt")));
if  (fullName.equals("") | AddressLine.equals("") | VehicleNo.equals("") | Postcode.equals("") | creditNumber.equals("") | securityCode.equals(""))
		{
	
		JOptionPane.showMessageDialog(null, "Please fill in the blanks");
		}
else {
	JOptionPane.showMessageDialog(null, "Data saved");
		in.print("Your Name : ");
		in.println(fullName);
		in.print("Fine: ");
		in.println(fine);
		in.print("Vehicle No: ");
		in.println(VehicleNo);
		in.print("Address Line: ");
		in.println(AddressLine); 
		in.print("Postcode ");
		in.println(Postcode); 
		in.print("credit number ");
		in.println(creditNumber); 
		in.print("security Code ");
		in.println(securityCode); 
		in.close();
		System.exit(0);
}
	}	
	 /**
	  *  * Method that searches for the corresponding brand of the vehicle plate given by the user
	 * Once the brand has been located e.g. 'VK16 WNJ' with Yamaha the next part of the frame is unlocked. 
	 * @param userInput The users input for the registration plate saved as a String 
	 * @param found Boolean variable that determines if the registration plate corresponds with the plate in the text file.
	 * @return Returns a String variable that is the brand of the registration plate given i.e. 'Yamaha'
	 * @throws FileNotFoundException Throws a file not found exception to improve robustness. 
	  * @param speedGoing JLabel used to set visible once a valid plate corresponding with the text file has been located.
	  * @param speedZone  JLabel used to set visible once a valid plate corresponding with the text file has been located. 
	  * @param speed JTextField used to set visible once a valid plate corresponding with the text file has been located.
	  * @param speedZone1 JTextField used to set visible once a valid plate corresponding with the text file has been located.
	  * @param calculateFine JButton  used to set visible once a valid plate corresponding with the text file has been located.
	  * @param fine JLabel used to set visible once a valid plate corresponding with the text file has been located. 
	  */
	public String search ( String userInput, boolean found, JLabel speedGoing, JLabel speedZone, JTextField speed, JTextField speedZone1, JButton calculateFine, JLabel fine  ) throws FileNotFoundException
	{
		found = false;
		String currentVehicle;
		String plate = null;
		File file = new File("VehicleReg.txt");
		Scanner vehicleSearch = new Scanner(file);	
		while(vehicleSearch.hasNextLine())
		{
			currentVehicle = vehicleSearch.nextLine();
			if (currentVehicle.equals(userInput))
			{
				plate = vehicleSearch.next();
				System.out.println(plate);
				found = true;
				speedGoing.setVisible(true);
				speedZone.setVisible(true);
				speed.setVisible(true);
				speedZone1.setVisible(true);
				calculateFine.setVisible(true);
				fine.setVisible(true);
				
				break;
			}	
			else if (!(vehicleSearch.hasNextLine()))
			{
				found = false;
				vehicleSearch.close();
				JOptionPane.showMessageDialog(null, "Please enter a valid Vehicle registration number that is on the GOV.uk database");
				break;
			} 
		}
		vehicleSearch.close();
		return plate;
	}  
/**
 * Calculates whether the user has been speeding or not
 * @param speed integer variable given by the user about the speed they were traveling.
 * @param speedLimit Integer variable given by the user indicating the speed limit (mph) of the zone they were in.
 * @return Returns the speed difference between how fast the user was going and the mph of the zone they were in
 */
	public int calculateSpeed (int speed, int speedLimit)
	{
		int overSpeed = 0;
		if (Integer.toString(speed).equals ("") | Integer.toString(speedLimit).equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter a valid input");
		}
	if (speed >= speedLimit )
		{
			overSpeed = speed - speedLimit;
		}
		
		return overSpeed;	
	}
/**
 * Calculates the fine of of the user depending on how much faster they were traveling
 * @param overSpeed Parameter passed by the user determining how severe the fine is
 * @return Returns an integer of the total fine.
 */
	public int calculateFine (int overSpeed)
	{
		int fine = 0;
		
		if (overSpeed >= 5 && overSpeed <= 9)
		{
			System.out.println("You have been fined £50");

			fine = 50;
		} else if (overSpeed >=10 &&  overSpeed <=14)
		{
			System.out.println("You have been fined £100");
			
			fine = 100;
		}
		else if (overSpeed >= 15 && overSpeed <=20)
		{
			System.out.println("You have been fined £150");
			
			fine = 150;
		}
		else if (overSpeed >20)
		{
			System.out.println("You have been fined £250");
			fine = 250;
		}
		else
		{
			System.out.println("You have not been speeding,");
		}
		return fine;

	}
	public static void main(String[] args) throws IOException {
	}
}
