package sport_supplier_producer;

import java.util.List;


public interface SportSupplierService {
	
	List<Sport> listItems();
	
	public int addItems(String sportName,double itemPrice, double itemDiscount);
	public int updateItems(String updatedItemName, double updatedItemPrice,double updatedItemDiscount);
	public int removeItems1(String itemName);
	public int searchitems(String itemName);
	public   List<Sport> listItems1();//Returns the item list



}
