package sport_items_delivery_consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import sport_items_delivery_producer.Delivery;
import sport_items_delivery_producer.DeliveryActivaterService;


public class Activator implements BundleActivator {

	 
	ServiceReference DeliveryService;
	Scanner input = new Scanner(System.in);


	boolean exit = false;

	@Override
	public void start(BundleContext context) throws Exception { 
		
		System.out.println("----Delivery Sport Items Consumer Started-----");
		
		DeliveryService = context.getServiceReference(DeliveryActivaterService.class.getName());
		
		@SuppressWarnings("unchecked")
		DeliveryActivaterService  deliveryActivaterService = (DeliveryActivaterService) context.getService(DeliveryService);
		
		do {
		int selection = 7;
		do {
			System.out.println();
			System.out.println("-----------------------Welcome To TMSD Sport Hub----");
			System.out.println();
			System.out.println();
			System.out.println("Please Select Below Options To Continue Delivery System : ");
			System.out.println();
			System.out.println("1.Calculate the Delivery Items Service Chargers ");
			System.out.println("2.List Of The All Delivery Sports Items Names");
			System.out.println("3.Search Sports Items by Using Name");
			System.out.println("4.Remove Unwanted Delivery Items In Delivery Store");
			System.out.println("5.Exit to Transport Interface");
			System.out.println();
			System.out.println("Enter your selection...");
			System.out.println();
			 selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 5) {
			 exit = true;
		 }
		 
		 if(selection !=1 &&  selection !=2 && selection !=3 && selection !=4 && selection!=5) {
			 System.out.println("Please enter a valid selection");
		 }
		}while(selection !=1  && selection !=2 && selection !=3 && selection !=4 && selection!=5 );
		
	
        String  backToHome = null;
		if (selection == 1) {
			do {
			System.out.println("Enter The Delivery Item Name");
			String deliveryName = input.nextLine();

			System.out.println("Enter The Delivery Item Location");
			String deliveryLocation = input.nextLine();

			System.out.println("Enter The Delivery Location Distance (K.M)");
			String Delivery_Item = input.nextLine();
			input.nextLine();
			
			int result =deliveryActivaterService.addItems(deliveryName, deliveryLocation, Delivery_Item);//Consumes the ManagerService addItems()
			 String msg = (result ==1) ? "Successfully Added The Delivery Items!" :"please enter a valid name";
			   System.out.println(msg);
			System.out.println("Press 0 To Navigate To Main Menu...");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 4) { 
			do {
			System.out.println("Enter The Delivery Item Name:");

			String deliveryName = input.nextLine();
			int result =deliveryActivaterService.removeItems1(deliveryName);
			   String msg = (result ==1) ? "Successfully Removed the item!" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 To Navigate To Main Menu....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 2) { 
			do {
				List<Delivery> itemsList =deliveryActivaterService.listItems();
				System.out.println("-----------------------------------Item list--------------------------------------------");
				System.out.println("Item ID:"+"\t" +"Delivery Name:"+"\t" + "Delivery Location:"+"\t" + "Delivery Price:"+"\t" );
				
			for(Delivery tempItem: itemsList ) {
				System.out.println(tempItem.getSportItemsID()+"\t         "+tempItem.getDeliveryName()+"\t         "+tempItem.getDeliveryLocation()+"\t         "+tempItem.getDeliveryChargers()+"\t              \n");
								
			}
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 To Navigate Main Menu....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 3) {
			do {
			
			System.out.println("Enter the item name");
			

			String deliveryName = input.nextLine();
			int result =deliveryActivaterService.searchitems(deliveryName);
			 String msg = (result ==1) ? "Item found!" :"Item not found!";
			   System.out.println(msg);
			
			System.out.println("Press 0 To Navigate Main Menu....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 5) { 
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception { 
		System.out.println("----Delivery Items Consumer Stopped----");
		System.out.println("Thank You");
		context.ungetService(DeliveryService);
	}

}