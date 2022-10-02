package DAOPackage;

	import java.util.List; 
	import BeanClasses.Vendor;
	import Exceptions.VendorException;

	public interface VendorDAO {

		public String registerVendor(Vendor vendor);
		public boolean loginVendor(String email,String password) throws VendorException;
		public List<Vendor> viewAllVendor() throws VendorException;
		public boolean loginAdmin(String username,String password) throws VendorException;
}
