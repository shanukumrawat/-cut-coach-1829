package Functions;

import java.util.List;
import java.util.Scanner;

import BeanClasses.Vendor;
import DAOPackage.VendorDAO;
import DAOPackage.VendorDaoImp;
import Exceptions.VendorException;

public class MultiCase {

	
	public static void main(String[] args) {
		System.out.println("Enter 1 for login as Administrator");
		System.out.println("Enter 2 for login as Vendor");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		VendorDAO vdao = new VendorDaoImp();
		if(x==1) {
			System.out.println("Please enter username");
			String u = sc.next();
			System.out.println("Please enter your password");
			String p = sc.next();
			try {
				boolean b = vdao.loginAdmin(u, p);
				if(b) {
					System.out.println("=================================");
					System.out.println("Enter 1 for register new Vendor");
					System.out.println("Enter 2 for view all Vendors");
					System.out.println("Enter 3 for create new Tender");
					int choice = sc.nextInt();
					switch(choice) {
					case 1 :
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
						System.out.println("===========================");
						break;
					case 2:
						VendorDAO vd = new VendorDaoImp();
						try {
							List<Vendor> vendors = vd.viewAllVendor();
							vendors.forEach(v->{
								System.out.println("Vendor name : "+ v.getVname());
								System.out.println("Vendor email : "+v.getEmail());
								System.out.println("Vendor company : "+v.getCompany());
								System.out.println("vendor address : "+v.getAddress());
								System.out.println("===============================");
							});
						} catch (VendorException v) {
							System.out.println(v.getMessage());
						}
						break;
					}
				}
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else if(x==2) {
			System.out.println("Please enter your email..");
			String email = sc.next();
			System.out.println("Enter your password");
			String pass = sc.next();
			try {
				boolean vlogin = vdao.loginVendor(email, pass);
				System.out.println(vlogin);
				if(vlogin) {
					System.out.println();
					System.out.println("Enter 1 for view all current tenders");
					System.out.println("Enter 2 for place a bid against a tender");
					System.out.println("Enter 3 for view status of bid");
					System.out.println("Enter 4 for view own bid history");
					int choice = sc.nextInt();
					switch(choice) {
				
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			System.out.println("Please enter valid number");
		}

	}

}
