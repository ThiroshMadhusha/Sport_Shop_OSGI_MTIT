package sport_cashier_producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;
	static BundleContext getContext() {
		return context;
	}
	public void start(BundleContext context) throws Exception {
		Activator.context = context;
		context.registerService(Sport_Items_Billing_Service.class.getName(), new Sport_Items_Billing_Servicelmpl(), null);
		System.out.println();
		System.out.println("-----Sport Items Cashier Billing system Stated Successfully-----");
		System.out.println();
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("YYYY/MM/DD HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dateTime.format(now));
	}
	public void stop(BundleContext context) throws Exception {
		Activator.context = null;
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(" Your Sport Item Order Bill Closed Time :  "+ dateTime.format(now));  
		System.out.println();
		System.out.println("*******Sport Items Cashier Billing System Successfully Stopped******");
		System.out.println();
		System.out.println("Thank For Buying Sports Items..! Come Again..!");
		System.out.println();
		System.out.println("******TMSD Sport Hub******");
		System.out.println();		
	}

}
