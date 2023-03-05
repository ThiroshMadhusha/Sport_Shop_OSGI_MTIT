package sport_cashier_producer;

import java.util.ArrayList;

public class Sport_Items_Billing_Servicelmpl implements Sport_Items_Billing_Service {

	float TotalAmount = 0;
	int StokeHaveQuantity = 10;
	
	@Override
	public float BillingService(ArrayList<String> sports, ArrayList<Float> SportPrice, int SportItemQuantity,
			int SportItemID) {
		// TODO Auto-generated method stub
		float Sport_ItemPrice=(float)SportPrice.get(SportItemID-1);
		
		System.out.println(sports.get(SportItemID-1)+"X"+SportItemQuantity+"="+(Sport_ItemPrice * SportItemQuantity));
		System.out.println();
		TotalAmount = TotalAmount +(Sport_ItemPrice * SportItemQuantity);
		
		return TotalAmount;
	}

	@Override
	public int getSportItemsStock() {
		// TODO Auto-generated method stub
		return StokeHaveQuantity;
		
	}
	

}
