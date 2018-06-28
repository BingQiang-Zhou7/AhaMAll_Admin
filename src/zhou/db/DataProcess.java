package zhou.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zhou.dao.OrderIn;
import zhou.dao.OrderOut;
import zhou.dao.OrderProduct;
import zhou.dao.Product;
import zhou.dao.User;
import zhou.dao.Warehouse;
import zhou.db.DataAccess;

public class DataProcess {
	DataAccess dataAccess;
	
	public DataProcess(String dbName) {
		dataAccess = new DataAccess(dbName);
	}
	//关闭连接
	public void closeConnect() {
		dataAccess.colseConnect();
	}
	//登录验证
	public boolean CheckUser(String adminName,String password,String sign) {
		if (password == null) {
			password = "null";
		}
		Object[] parameter = new Object[] {adminName,password,sign};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_CheckUser(?,?,?)", parameter);
		try {
			//没有输入密码时验证管理员是否存在
			if (password == "null") {
				while (resultSet.next()) {
					if (resultSet.getString(1).equals("1")) {
						return true;//存在
					}
					return false;
				}
			}
			//验证管理员信息
			else {
				while (resultSet.next()) {
					if (resultSet.getString(1) != null) {
						return true;
					}
				}
				return false;
			}
			
			resultSet.close();
			closeConnect();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	//修改密码
	public boolean ChangePassword(String adminName,String password) {
		Object[] parameter = new Object[] {adminName,password};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_ChangePassword(?,?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	} 

	
	public boolean DeleteUserInfo(String adminAccount) {
		Object[] parameter = new Object[] {adminAccount};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_DeleteUserInfo(?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	} 
	
	public ArrayList<User> SearchAllUser(String pageNo) {
		
		Object[] parameter = new Object[] {pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllUser(?)", parameter);
		ArrayList<User> users = new ArrayList<User>();
			try {
				while (resultSet.next()) {
					users.add(new User(resultSet.getString("UserAccount"), resultSet.getString("UserName"),
							resultSet.getString("UserPassword"), resultSet.getString("UserDescription"),
							resultSet.getString("UserFlag"), resultSet.getString("UserSign")));
					//System.out.println("heloo");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			//System.out.println(dataAccess.getErrorStr());
			return users;
	}
	
	public ArrayList<User> SearchUserFuzzy(String fuzzyStr, String pageNo) {
		
		Object[] parameter = new Object[] {fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchUserFuzzy(?,?)", parameter);
		ArrayList<User> users = new ArrayList<User>();
			try {
				while (resultSet.next()) {
					users.add(new User(resultSet.getString("UserAccount"), resultSet.getString("UserName"),
							resultSet.getString("UserPassword"), resultSet.getString("UserDescription"),
							resultSet.getString("UserFlag"), resultSet.getString("UserSign")));
					//System.out.println("heloo");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			//System.out.println(dataAccess.getErrorStr());
			return users;
	}
	
	public void EditUser(String UserAccount,String UserName,String UserPassword,String UserDescription) {
		Object[] parameter = new Object[] {UserAccount,UserName,UserPassword,UserDescription};

		dataAccess.DatabaseOperations("call Proc_EditUserInfo(?,?,?,?)", parameter);
	}
	
	public boolean CheckProduct(String clothingCode) {
		Object[] parameter = new Object[] {clothingCode};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_CheckProduct(?)", parameter);
		try {
				while (resultSet.next()) {
					if (resultSet.getString(1).equals("1")) {
						return true;//存在
					}
					return false;
				}
			resultSet.close();
			closeConnect();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	
	
	public boolean DeleteProductInfo(String clothingCode) {
		Object[] parameter = new Object[] {clothingCode};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_DeleteProductInfo(?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	} 
	
	public ArrayList<Product> SearchAllProduct(String pageNo) {
		
		Object[] parameter = new Object[] {pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllProduct(?)", parameter);
		ArrayList<Product> products = new ArrayList<Product>();
			try {
				while (resultSet.next()) {
					products.add(new Product(resultSet.getString("ClothingCode"), resultSet.getString("ClothingColor"),
							resultSet.getString("ClothingSize"),resultSet.getString("ClothingName"),
							resultSet.getString("ClothingOuterM"),resultSet.getString("ClothingInnerM"), 
							resultSet.getString("ClothingPrice"), resultSet.getString("ClothingFlag"),resultSet.getString("ClothingCount")));
					//System.out.println("heloo");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			//System.out.println(dataAccess.getErrorStr());
			return products;
	}
	
	public ArrayList<Product> SearchProductFuzzy(String fuzzyStr, String pageNo) {
		
		Object[] parameter = new Object[] {fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchProductFuzzy(?,?)", parameter);
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			while (resultSet.next()) {
				products.add(new Product(resultSet.getString("ClothingCode"), resultSet.getString("ClothingColor"),
						resultSet.getString("ClothingSize"),resultSet.getString("ClothingName"),
						resultSet.getString("ClothingOuterM"),resultSet.getString("ClothingInnerM"), 
						resultSet.getString("ClothingPrice"), resultSet.getString("ClothingFlag"),resultSet.getString("ClothingCount")));
				//System.out.println("heloo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return products;
	}
	
	public void EditProductInfo(String clothingCode,String clothingColor,String clothingSize,
			String clothingName,String clothingPrice,String clothingCount) {
		Object[] parameter = new Object[] {clothingCode,clothingColor,clothingSize,clothingName,clothingPrice,clothingCount};

		dataAccess.DatabaseOperations("call Proc_EditProductInfo(?,?,?,?,?,?)", parameter);
	}
	
	
	public boolean CheckWarehouse(String warehouseNo) {
		Object[] parameter = new Object[] {warehouseNo};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_CheckWarehouse(?)", parameter);
		try {
				while (resultSet.next()) {
					if (resultSet.getString(1).equals("1")) {
						return true;//存在
					}
					return false;
				}
			resultSet.close();
			closeConnect();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	
	
	public boolean DeleteWarehouseInfo(String warehouseNo) {
		Object[] parameter = new Object[] {warehouseNo};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_DeleteWarehouseInfo(?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	} 
	
	public ArrayList<Warehouse> SearchAllWarehouse(String pageNo) {
		
		Object[] parameter = new Object[] {pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllWarehouse(?)", parameter);
		ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
			try {
				while (resultSet.next()) {
					warehouses.add(new Warehouse(resultSet.getString("WarehouseNo"), resultSet.getString("WarehouseName"),
							resultSet.getString("WarehouseContact"),resultSet.getString("WarehouseContactTele"),
							resultSet.getString("WarehouseStorageCapacity"),resultSet.getString("WarehouseFlag")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			//System.out.println(dataAccess.getErrorStr());
			return warehouses;
	}
	
	public String SearchAllWarehouseInfo() {
	
		String warehouseInfo = new String("");
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllWarehouseInfo()", null);
			try {
				while (resultSet.next()) {
					warehouseInfo=warehouseInfo+resultSet.getString("WarehouseNo")+"_";
					//System.out.println(resultSet.getString("WarehouseNo"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			//System.out.println(dataAccess.getErrorStr());
			return warehouseInfo;
	}
	
	public ArrayList<Warehouse> SearchWarehouseFuzzy(String fuzzyStr, String pageNo) {
		
		Object[] parameter = new Object[] {fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchWarehouseFuzzy(?,?)", parameter);
		ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
		try {
			while (resultSet.next()) {
				warehouses.add(new Warehouse(resultSet.getString("WarehouseNo"), resultSet.getString("WarehouseName"),
						resultSet.getString("WarehouseContact"),resultSet.getString("WarehouseContactTele"),
						resultSet.getString("WarehouseStorageCapacity"),resultSet.getString("WarehouseFlag")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return warehouses;
	}
	
	public void EditWarehouseInfo(String warehouseNo,String warehouseName,
			String warehouseContact,String warehouseContactTele) {
		Object[] parameter = new Object[] {warehouseNo,warehouseName,warehouseContact,warehouseContactTele};

		dataAccess.DatabaseOperations("call Proc_EditWarehouseInfo(?,?,?,?)", parameter);
	}
	
	public ArrayList<OrderIn> SearchAllOrderIn(String pageNo) {
		
		Object[] parameter = new Object[] {pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllOrderIn(?)", parameter);
		ArrayList<OrderIn> orderIns = new ArrayList<OrderIn>();
		try {
			while (resultSet.next()) {
				orderIns.add(new OrderIn(resultSet.getString("OrderInNo"), resultSet.getString("OrderInDate"),
						resultSet.getString("OrderinPerson"),resultSet.getString("OrderInWarehouse"),
						resultSet.getString("OrderInBefrom"),resultSet.getString("OrderInRemark"),resultSet.getString("OrderInFlag")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderIns;
	}
	
	public ArrayList<OrderIn> SearchOrderInFuzzy(String fuzzyStr, String pageNo) {
		
		Object[] parameter = new Object[] {fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchOrderInFuzzy(?,?)", parameter);
		ArrayList<OrderIn> orderIns = new ArrayList<OrderIn>();
		try {
			while (resultSet.next()) {
				orderIns.add(new OrderIn(resultSet.getString("OrderInNo"), resultSet.getString("OrderInDate"),
						resultSet.getString("OrderinPerson"),resultSet.getString("OrderInWarehouse"),
						resultSet.getString("OrderInBefrom"),resultSet.getString("OrderInRemark"),resultSet.getString("OrderInFlag")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderIns;
	}
	
	public boolean DeleteOrderInInfo(String orderInNo) {
		Object[] parameter = new Object[] {orderInNo};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_DeleteOrderInInfo(?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	} 
	public boolean ComfirmOrderInInfo(String orderInNo,String warehouse) {
		Object[] parameter = new Object[] {orderInNo,warehouse};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_ComfirmOrderInInfo(?,?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	}
	
	public void EditOrderInInfo(String orderInNo,String orderinPerson,
			String orderInWarehouse,String orderInBefrom) {
		Object[] parameter = new Object[] {orderInNo,orderinPerson,orderInWarehouse,orderInBefrom};

		dataAccess.DatabaseOperations("call Proc_EditOrderInInfo(?,?,?,?)", parameter);
	}
	public ArrayList<OrderOut> SearchAllOrderOut(String pageNo) {
		
		Object[] parameter = new Object[] {pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllOrderOut(?)", parameter);
		ArrayList<OrderOut> orderOuts = new ArrayList<OrderOut>();
		try {
			while (resultSet.next()) {
				orderOuts.add(new OrderOut(resultSet.getString("OrderOutNo"), resultSet.getString("OrderOutDate"),
						resultSet.getString("OrderOutPerson"),resultSet.getString("OrderOutWarehouse"),
						resultSet.getString("OrderOutRperson"),resultSet.getString("OrderOutTel"),
						resultSet.getString("OrderOutAddress"),resultSet.getString("OrderOutRemark"),
						resultSet.getString("OrderOutFlag")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderOuts;
	}
	
	public ArrayList<OrderOut> SearchOrderOutFuzzy(String fuzzyStr, String pageNo) {
		
		Object[] parameter = new Object[] {fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchOrderOutFuzzy(?,?)", parameter);
		ArrayList<OrderOut> orderOuts = new ArrayList<OrderOut>();
		try {
			while (resultSet.next()) {
				orderOuts.add(new OrderOut(resultSet.getString("OrderOutNo"), resultSet.getString("OrderOutDate"),
						resultSet.getString("OrderOutPerson"),resultSet.getString("OrderOutWarehouse"),
						resultSet.getString("OrderOutRperson"),resultSet.getString("OrderOutTel"),
						resultSet.getString("OrderOutAddress"),resultSet.getString("OrderOutRemark"),
						resultSet.getString("OrderOutFlag")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderOuts;
	}
	
	public boolean DeleteOrderOutInfo(String orderOutNo) {
		Object[] parameter = new Object[] {orderOutNo};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_DeleteOrderOutInfo(?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	} 
	public boolean ComfirmOrderOutInfo(String orderOutNo,String warehouse) {
		Object[] parameter = new Object[] {orderOutNo,warehouse};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_ComfirmOrderOutInfo(?,?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	}
	
	public void EditProductInOrder(String orderNo,String pcode,
			String color,String size,String pcount ,String pname,String price) {
		Object[] parameter = new Object[] {orderNo,pcode,color,size,pcount,pname,price};

		dataAccess.DatabaseOperations("call Proc_EditProductInOrder(?,?,?,?,?,?,?)", parameter);
	}
	public void EditProductOutOrder(String orderNo,String pcode,
			String color,String size,String pcount) {
		Object[] parameter = new Object[] {orderNo,pcode,color,size,pcount};

		dataAccess.DatabaseOperations("call Proc_EditProductOutOrder(?,?,?,?,?)", parameter);
	}
	public ArrayList<OrderProduct> SearchAllProductOrder(String orderNo,String pageNo) {
		
		Object[] parameter = new Object[] {orderNo,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchAllProductOrder(?,?)", parameter);
		ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		try {
			while (resultSet.next()) {
				orderProducts.add(new OrderProduct(resultSet.getString("OrderInDetailsOrderNo"),resultSet.getString("OrderInDetailsCode"), 
						resultSet.getString("OrderInDetailsColor"),resultSet.getString("OrderInDetailsSize"),resultSet.getString("OrderInDetailsCount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderProducts;
	}
	
	public ArrayList<OrderProduct> SearchProductOrderFuzz(String orderNo,String fuzzyStr, String pageNo) {
		
		Object[] parameter = new Object[] {orderNo,fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_SearchProductOrderFuzzy(?,?,?)", parameter);
		ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		try {
			while (resultSet.next()) {
				orderProducts.add(new OrderProduct(resultSet.getString("OrderInDetailsOrderNo"),resultSet.getString("OrderInDetailsCode"), 
						resultSet.getString("OrderInDetailsColor"),resultSet.getString("OrderInDetailsSize"),resultSet.getString("OrderInDetailsCount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderProducts;
	}
	
	public boolean DeleteProductOrder(String orderNo,String pcode,String color,String size) {
		Object[] parameter = new Object[] {orderNo,pcode,color,size};

		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_DeleteProductOrder(?,?,?,?)", parameter);
		if (resultSet == null) {
			return true;
		}
		return false;
	}
	
	public void EditOrderOutInfo(String orderOutNo,String orderOutPerson,
			String orderOutWarehouse,String orderOutRperson,String orderOutTel) {
		Object[] parameter = new Object[] {orderOutNo,orderOutPerson,orderOutWarehouse,orderOutRperson,orderOutTel};

		dataAccess.DatabaseOperations("call Proc_EditOrderOutInfo(?,?,?,?,?)", parameter);
	}
	public ArrayList<OrderProduct> CheckWarehouseProduct(String orderNo,String pageNo) {
		
		Object[] parameter = new Object[] {orderNo,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_CheckWarehouseProduct(?,?)", parameter);
		ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		try {
			if (resultSet == null) {
				return null;
			}
			while (resultSet.next()) {
				orderProducts.add(new OrderProduct(resultSet.getString("OrderInDetailsOrderNo"),resultSet.getString("OrderInDetailsCode"), 
						resultSet.getString("OrderInDetailsColor"),resultSet.getString("OrderInDetailsSize"),resultSet.getString("OrderInDetailsCount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderProducts;
	}
	public ArrayList<OrderProduct> CheckWarehouseProductFuzzy(String orderNo,String fuzzyStr,String pageNo) {
		
		Object[] parameter = new Object[] {orderNo,fuzzyStr,pageNo};
		ResultSet resultSet = dataAccess.DatabaseOperations("call Proc_CheckWarehouseProductFuzzy(?,?,?)", parameter);
		ArrayList<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
		try {
			if (resultSet == null) {
				return null;
			}
			while (resultSet.next()) {
				orderProducts.add(new OrderProduct(resultSet.getString("OrderInDetailsOrderNo"),resultSet.getString("OrderInDetailsCode"), 
						resultSet.getString("OrderInDetailsColor"),resultSet.getString("OrderInDetailsSize"),resultSet.getString("OrderInDetailsCount")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		//System.out.println(dataAccess.getErrorStr());
		return orderProducts;
	}
}
