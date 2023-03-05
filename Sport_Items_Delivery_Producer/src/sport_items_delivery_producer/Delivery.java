package sport_items_delivery_producer;

public class Delivery {

	private int  SportItemsID;
	private String DeliveryName;
	private String DeliveryLocation;
	private int DeliveryChargers;
	
	
	public Delivery(int sportItemsID, String deliveryName, String deliveryLocation,String delivery_Item, int deliveryChargers) {
		super();
		SportItemsID = sportItemsID;
		DeliveryName = deliveryName;
		DeliveryLocation = deliveryLocation;
		DeliveryChargers = Integer.parseInt(delivery_Item) * 30;;
	}


//	create getters and setters
	
	public int getSportItemsID() {
		return SportItemsID;
	}


	public void setSportItemsID(int sportItemsID) {
		SportItemsID = sportItemsID;
	}


	public String getDeliveryName() {
		return DeliveryName;
	}


	public void setDeliveryName(String deliveryName) {
		DeliveryName = deliveryName;
	}


	public String getDeliveryLocation() {
		return DeliveryLocation;
	}


	public void setDeliveryLocation(String deliveryLocation) {
		DeliveryLocation = deliveryLocation;
	}


	public int getDeliveryChargers() {
		return DeliveryChargers;
	}


	public void setDeliveryChargers(int deliveryChargers) {
		DeliveryChargers = deliveryChargers;
	}
	

	
	
	
}
