package zhou.dao;

public class OrderIn {
	String OrderInNo;
	String OrderInDate;
	String OrderinPerson;
	String OrderInWarehouse;
	String OrderInBefrom;
	String OrderInRemark;
	String OrderInFlag;
	
	public OrderIn(String orderInNo, String orderInDate, String orderinPerson, String orderInWarehouse,
			String orderInBefrom, String orderInRemark, String orderInFlag) {
		super();
		OrderInNo = orderInNo;
		OrderInDate = orderInDate;
		OrderinPerson = orderinPerson;
		OrderInWarehouse = orderInWarehouse;
		OrderInBefrom = orderInBefrom;
		OrderInRemark = orderInRemark;
		OrderInFlag = orderInFlag;
	}
	
	public String getOrderInNo() {
		return OrderInNo;
	}
	public void setOrderInNo(String orderInNo) {
		OrderInNo = orderInNo;
	}
	public String getOrderInDate() {
		return OrderInDate;
	}
	public void setOrderInDate(String orderInDate) {
		OrderInDate = orderInDate;
	}
	public String getOrderinPerson() {
		return OrderinPerson;
	}
	public void setOrderinPerson(String orderinPerson) {
		OrderinPerson = orderinPerson;
	}
	public String getOrderInWarehouse() {
		return OrderInWarehouse;
	}
	public void setOrderInWarehouse(String orderInWarehouse) {
		OrderInWarehouse = orderInWarehouse;
	}
	public String getOrderInBefrom() {
		return OrderInBefrom;
	}
	public void setOrderInBefrom(String orderInBefrom) {
		OrderInBefrom = orderInBefrom;
	}
	public String getOrderInRemark() {
		return OrderInRemark;
	}
	public void setOrderInRemark(String orderInRemark) {
		OrderInRemark = orderInRemark;
	}
	public String getOrderInFlag() {
		return OrderInFlag;
	}
	public void setOrderInFlag(String orderInFlag) {
		OrderInFlag = orderInFlag;
	}
}
