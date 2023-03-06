package sport_items_storekeeper_consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import sport_items_storekeeper_producer.SportItems;
import sport_items_storekeeper_producer.SportStoreService;



public class Activator implements BundleActivator {

	ServiceReference SportStoreServiceReference;
	
	Scanner sports = new Scanner(System.in);
	
	boolean exit = false;

	public void start(BundleContext context) throws Exception {
		SportStoreServiceReference = context.getServiceReference(SportStoreService.class.getName());
		
		@SuppressWarnings("unchecked")
		
		SportStoreService  StoreKeeperService = (SportStoreService) context.getService(SportStoreServiceReference);
		
		do {
		int selection = 7;
		do {
		System.out.println("\n--------------Welcome To TMSD Sport Hub--------------- \n");
	
		System.out.println("Select an option to continue... \n");
		
		System.out.println("1.Add New Items Sport Hub Store ");
		System.out.println("2.List All Available store Items in TMSD Sport Hub");
//		System.out.println("3.Search Available Sport Store Items");
		System.out.println("3.Remove an Existing Sports Items in Store");
		System.out.println("4.Exit To Store Interface \n");
		
		System.out.println("Enter your option :");
		 selection = sports.nextInt();
		
		 sports.nextLine();
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
			System.out.println("Enter the New Item Name: ");
			String mobileName = sports.nextLine();

			System.out.println("Enter the stock quantity: ");
			int quantity = sports.nextInt();
			
			sports.nextLine();
			
			
			int result =StoreKeeperService.addItems(mobileName, quantity);
			String msg = (result ==1) ? "Successfully added the item! \n" : "please enter a valid name";
			System.out.println(msg);
			System.out.println("Press 0 To Redirect Main Menu...");
			
			backToHome=sports.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if (selection == 3) {//Handles the removing an existing item in the store
			do {
			System.out.println("Enter the item name you need remove:");

			String mobileName = sports.nextLine();
			int result =StoreKeeperService.removeItems1(mobileName);
			   String msg = (result ==1) ? "Successfully Removed the item! \n" :"please enter a valid name";
			   System.out.println(msg);
              System.out.println("Press 0 To Redirect Main Menu...");
			
			backToHome=sports.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 2) {
			do {
				List<SportItems> itemsList =StoreKeeperService.listItems();
				System.out.println("----Items in Sport Hub Store----");

				System.out.println("Sport Item ID:"+"\t"+"Sport Item Name:"+"\t"+"quantity:"+"\t" );
				
			for(SportItems tempItem: itemsList ) {
				System.out.println(tempItem.getSportId()+"\t\t"+tempItem.getSportName()+"\t\t"+tempItem.getQuantity()+"\t ");
								
			}
			System.out.println("===================================================");
            System.out.println("Press 0 To Redirect Main Menu...");
			
			backToHome=sports.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
//		else if(selection == 4) {
//			do {
//			
//			System.out.println("Enter The Sports Items Name");
//			
//
//			String sportName = sports.nextLine();
//			int result = SportStoreService.searchitems(sportName);
//			 String msg = (result ==1) ? "Sport Item Found!" :"Sport Item Not Found!";
//			   System.out.println(msg);
//			
//			System.out.println("Press 0 To Main Menu...");
//			
//			backToHome=sports.nextLine();
//			
//			}
//			
//			while(!(backToHome.equals("0")));
//		}
		else if(selection == 4) {
			return;
		}
	}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {//stop life cycle method
		System.out.println("----Sport Items Store Consumer Stop---");
		context.ungetService(SportStoreServiceReference);
	}

}