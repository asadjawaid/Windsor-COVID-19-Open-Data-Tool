/**
 * @author Asad Jawaid
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TestHospitalClass {
	
	private ArrayList<HospitalInformation> listTest = new ArrayList<>();
	private HospitalFile hospital = new HospitalFile("filePath/Hospitals.csv");
	

	@Before
	public void createList() {
		listTest.add(new HospitalInformation(0, "Hôtel-Dieu Grace Healthcare", null, null, 0, 0));
		listTest.add(new HospitalInformation(0, "Windsor Regional Hospital - Metropolitan Campus", null, null, 0, 0));
		listTest.add(new HospitalInformation(0, "Windsor Regional Hospital - Ouellette Campus", null, null, 0, 0));
	}
	
	@Test
	public void testSize() {
		assertEquals(3, listTest.size());
	}
	
	@Test
	public void testNames() {
		assertEquals("Hôtel-Dieu Grace Healthcare", listTest.get(0));
		assertEquals("Windsor Regional Hospital - Metropolitan Campus", listTest.get(1));
		assertEquals("Windsor Regional Hospital - Ouellette Campus", listTest.get(0));
	}
	
	@After
	public void removeAll() {
		for(int i = 0; i < listTest.size(); i++) {
			listTest.remove(i);
		}
	}
}
