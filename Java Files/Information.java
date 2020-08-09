/**
 * @author Asad Jawaid
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class Information {

	public void getInformation() {
		Scanner read = new Scanner(System.in);
		boolean done = false;
		int option = 0;
		String yesOrNo;
		while(!done) {
			try {
				System.out.println("Welcome to Windsor Open Data Tool.\n----------------------------------\nSelect any option below to proceed:\n ");
				System.out.println("1. Confirmed Cases in Windsor, Ontario by Date\n2. Case counts in Windsor, Ontario., Ontario.\n3. Hospitals in Windsor, Ontario.\n4. Exit.");
				System.out.print("Enter: ");
				option = Integer.valueOf(read.nextLine());
				select(option);

				System.out.print("Would you like to see the main-menu? Enter yes to continue or no to exit: ");
				yesOrNo = read.nextLine();

				if(yesOrNo.equalsIgnoreCase("yes")) {
					System.out.println();
				}
				else if(yesOrNo.equalsIgnoreCase("no")) {
					System.out.println("Have a good day!");
					done = true;
				}
				else {
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException e) {
				e = new InputMismatchException("\nInvalid Entry. Please Try Again!\n");
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e) {
				e = new NumberFormatException("\nye\n");
				System.out.println(e.getMessage());
			}
		}
	}

	public void select(int option) {
		if(option == 1) {
			Scanner reader = new Scanner(System.in);
			System.out.print("Enter the path name of totalCases.csv file on your computer: (e.g. filePath/totalCases.csv): ");
			String filePath = reader.nextLine();
			CasesFile casesFile = new CasesFile(filePath);
			casesFile.getCasesFromFile();
		}
		else if(option == 2) {
			System.out.println("Information about COVID-19 Cases in Windsor, Ontario:\n\t- Confirmed Cases: 2,357\n\t- Deaths: 71\n\t- Resolved Cases: 2,064\n");
			System.out.println("Confirmed Cases in Windsor by Sex:\n\t- Males: 1,527 confirmed cases\n\t- Females: 815 confirmed cases\n\t- Unknown: 15 confirmed cases\n ");

		}
		else if(option == 3) {
			Scanner reader = new Scanner(System.in);
			System.out.print("Enter the path name of Hospitals.csv file on your computer: (e.g. filePath/Hospitals.csv): ");
			String filePath = reader.nextLine();
			HospitalFile hospitalFile = new HospitalFile(filePath);
			hospitalFile.getHospitalInfo();
		}
		else if(option == 4) {
			System.out.println("Have a good day!");
			System.exit(0);
		}
		else {
			System.out.println("Invalid Entry. Please Try Again!");
		}
	}
}
