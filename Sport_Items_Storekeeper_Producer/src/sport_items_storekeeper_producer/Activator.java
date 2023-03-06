package sport_items_storekeeper_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {



	ServiceRegistration serviceRegister;
	
	@Override
	
	public void start(BundleContext context) throws Exception {
		System.out.println("----Welcome To TMSD Sport Hub----");
		SportStoreService store = new SportStoreServicelmpl();
		serviceRegister = context.registerService(SportStoreService.class.getName(), store, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("-----thank You..! Come Again..!");
		System.out.println("----Sport Store Service Stop---");
		serviceRegister.unregister();
		
	}

}
