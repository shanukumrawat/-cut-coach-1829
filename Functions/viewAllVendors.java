package Functions;

import java.util.List;

import BeanClasses.Vendor;
import DAOPackage.VendorDAO;
import DAOPackage.VendorDaoImp;
import Exceptions.VendorException;

public class viewAllVendors {

	
	public static void main(String[] args) {
		VendorDAO vd = new VendorDaoImp();
		try {
			List<Vendor> vendors = vd.viewAllVendor();
			vendors.forEach(v->{
				System.out.println("Vendor name : "+  v.getVname());
				System.out.println("Vendor email : "+ v.getEmail());
				System.out.println("Vendor company : "+v.getCompany());
				System.out.println("vendor address : "+v.getAddress());
				System.out.println("===============================");
			});
		} catch (VendorException v) {
			System.out.println(v.getMessage());
		}

	}
}
