package DAOPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BeanClasses.Admin;
import BeanClasses.Vendor;
import Exceptions.VendorException;
import Utility.DBUtil;

public class VendorDaoImp  implements VendorDAO{

	@Override
	public String registerVendor(Vendor vendor) {
		String message="Not Registered..";
		
		try (Connection con=DBUtil.provideConnection()){
			
			
			PreparedStatement ps=con.prepareStatement("insert into vendor(vname,email,password,company,address) values(?,?,?,?,?)");
			
			ps.setString(1,vendor.getVname());
			ps.setString(2,vendor.getEmail());
			ps.setString(3,vendor.getPassword());
			ps.setString(4,vendor.getCompany());
			ps.setString(5,vendor.getAddress());
			
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				message="Vendor Registration Successful!";
			}
			
			
		} catch (Exception e) {
			message=e.getMessage();
		}
		
		return message;
	}

	@Override
	public boolean loginVendor(String email, String password) throws VendorException {
		Vendor vendor = null;
		boolean flag = false;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from vendor where email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString("vid");
				String n = rs.getString("vname");
				String e = rs.getString("email");
				String p = rs.getString("password");
				String c = rs.getString("company");
				String a = rs.getString("address");
			vendor = new Vendor(id,n,e,p,c,a);	
			
			}else {
				throw new VendorException("Invalid email or password");
			}
			if(email.equals(vendor.getEmail())&&password.equals(vendor.getPassword()))             {
				System.out.println("Login successfully..");
				flag=true;
          				
			}else {
				throw new VendorException("Invalid username or password ");
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		
		
		
		return flag;
		
	}

	@Override
	public List<Vendor> viewAllVendor() throws VendorException {
		List<Vendor> vlist = new ArrayList<>();
		
		try(Connection conn= DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from vendor");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String vid = rs.getString("vid");
				String n = rs.getString("vname");
				String e = rs.getString("email");
				String p = rs.getString("password");
				String c = rs.getString("company");
				String a = rs.getString("address");
				Vendor vendor = new Vendor(vid,n,e,p,c,a);
				vlist.add(vendor);
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		if(vlist.size()==0) {
			throw new VendorException("No vendor found..");
		}
	
		return vlist;
		
	}

	@Override
	public boolean loginAdmin(String username, String password) throws  VendorException {
		boolean flag = false;
		Admin admin = null;
//		String msg = "invalid username or password";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from administrator where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String e = rs.getString("username");
				String p = rs.getString("password");
				admin = new Admin(e,p);
				
			}else {
				throw new VendorException("Invalid username or password");
			}
			
			if(username.equals(admin.getUsername())&&password.equals(admin.getPassword())) {
				System.out.println("Login Successfully!!");
				flag=true;
			}else {
				throw new VendorException("Invalid username or password ");
			}
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		
		return flag;
	}
}
