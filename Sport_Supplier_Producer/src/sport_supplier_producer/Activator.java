package sport_supplier_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegister;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("----Welcom To TMGS Sport Hub-----");
		System.out.println("Service Started");
		SportSupplierService managerSer = new SportSupplierServicelmpl();
		
		serviceRegister=context.registerService(SportSupplierService.class.getName(),managerSer,null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("----Thank You..! Come Again..!");
		System.out.println("Service Stop");
		serviceRegister.unregister();
	}

}
