package sport_items_storekeeper_producer;

import java.util.List;



public class SportStoreServicelmpl implements SportStoreService {

	@Override
	public synchronized int addItems(String sportName,int quantity) {
		
		SportItems newItem = new SportItems(SportDataStore.itemsList.size()+1,sportName,quantity);
		SportDataStore.itemsList.add(newItem);
		
	return 1;
	}
	@Override
	public  synchronized int removeItems1(String sportName) {

		boolean invalid = true;
		int count = -1;
		for (SportItems tempItem :SportDataStore.itemsList) {
			count++;
			if (tempItem.getSportName().equalsIgnoreCase(sportName)) {
			
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
	
		for (SportItems tempItem : SportDataStore.itemsList) {
		
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
	public List<SportItems>listItems() {

		return SportDataStore.itemsList;
	}

	@Override
	public List<SportItems> listItems1() {

		return null;
	
	}
}
