package zhou.dao;

public class User {
	String UserAccount;
	String UserName;
	String UserPassword;
	String UserDescription;
	String UserFlag;
	String UserSign;
	
	public User(String userAccount, String userName, String userPassword, String userDescription, String userFlag,
			String userSign) {
		super();
		UserAccount = userAccount;
		UserName = userName;
		UserPassword = userPassword;
		UserDescription = userDescription;
		UserFlag = userFlag;
		UserSign = userSign;
	}
	
	public String getUserAccount() {
		return UserAccount;
	}
	public void setUserAccount(String userAccount) {
		UserAccount = userAccount;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserDescription() {
		return UserDescription;
	}
	public void setUserDescription(String userDescription) {
		UserDescription = userDescription;
	}
	public String getUserFlag() {
		return UserFlag;
	}
	public void setUserFlag(String userFlag) {
		UserFlag = userFlag;
	}
	public String getUserSign() {
		return UserSign;
	}
	public void setUserSign(String userSign) {
		UserSign = userSign;
	}
}
