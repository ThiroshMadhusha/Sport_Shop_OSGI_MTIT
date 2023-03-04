package sport_cashier_consumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import sport_cashier_producer.Sport_Items_Billing_Service;
import sport_cashier_producer.Sport_Items_Billing_Servicelmpl;

public class Activator implements BundleActivator {

	private static BundleContext context =null;
	
	@SuppressWarnings("rawtypes")
	ServiceReference serviceReference;
	@SuppressWarnings("rawtypes")
	private ServiceTracker serviceTracker=null;
	boolean exit = false;

	static BundleContext getContext() {
		return context;
	}

	@SuppressWarnings("unchecked")
	public void start(BundleContext context) throws Exception {
		Activator.context = context;
		
		serviceTracker = new ServiceTracker(context,context.createFilter("(&(objectClass="+Sport_Items_Billing_Service.class.getName()+")"+"(Language=*))"),null);
	
		serviceTracker.open();
		
		int SportItemID;
		int SportItemQuantity=0;
		float Amount=0;
		float discountPrice=(float) 0.10;
		float TotalPrice=0;
		int StokeHaveQuantity=10;
		char choicedItem;
		
		
		ArrayList<String> sports = new ArrayList<String>();
		ArrayList<Float> SportPrice = new ArrayList<Float>();
		
		sports.add("Leather Bat \t");
		SportPrice.add((float)27000.00);
		
		sports.add("Leather Bat \t");
		SportPrice.add((float)13000.00);
		
		sports.add("Helmet \t");
		SportPrice.add((float)8000.00);
		
		sports.add("Hockey Ball \t");
		SportPrice.add((float)2000.00);
		
		sports.add("Badminton \t");
		SportPrice.add((float)1500.00);
		
		sports.add("NetBall \t");
		SportPrice.add((float)9000.00);
		
		sports.add("Ball Guard \t");
		SportPrice.add((float)15000.00);
		
		sports.add("VollyBall \t");
		SportPrice.add((float)3500.00);
		
		sports.add("Shoes \t");
		SportPrice.add((float)7000.00);
		
		Scanner scanner = new Scanner(System.in);
		Sport_Items_Billing_Service sportBill = new Sport_Items_Billing_Servicelmpl();
		
		do {
            int selection = 3;
            do {
            
            	System.out.println("\n--------------Welcome To TMSG Sport Hub--------------- \n");
	            System.out.println();
	            System.out.println("******Please Select an Option Below******* \n");
	            System.out.println();
	            System.out.println("1.View Available All Sports Items ");
	            System.out.println("2.Generate Sport Items Buying Bill ");
	            System.out.println("3.Exit The Bill Interface \n");
	            System.out.println();
	            System.out.println("Enter your selection : \n ");
	   
	            
            selection = scanner.nextInt();
            scanner.nextLine();
            
             
             if(selection == 3) {
                 exit = true;
             }
             
             if(selection !=1 &&  selection !=2 && selection !=3 ) {
 	             System.out.println();
                 System.out.println("Please Enter The Valid Selection");
                 System.out.println();
             }
            }while(selection !=1  && selection !=2 && selection !=3 );
            
        
            String  backToHome = null;
            if (selection == 1) {
                do {
                    
                    for (int i = 0; i < SportPrice.size(); i++)
                    {
                      System.out.println(i+1 + "  " +sports.get(i) +"  Rs:"+SportPrice.get(i));
                    }

                    System.out.println(); 
	                System.out.println("Press 0 to navigate back to home or press any other key to continue....");
	                System.out.println();
	                backToHome=scanner.nextLine();
                
                }
                
                while(!(backToHome.equals("0")));
    
            }
            else if (selection == 2) {
                do {

                    for (int i = 0; i < SportPrice.size(); i++)
                    {
                      System.out.println(i+1 + "  " +sports.get(i) +"  Rs:"+SportPrice.get(i));
                    }
                  System.out.println();
                  do {

                      System.out.println("\n Enter the phone name or item number you need : ");
                      System.out.println();

                      SportItemID = scanner.nextInt();
                      System.out.println();

                      System.out.println("Enter number of quentity you need : ");
                      System.out.println();

                      System.out.println();

                      if(SportItemQuantity > StokeHaveQuantity) {
                    	  System.out.println();
                          System.out.println("*****There is No More Sport Stocks Available At This Moment*****");
                          System.out.println();
                      }
                      else {
                          
                      }
                      SportItemQuantity = (int) scanner.nextFloat();
                          System.out.println();
                          System.out.print("Do you want to buy Other item?  (y or n): \n ");
                          System.out.println();
                          
                          choicedItem = scanner.next().charAt(0);   
                  
                   Amount = sportBill.BillingService(sports, SportPrice,SportItemQuantity, SportItemID);
                  }while(choicedItem == 'y' || choicedItem == 'Y');
                  System.out.println("---------------------------------------------------");
                  
                  if(Amount >= 15000) {
                      TotalPrice = Amount;
                      discountPrice = Amount*10/100;
                      System.out.println("Discount :" + discountPrice);
                      
                  }
                  else {
                      
                      TotalPrice = Amount;
                      //System.out.println("Discount  price : 0.00");
                  }
                      System.out.println("Total price  : " + Amount);
                      
                      System.out.println("Payble Price : "+ (TotalPrice - discountPrice));
                      
                      System.out.println("--------------------------------------------------");
                   
                
                    System.out.println("Press 0 to navigate back to home or press any other key to continue...");
                
                    backToHome=scanner.nextLine();
                    backToHome=scanner.nextLine();
                    
                }
                
                while(!(backToHome.equals("0")));
    
            }
        
            else if(selection == 3) {//Exits form the Customer consumer program
                return;
            }
        }while(!exit);  
}

    
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }

}
