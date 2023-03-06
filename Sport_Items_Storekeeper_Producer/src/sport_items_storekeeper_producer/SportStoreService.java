package sport_items_storekeeper_producer;

import java.util.List;



public interface SportStoreService {
	
	
	
	public int addItems(String sportName,int quantity);
	public int removeItems1(String itemName);
	public int searchitems(String itemName);	
	
	public List<SportItems> listItems1();

	List<SportItems> listItems();



}
