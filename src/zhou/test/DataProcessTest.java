package zhou.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import zhou.dao.User;
import zhou.db.DataProcess;

class DataProcessTest {

	@Test
	void test() {
		//CheckAdmin();
		
		//ChangePassword();
		
		//SearchAllUser("0");
		//SearchUserFuzzy("a","0");
//		EditUser("4","44","444","4444");
//		EditUser("3","333","333","333");
		
		new DataProcess("backstage").EditWarehouseInfo("5", "555", "555", "555");
	}
	
	void CheckAdmin()
	{
		//check admin is exist or not ----true
		System.out.println(new DataProcess("backstage").CheckUser("admin", "null","1"));
		//check admin is exist or not ----false
		System.out.println(new DataProcess("backstage").CheckUser("ad", "null","1"));
		//check admin's password is correct ---- true
		System.out.println(new DataProcess("backstage").CheckUser("admin", "123","1"));
		//check admin's password is correct ----false
		System.out.println(new DataProcess("backstage").CheckUser("admin", "12","1"));
	}
	
	void ChangePassword()
	{
		System.out.println(new DataProcess("backstage").ChangePassword("admin", "12345"));
		
		System.out.println(new DataProcess("backstage").CheckUser("admin", "12345","1"));
	}
	
	void SearchAllUser(String no)
	{
		ArrayList<User> users = new DataProcess("backstage").SearchAllUser(no);
		for (User user : users) {
			System.out.println(user.getUserAccount());
			System.out.println(user.getUserDescription());
			System.out.println(user.getUserFlag());
			System.out.println(user.getUserName());
			System.out.println(user.getUserPassword());
			System.out.println(user.getUserSign());
		}
	}
	
	void SearchUserFuzzy(String fuzzyStr, String pageNo)
	{
		ArrayList<User> users = new DataProcess("backstage").SearchUserFuzzy(fuzzyStr, pageNo);
		for (User user : users) {
			System.out.println(user.getUserAccount());
			System.out.println(user.getUserDescription());
			System.out.println(user.getUserFlag());
			System.out.println(user.getUserName());
			System.out.println(user.getUserPassword());
			System.out.println(user.getUserSign());
		}
	}
	
	void EditUser(String UserAccount,String UserName,String UserPassword,String UserDescription)
	{
		
		new DataProcess("backstage").EditUser(UserAccount, UserName, UserPassword, UserDescription);
		
//		ArrayList<User> users = new DataProcess("backstage").SearchAllUser("0");
//		for (User user : users) {
//			System.out.println(user.getUserAccount());
//			System.out.println(user.getUserDescription());
//			System.out.println(user.getUserFlag());
//			System.out.println(user.getUserName());
//			System.out.println(user.getUserPassword());
//			System.out.println(user.getUserSign());
//		}
	}
}
