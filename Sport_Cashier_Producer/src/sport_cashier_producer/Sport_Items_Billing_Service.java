package sport_cashier_producer;

import java.util.ArrayList;

public interface Sport_Items_Billing_Service {
	
	float BillingService(ArrayList<String> phones,ArrayList<Float> SportPrice, int SportItemQuantity,int SportItemID);
	
	int getSportItemsStock();

}
