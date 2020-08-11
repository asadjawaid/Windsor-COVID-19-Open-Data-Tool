/**
 * @author Asad Jawaid
 */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestHospitalClass {
	HospitalFile fileTest = new HospitalFile("filePath/Hospitals.csv"); // Using this to create the three records
	HospitalFile test2 = new HospitalFile(""); // this will only contain one record that will be compared with any of the records.
	ArrayList<HospitalInformation> testInfo; // here we will store the three records
	
	// hospital information in the csv file
	String FID = "0";
	String name = "Hôtel-Dieu Grace Healthcare";
	String address = "1453 PRINCE RD";
	String facilityID = "H-001";
	String xCord = "83.06450273";
	String yCord = "42.28428054";

	/**
	 * Before we get to testing we create a test HospitalFile object to create the three HospitalInformation objects and add each record created to the ArrayList and 
	 * return the ArrayList to be stored into testInfo. With testInfo now containing the three objects, we will compare each object to see if the names are equal and 
	 * right.
	 */
	@Before
	public void callMethodFromHospitalFile() {
		testInfo = fileTest.getHospitalInfo(); // call this method to create the three objects of the hospitals and store it into testInfo
	}
	
	/**
	 * This is our main testing method which will first create a hospital record with the following attributes. Then were going to compare the FID, name, address, and 
	 * the facility id from the first record in the arraylist to the record we created using the class HospitalInformation with variable name test2 we just created.
	 */
	@Test
	public void testhospitalRecord() {
		String[] values= {FID, name, address, facilityID, xCord, yCord};
		HospitalInformation hs = test2.hospitalRecord(values); // create a record
		
		assertEquals(testInfo.get(0).getFID(), hs.getFID());
		assertEquals(testInfo.get(0).getName(), hs.getName());
		assertEquals(testInfo.get(0).getAddress(), hs.getAddress());
		assertEquals(testInfo.get(0).getFacilityID(), hs.getFacilityID());
	}

}
