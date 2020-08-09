/**
 * @author Asad Jawaid
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CasesFile {
	private String filePath;

	public CasesFile(String filePath) {
		this.filePath = filePath;
	}
	// this method returns each the content of the csv file.
	public void getCasesFromFile() {
		String line = "";

		try{
			BufferedReader br = new BufferedReader(new FileReader(this.filePath)); // open the file for reading
			System.out.println("Listing total confirmed cases in Windsor, Ontario: \n");
			
			while((line = br.readLine()) != null) {
				String [] values = line.split(","); // stores all individual data into this array by splitting the information with a comma
				System.out.println("Date: " + values[0] + ", Total Cases: " + values[1]);
			}
			System.out.println();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

