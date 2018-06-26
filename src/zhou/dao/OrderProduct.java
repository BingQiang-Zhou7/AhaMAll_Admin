package zhou.dao;

public class OrderProduct {
	String OrderInDetailsOrderNo;
	String OrderInDetailsCode;
	String OrderInDetailsColor;
	String OrderInDetailsSize;
	String OrderInDetailsCount;
	
	public OrderProduct(String orderInDetailsOrderNo, String orderInDetailsCode, String orderInDetailsColor,
			String orderInDetailsSize, String orderInDetailsCount) {
		super();
		OrderInDetailsOrderNo = orderInDetailsOrderNo;
		OrderInDetailsCode = orderInDetailsCode;
		OrderInDetailsColor = orderInDetailsColor;
		OrderInDetailsSize = orderInDetailsSize;
		OrderInDetailsCount = orderInDetailsCount;
	}
	
	public String getOrderInDetailsOrderNo() {
		return OrderInDetailsOrderNo;
	}
	public void setOrderInDetailsOrderNo(String orderInDetailsOrderNo) {
		OrderInDetailsOrderNo = orderInDetailsOrderNo;
	}
	public String getOrderInDetailsCode() {
		return OrderInDetailsCode;
	}
	public void setOrderInDetailsCode(String orderInDetailsCode) {
		OrderInDetailsCode = orderInDetailsCode;
	}
	public String getOrderInDetailsColor() {
		return OrderInDetailsColor;
	}
	public void setOrderInDetailsColor(String orderInDetailsColor) {
		OrderInDetailsColor = orderInDetailsColor;
	}
	public String getOrderInDetailsSize() {
		return OrderInDetailsSize;
	}
	public void setOrderInDetailsSize(String orderInDetailsSize) {
		OrderInDetailsSize = orderInDetailsSize;
	}
	public String getOrderInDetailsCount() {
		return OrderInDetailsCount;
	}
	public void setOrderInDetailsCount(String orderInDetailsCount) {
		OrderInDetailsCount = orderInDetailsCount;
	}
}
