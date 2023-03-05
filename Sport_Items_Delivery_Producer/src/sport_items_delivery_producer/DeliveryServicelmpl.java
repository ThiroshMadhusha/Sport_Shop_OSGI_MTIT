package sport_items_delivery_producer;

import java.util.List;


public class DeliveryServicelmpl implements DeliveryActivaterService {


	@Override
	public synchronized int  addItems(String deliveryName,String deliveryLocation,String Delivery_Item) {

		Delivery newItem = new Delivery(DeliveryDataStore.itemsList.size() + 1, deliveryName, deliveryLocation, Delivery_Item, 0);
		DeliveryDataStore.itemsList.add(newItem);

	return 1;		
	}

	@Override
	public  synchronized int removeItems1(String sportName) {

		boolean invalid = true;
		int count = -1;
		for (Delivery tempItem :DeliveryDataStore.itemsList) {
			count++;
			if (tempItem.getDeliveryName().equalsIgnoreCase(sportName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			DeliveryDataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String sportName) {
		boolean valid = false;
	
		for (Delivery tempItem : DeliveryDataStore.itemsList) {
		
			if (tempItem.getDeliveryName().equalsIgnoreCase(sportName)) {

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
	public List<Delivery> listItems() {

		return DeliveryDataStore.itemsList;
	}

	@Override
	public List<Delivery> listItems1() {
		return null;
	}
}