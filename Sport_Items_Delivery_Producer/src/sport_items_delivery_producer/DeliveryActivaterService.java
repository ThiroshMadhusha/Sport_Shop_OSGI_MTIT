package sport_items_delivery_producer;

import java.util.List;


public interface DeliveryActivaterService {
	
	List<Delivery>listItems();
	
	public  int  addItems(String Delivery_name,String Transport_location,String Transport_Item);
	public   int removeItems1(String itemName);
	public   int searchitems(String itemName);
	
	
	public   List<Delivery> listItems1();


}
