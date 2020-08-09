/**
 * @author Asad Jawaid
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class HospitalFile {
	private String filePath;

	public HospitalFile(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @Description this method opens up the file, stores a record into an array list and ask the users if they would like to calculate the distance from their area to the nearest hospital
	 */
	public void getHospitalInfo() {
		String line = "";
		ArrayList<HospitalInformation> hospitals = new ArrayList<>(); // each record contains information about that hospital

		try{
			BufferedReader br = new BufferedReader(new FileReader(this.filePath)); // open the file for reading

			while((line = br.readLine()) != null) {
				String [] values = line.split(","); // stores all individual data into this array by splitting the information with a comma
				HospitalInformation hospitalInfo = hospitalRecord(values); 
				hospitals.add(hospitalInfo); // add the record to the array list				
			}
			System.out.println();
			printHospitalInformation(hospitals);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @Description: This method takes in the information stored in values and passes it the constructor of HospitalInformation to create a new record.
	 * @param values
	 * @return a new HospitalInformation object
	 */
	public HospitalInformation hospitalRecord(String[] values) {
		int FID = Integer.valueOf(values[0]);
		String name = values[1];
		String address = values[2];
		String facilityID = values[3];
		double xCord = Double.valueOf(values[4]);
		double yCord = Double.valueOf(values[5]);

		return new HospitalInformation(FID, name, address, facilityID, xCord, yCord); // create a new record
	}
	/**
	 * This method prints out each hospital in Windsor, Ontario
	 */
	public void printHospitalInformation(ArrayList<HospitalInformation> hospitals) {
		Scanner read = new Scanner(System.in);
		System.out.println("Listing all hospitals in Windsor, Ontario:");
		
		for(HospitalInformation h: hospitals) {
			System.out.println(h);
		}
		
		System.out.println();
		System.out.println("Would you like to see the distance from your location to any of the Hospitals?\nType yes to continue or no to exit");
		System.out.print("Enter: ");
		String option = read.nextLine();

		if(option.equalsIgnoreCase("yes")) {
			printDistance(hospitals);
		}
		else if(option.equalsIgnoreCase("no")) {
			;
		}
		else {
			System.out.println("Invalid Input. Try Again Later!");
		}
	}
	/**
	 * This method calculates the distance from your location to any hospital the client selects
	 */
	private void printDistance(ArrayList<HospitalInformation> hospitals) {
		Scanner read = new Scanner(System.in);
		DecimalFormat decForm = new DecimalFormat("0.##");
		double distance = 0;
		System.out.println("\nThese are all the Hospitals in Windsor, Ontario: ");
				
		for(HospitalInformation h: hospitals) {
			System.out.println(h.getName());
		}
		
		System.out.print("Enter the hospital name to get the distance (exactly as it's listed above, copy and paste <:): ");
		String hospitalName = read.nextLine();
		
		for(HospitalInformation h: hospitals) {
			if(hospitalName.equals(h.getName())) {
				
				System.out.println("\nYou have selected: " + h.getName());
				System.out.print("Enter your X-Coordinate: ");
				double x2 = Double.valueOf(read.nextLine());
				
				System.out.print("Enter your Y-Coordinate: ");
				double y2 = Double.valueOf(read.nextLine());
				
				distance = Math.sqrt(Math.pow(h.getxCord() - x2, 2)) + Math.sqrt(Math.pow(h.getyCord() - y2, 2));
				System.out.println("\nThe distance from your location to " + h.getName() + " is " + decForm.format(distance));
			}
		}
	}
}
