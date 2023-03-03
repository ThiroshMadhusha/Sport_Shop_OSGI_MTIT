package sport_supplier_producer;

import java.util.List;

public class SportSupplierServicelmpl implements SportSupplierService {
	@Override
	public synchronized int  addItems(String sportName,double itemPrice,double discount) {
		Sport newItem = new Sport(SportDataStore.itemsList.size() + 1, sportName, itemPrice, discount);
		SportDataStore.itemsList.add(newItem);
	return 1;		
	}
	@Override
	public  synchronized int updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount) {
		Sport itemToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Sport tempItem : SportDataStore.itemsList) {
			count++;
			if (tempItem.getSportName().equalsIgnoreCase(updatedItemName)) {
				itemToBeUpdated = tempItem;
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			itemToBeUpdated.setSportName(updatedItemName);
			itemToBeUpdated.setItemPrice(updatedItemPrice);
			itemToBeUpdated.setDiscount(updatedItemDiscount);
			itemToBeUpdated.calculatefinalPriceInSport();
			SportDataStore.itemsList.set(count, itemToBeUpdated);
			return 1;
		} else {
			return -1;
		}
				
	}

	@Override
	public  synchronized int removeItems1(String mobileName) {

		boolean invalid = true;
		int count = -1;
		for (Sport tempItem :SportDataStore.itemsList) {
			count++;
			if (tempItem.getSportName().equalsIgnoreCase(mobileName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			SportDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}


	@Override
	public int searchitems(String sportName) {
		boolean valid = false;
	
		for (Sport tempItem : SportDataStore.itemsList) {
		
			if (tempItem.getSportName().equalsIgnoreCase(sportName)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Sport> listItems() {

		return SportDataStore.itemsList;
	}

	@Override
	public List<Sport> listItems1() {
		// TODO Auto-generated method stub
		return null;
	}
}