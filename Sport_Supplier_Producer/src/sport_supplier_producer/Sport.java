
package sport_supplier_producer;

public class Sport {
	
	private int sportId;
	private String sportName;
	private double itemPrice;
	private double discount;
	private double finalPriceinSport;
	
	
	public Sport(int sportId, String sportName, double itemPrice, double discount) {
		super();
		this.sportId = sportId;
		this.sportName = sportName;
		this.itemPrice = itemPrice;
		this.discount = discount;
		calculatefinalPriceInSport();
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

	
	public double getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getFinalPriceinSport() {
		return finalPriceinSport;
	}


	public void setFinalPriceinSport(double finalPriceinSport) {
		this.finalPriceinSport = finalPriceinSport;
	}
	
	void calculatefinalPriceInSport() {
		this.finalPriceinSport=itemPrice * ((100.00 - discount)/100.00);
	}
	

}
