package Functions;

import java.util.Scanner;

import BeanClasses.Vendor;
import DAOPackage.VendorDAO;
import DAOPackage.VendorDaoImp;

public class AdminRegistration {

	
	public class RegisterVendorUseCase {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Vendor Name:");
			String vname=sc.next();
			
			System.out.println("Enter Email:");
			String email=sc.next();
			
			System.out.println("Enter Password:");
			String pass=sc.next();
			
			System.out.println("Enter Your Company:");
			String comp=sc.next();
			
			System.out.println("Enter Address:");
			String add=sc.next();
			Vendor vendor = new Vendor();
			vendor.setVname(vname);
			vendor.setEmail(email);
			vendor.setPassword(pass);
			vendor.setCompany(comp);
			vendor.setAddress(add);
			VendorDAO tdao = new VendorDaoImp();
			String result = tdao.registerVendor(vendor);
			System.out.println(result);
		}
		
}
