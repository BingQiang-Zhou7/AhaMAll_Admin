package zhou.dao;

public class Warehouse {
	String WarehouseNo;
	String WarehouseName;
	String WarehouseContact;
	String WarehouseContactTele;
	String WarehouseStorageCapacity;
	String WarehouseFlag;
	
	public Warehouse(String warehouseNo, String warehouseName, String warehouseContact, String warehouseContactTele,
			String warehouseStorageCapacity, String warehouseFlag) {
		super();
		WarehouseNo = warehouseNo;
		WarehouseName = warehouseName;
		WarehouseContact = warehouseContact;
		WarehouseContactTele = warehouseContactTele;
		WarehouseStorageCapacity = warehouseStorageCapacity;
		WarehouseFlag = warehouseFlag;
	}

	public String getWarehouseNo() {
		return WarehouseNo;
	}

	public void setWarehouseNo(String warehouseNo) {
		WarehouseNo = warehouseNo;
	}

	public String getWarehouseName() {
		return WarehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		WarehouseName = warehouseName;
	}

	public String getWarehouseContact() {
		return WarehouseContact;
	}

	public void setWarehouseContact(String warehouseContact) {
		WarehouseContact = warehouseContact;
	}

	public String getWarehouseContactTele() {
		return WarehouseContactTele;
	}

	public void setWarehouseContactTele(String warehouseContactTele) {
		WarehouseContactTele = warehouseContactTele;
	}

	public String getWarehouseStorageCapacity() {
		return WarehouseStorageCapacity;
	}

	public void setWarehouseStorageCapacity(String warehouseStorageCapacity) {
		WarehouseStorageCapacity = warehouseStorageCapacity;
	}

	public String getWarehouseFlag() {
		return WarehouseFlag;
	}

	public void setWarehouseFlag(String warehouseFlag) {
		WarehouseFlag = warehouseFlag;
	}
}
