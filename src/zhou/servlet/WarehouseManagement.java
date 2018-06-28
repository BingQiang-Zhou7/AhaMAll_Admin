package zhou.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import zhou.dao.Warehouse;
import zhou.db.DataProcess;

/**
 * Servlet implementation class WarehouseManagement
 */
@WebServlet("/WarehouseManagement")
public class WarehouseManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarehouseManagement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		
		if (request.getSession().getAttribute("admin") == null) {
			response.sendRedirect("pages/login/login.html");
			return;
		}
		
		System.out.println("----------------------------------------------------------");
		System.out.println("In Here: WarehouseManagementServlet");
		
		EditWarehouseInfo(request);
		
		DeleteProductInfo(request);
		
		SearchProductInfo(request);
		
		System.out.println("Go Here: pages/warehousemanagement/warehousemanagement.jsp");
		System.out.println("----------------------------------------------------------");
		response.sendRedirect("pages/warehousemanagement/warehousemanagement.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	void EditWarehouseInfo(HttpServletRequest request)
	{
		//System.out.println(request.getRequestURI()+request.getQueryString());
		String warehouseNo = request.getParameter("newNumber");
		String warehouseName = request.getParameter("newName");
		String warehouseContact = request.getParameter("newAdministrator");
		String warehouseContactTele = request.getParameter("newTelephone");
		//System.out.println(warehouseNo+"\t"+warehouseName+"\t"+warehouseContact+"\t"+warehouseContactTele);
		if (warehouseNo != null && warehouseName != null && warehouseContact != null 
				&& warehouseContactTele != null) {
			new DataProcess("backstage").EditWarehouseInfo(warehouseNo, warehouseName, warehouseContact, warehouseContactTele);
			System.out.println("Do It: EditWarehouseInfo");
		}
	}
	
	
	void DeleteProductInfo(HttpServletRequest request)
	{
		String warehouseNo = request.getParameter("warehouseNo");
		if ( warehouseNo != null && warehouseNo != "") {
			new DataProcess("backstage").DeleteWarehouseInfo(warehouseNo);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteWarehouseInfo");
		}
	}
	
	void SearchProductInfo(HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		String fuzzyStr = request.getParameter("fuzzyStr");
		
		if (pageNo == null) {
			if (request.getSession().getAttribute("wPageNo") == null) {
				pageNo = "0";
				request.getSession().setAttribute("wPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("wPageNo"));
				int page = Integer.parseInt(pageNo);
				pageNo = String.valueOf(page-1);
				request.getSession().setAttribute("wPageNo",page);
			}
		}
		else {
			int page = (Integer.parseInt(pageNo)+1);
			request.getSession().setAttribute("wPageNo",page);
		}
		ArrayList<Warehouse> warehouses = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			warehouses = new DataProcess("backstage").SearchAllWarehouse(pageNo);
			System.out.println("Do It: SearchAllWarehouse");
		}
		else {
			warehouses = new DataProcess("backstage").SearchWarehouseFuzzy(fuzzyStr, pageNo);
			System.out.println("Do It: SearchWarehouseFuzzy");
		}
		if (warehouses.size() == 0) {
			//System.out.println("11");
			request.getSession().removeAttribute("warehouses");
			return;
		}
		//System.out.println("22");
		request.getSession().removeAttribute("warehouses");
		request.getSession().setAttribute("warehouses", warehouses);
	}
}
