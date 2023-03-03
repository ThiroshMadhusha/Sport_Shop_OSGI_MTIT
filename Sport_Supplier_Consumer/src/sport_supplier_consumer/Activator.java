package sport_supplier_consumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import sport_supplier_producer.Sport;
import sport_supplier_producer.SportSupplierService;

public class Activator implements BundleActivator {

	ServiceReference SportSupplierServiceReference;
	Scanner input = new Scanner(System.in);
	boolean exit =false;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("-----TMDS Sport Hub-----");
		SportSupplierServiceReference = context.getServiceReference(SportSupplierService.class.getName());
		
		@SuppressWarnings("unchecked")
		SportSupplierService sportSupplierService=(SportSupplierService) context.getService(SportSupplierServiceReference);

		do {
			int selection = 7;
			do {
				System.out.println();
				System.out.println();
				System.out.println("-------------Welcome to TMDS Sport Hub Supplier Interface--------------");
				System.out.println("Please Select Below Options To Continue.....");
				System.out.println();
				System.out.println("Options :");
				System.out.println();
				System.out.println();
				System.out.println("1.Add New Sport Items To TMSD Sport Hub ");
				System.out.println("2.View All List Of Sport Items");
				System.out.println("3.Search  Available Sport Items by Name");
				System.out.println("4.Remove  an Exsisiting Sport Items");
				System.out.println("5.Exit to Sport Supplier Interface");
				System.out.println();
				System.out.println();
				System.out.println("Enter your selection...");
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
				System.out.println("Enter the New Sport Item Name: ");
				String mobileName = input.nextLine();

				System.out.println("Enter the Sport Item Price: ");
				double itemPrice = input.nextDouble();

				System.out.println("Enter Discount Percentege (%): ");
				double itemDiscount = input.nextDouble();
				input.nextLine();
				
				int result =sportSupplierService.addItems(mobileName, itemPrice, itemDiscount);
				 String msg = (result ==1) ? "Successfully Added The New Sport Item!" :"please enter a valid name";
				   System.out.println(msg);
				   System.out.println();
				System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
				backToHome=input.nextLine();
				
				}
				
				while(!(backToHome.equals("0")));

			}
		
			else if(selection == 2) {
				do {
					List<Sport> itemsList =sportSupplierService.listItems();
					System.out.println("-----------------------------------Item list--------------------------------------------");
					System.out.println("Item ID:"+"\t" +"Item Name:"+"\t" + "Item Price:"+"\t" + "Discount Percentage:"+"\t" + "Price After the Discount:"+"\t" );
					
				for(Sport tempItem: itemsList ) {
					System.out.println(tempItem.getSportId()+"\t\t"+tempItem.getSportName()+"\t\t"+tempItem.getItemPrice()+"\t\t"+tempItem.getDiscount()+"%\t\t\t" +tempItem.getFinalPriceinSport()+"\t\n");				
				}
				System.out.println("-----------------------------------------------------------------------------------------");
	            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
				backToHome=input.nextLine();
				}
				while(!(backToHome.equals("0")));

			}
			else if(selection == 3) {
				do {
				System.out.println("Enter The Sport Item Name");
				String mobileName = input.nextLine();
				int result =sportSupplierService.searchitems(mobileName);
				 String msg = (result ==1) ? "Your Sport Item Founded!" :"Sport Item Not Found!";
				   System.out.println(msg);
				System.out.println("Press 0 To Navigate Menu..!");
				
				backToHome=input.nextLine();
				
				}
				
				while(!(backToHome.equals("0")));
			}
			
			
			else if (selection == 4) {
				do {
				System.out.println("Enter the item name:");

				String mobileName = input.nextLine();
				int result =sportSupplierService.removeItems1(mobileName);
				   String msg = (result ==1) ? "Successfully Removed the item!" :"please enter a valid name";
				   System.out.println(msg);
				   System.out.println();
	              System.out.println("Press 0 to navigate back to home or press any other key to continue....");
				
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
			System.out.println("-----TMSD Sport Hub Consumer Stopped-----");
			context.ungetService(SportSupplierServiceReference);
		}

	}
