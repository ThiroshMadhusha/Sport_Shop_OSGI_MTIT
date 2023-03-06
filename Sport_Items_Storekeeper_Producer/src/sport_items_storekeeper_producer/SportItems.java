package sport_items_storekeeper_producer;

public class SportItems {
	
	private int sportId;
	private String sportName;
	private int quantity;
	
	public SportItems(int sportId, String sportName, int quantity) {
		super();
		this.sportId = sportId;
		this.sportName = sportName;
		this.quantity = quantity;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
