package management.entity;

public class Address {

	private int addId;
	private String street;
	private String city;
	private String state;

	public Address(int addId, String street, String city, String state) {
		super();
		this.addId = addId;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public Address(String city2, String street2, String state2) {
		// TODO Auto-generated constructor stub
		this.street = street2;
		this.city = city2;
		this.state = state2;
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
