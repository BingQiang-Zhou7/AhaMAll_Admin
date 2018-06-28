package zhou.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.dao.OrderProduct;
import zhou.db.DataProcess;

/**
 * Servlet implementation class OrderInfoServlet
 */
@WebServlet("/OutOrderInfoServlet")
public class OutOrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutOrderInfoServlet() {
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
		System.out.println("------------------------------------------------");
		System.out.println("In Here: OutOrderInfoServlet");

		if (request.getSession().getAttribute("admin") == null) {
			response.sendRedirect("pages/login/login.html");
			return;
		}
		
//		System.out.println(request.getQueryString());
		
		DeleteOrderInInfo(request);
		
		EditOrderInInfo( request);
		
		SearchOrderOutInfo(request);
		
		if (ComfirmOrderOutInfo( request , response)) {
			System.out.println("Go Here: OutboundServlet");
			System.out.println("------------------------------------------------");
			response.sendRedirect("OutboundServlet");
		}else {
			System.out.println("Go Here: pages/outorderinfo/outorderinfo.jsp");
			System.out.println("------------------------------------------------");
			response.sendRedirect("pages/outorderinfo/outorderinfo.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void SearchOrderOutInfo(HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		String pageNo2 = request.getParameter("pageNo2");
		String fuzzyStr = request.getParameter("fuzzyStr");
		String orderNo = request.getParameter("orderNo");
		String flag = request.getParameter("flag");
		String warehouse = request.getParameter("warehouse");
		
		
		if (flag != null) {
			request.getSession().setAttribute("flag", flag);
			//System.out.println(flag);
			//System.out.println(orderNo);
		}
		
		if (warehouse != null) {
			request.getSession().setAttribute("warehouse", warehouse);
			request.getSession().removeAttribute("warehouseProducts");
			//System.out.println(orderNo);
		}
		else {
			if (request.getSession().getAttribute("warehouse") != null) {
				warehouse = (String)request.getSession().getAttribute("warehouse");
			}
			else {
				System.out.println("Exception: No warehouse");
				return;
			}
		}
		
		if (orderNo != null) {
			request.getSession().setAttribute("orderNo", orderNo);
			//System.out.println(orderNo);
		}
		else {
			if (request.getSession().getAttribute("orderNo") != null) {
				orderNo = (String)request.getSession().getAttribute("orderNo");
			}
			else {
				System.out.println("Exception: No orderNo");
				return;
			}
		}

		if (pageNo2 == null) {
			if (request.getSession().getAttribute("oppPageNo") == null) {
				pageNo2 = "0";
				request.getSession().setAttribute("oppPageNo","1");
			}
			else {
				pageNo2 = String.valueOf(request.getSession().getAttribute("oppPageNo"));
				//System.out.println(pageNo2);
				int page = Integer.parseInt(pageNo2);
				pageNo2 = String.valueOf(page-1);
			}
		}
		else {
			int page = (Integer.parseInt(pageNo2));
			request.getSession().setAttribute("oppPageNo",String.valueOf(page+1));
			
			//System.out.println("111");
		}
		
		if (pageNo == null) {
			if (request.getSession().getAttribute("opPageNo") == null) {
				pageNo = "0";
				request.getSession().removeAttribute("opPageNo");
				request.getSession().setAttribute("opPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("opPageNo"));
				int page = Integer.parseInt(pageNo);
				pageNo = String.valueOf(page-1);
			}
		}
		else {
			int page = (Integer.parseInt(pageNo));
			request.getSession().setAttribute("opPageNo",String.valueOf(page+1));
			//pageNo = String.valueOf(page-1);
		}
		
//		System.out.println(pageNo+"\t"+pageNo2);
		 
		ArrayList<OrderProduct> orderProducts = new DataProcess("backstage").SearchAllProductOrder(orderNo, pageNo2);
		System.out.println("Do It: SearchAllProductOrder");
		
		ArrayList<OrderProduct> warehouseProducts = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			warehouseProducts = new DataProcess("backstage").CheckWarehouseProduct(warehouse, pageNo);
			System.out.println("Do It: CheckWarehouseProduct");
		}
		else {
			warehouseProducts = new DataProcess("backstage").CheckWarehouseProductFuzzy(warehouse, fuzzyStr, pageNo);
			//System.out.println(warehouse+"\t"+fuzzyStr+"\t"+pageNo);
			System.out.println("Do It: CheckWarehouseProductFuzzy");
		}
		
//		boolean willReturn = false;
		
		if (orderProducts == null || orderProducts.size() == 0) {
			request.getSession().removeAttribute("orderProducts");
//			willReturn = true;
		}
		else {
			request.getSession().setAttribute("orderProducts", orderProducts);
		}
		
		if (warehouseProducts == null || warehouseProducts.size() == 0) {
			request.getSession().removeAttribute("warehouseProducts");
//			willReturn = true;
		}else {
			request.getSession().setAttribute("warehouseProducts", warehouseProducts);
		}
		
//		if (willReturn == true) {
//			return ;
//		}
	}

	boolean ComfirmOrderOutInfo(HttpServletRequest request ,HttpServletResponse response)
	{
		String op = request.getParameter("op");
		String orderNo = (String)request.getSession().getAttribute("orderNo");
		String warehouse = (String)request.getSession().getAttribute("warehouse");
		if ( op != null && op.equals("save") ) {
			new DataProcess("backstage").ComfirmOrderOutInfo(orderNo,warehouse);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: ComfirmOrderInInfo");
			return true;
		}
		return false;
	}
	
	void EditOrderInInfo(HttpServletRequest request)
	{
		String orderNo = (String)request.getSession().getAttribute("orderNo");
		String pcode = request.getParameter("newCode");
		String color = request.getParameter("newColor");
		String size = request.getParameter("newSize");
		String pcount = request.getParameter("newCount");
		
		if (pcode != null && color != null && size != null && pcount != null) {
			new DataProcess("backstage").EditProductOutOrder(orderNo, pcode, color, size, pcount);
			System.out.println("Do It: EditProductInOrder");
		}
	}
	
	
	void DeleteOrderInInfo(HttpServletRequest request)
	{
		String orderNo = (String)request.getSession().getAttribute("orderNo");
		String code = request.getParameter("code");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		if ( code != null && color !=null && size != null) {
			new DataProcess("backstage").DeleteProductOrder(orderNo, code, color, size);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteProductOrder");
		}
	}
}
