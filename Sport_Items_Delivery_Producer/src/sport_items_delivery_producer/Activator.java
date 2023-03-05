package sport_items_delivery_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {


	ServiceRegistration serviceRegister;
	
	@Override

	public void start(BundleContext context) throws Exception {
		System.out.println("-----------Delivery Sports Items Started---------");
		DeliveryActivaterService transport = new DeliveryServicelmpl();
		serviceRegister = context.registerService(DeliveryActivaterService.class.getName(), transport, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("------Delivery Sports Items Stoped--------");
		serviceRegister.unregister();
	}

}
