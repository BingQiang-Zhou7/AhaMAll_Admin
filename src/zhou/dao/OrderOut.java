package zhou.dao;

public class OrderOut {
	String OrderOutNo;
	String OrderOutDate;
	String OrderOutPerson;
	String OrderOutWarehouse;
	String OrderOutRperson;
	String OrderOutTel;
	String OrderOutAddress;
	String OrderOutRemark;
	String OrderOutFlag;
	public OrderOut(String orderOutNo, String orderOutDate, String orderOutPerson, String orderOutWarehouse,
			String orderOutRperson, String orderOutTel, String orderOutAddress, String orderOutRemark,
			String orderOutFlag) {
		super();
		OrderOutNo = orderOutNo;
		OrderOutDate = orderOutDate;
		OrderOutPerson = orderOutPerson;
		OrderOutWarehouse = orderOutWarehouse;
		OrderOutRperson = orderOutRperson;
		OrderOutTel = orderOutTel;
		OrderOutAddress = orderOutAddress;
		OrderOutRemark = orderOutRemark;
		OrderOutFlag = orderOutFlag;
	}
	public String getOrderOutNo() {
		return OrderOutNo;
	}
	public void setOrderOutNo(String orderOutNo) {
		OrderOutNo = orderOutNo;
	}
	public String getOrderOutDate() {
		return OrderOutDate;
	}
	public void setOrderOutDate(String orderOutDate) {
		OrderOutDate = orderOutDate;
	}
	public String getOrderOutPerson() {
		return OrderOutPerson;
	}
	public void setOrderOutPerson(String orderOutPerson) {
		OrderOutPerson = orderOutPerson;
	}
	public String getOrderOutWarehouse() {
		return OrderOutWarehouse;
	}
	public void setOrderOutWarehouse(String orderOutWarehouse) {
		OrderOutWarehouse = orderOutWarehouse;
	}
	public String getOrderOutRperson() {
		return OrderOutRperson;
	}
	public void setOrderOutRperson(String orderOutRperson) {
		OrderOutRperson = orderOutRperson;
	}
	public String getOrderOutTel() {
		return OrderOutTel;
	}
	public void setOrderOutTel(String orderOutTel) {
		OrderOutTel = orderOutTel;
	}
	public String getOrderOutAddress() {
		return OrderOutAddress;
	}
	public void setOrderOutAddress(String orderOutAddress) {
		OrderOutAddress = orderOutAddress;
	}
	public String getOrderOutRemark() {
		return OrderOutRemark;
	}
	public void setOrderOutRemark(String orderOutRemark) {
		OrderOutRemark = orderOutRemark;
	}
	public String getOrderOutFlag() {
		return OrderOutFlag;
	}
	public void setOrderOutFlag(String orderOutFlag) {
		OrderOutFlag = orderOutFlag;
	}
}
