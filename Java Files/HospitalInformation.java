/**
 * @author Asad Jawaid
 */
public class HospitalInformation {
	private int FID;
	private String name;
	private String address;
	private String facilityID;
	private double xCord;
	private double yCord;
	
	public HospitalInformation(int FID, String name, String address, String facilityID, double xCord, double yCord) {
		this.FID = FID;
		this.name = name;
		this.address = address;
		this.facilityID = facilityID;
		this.xCord = xCord;
		this.yCord = yCord;
	}
	
	// getters and setters
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getxCord() {
		return xCord;
	}
	public void setxCord(double xCord) {
		this.xCord = xCord;
	}
	public double getyCord() {
		return yCord;
	}
	public void setyCord(double yCord) {
		this.yCord = yCord;
	}
	
	@Override
	public String toString() {
		return "FID: " + this.FID + ". Name: " + this.name + ". Address: " + this.address + ". Facility ID: " + this.facilityID + ". X-Coordinate: " + this.xCord + ". Y-Coordinate: " + this.yCord;
	}
	
}
