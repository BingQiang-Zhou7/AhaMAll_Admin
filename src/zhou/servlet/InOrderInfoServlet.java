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
@WebServlet("/InOrderInfoServlet")
public class InOrderInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InOrderInfoServlet() {
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
		
		System.out.println("------------------------------------------------");
		System.out.println("In Here: InOrderInfoServlet");
		
		System.out.println(request.getQueryString());
		
		DeleteOrderInInfo(request);
		
		EditOrderInInfo( request);
		
		SearchOrderOutInfo(request);
		
		if (ComfirmOrderOutInfo( request , response)) {
			System.out.println("Go Here: InboundServlet");
			System.out.println("------------------------------------------------");
			response.sendRedirect("InboundServlet");
		}else {
			System.out.println("Go Here: pages/inorderinfo/inorderinfo.jsp");
			System.out.println("------------------------------------------------");
			response.sendRedirect("pages/inorderinfo/inorderinfo.jsp");
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
			//System.out.println(flag);
			//System.out.println(orderNo);
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

		if (pageNo == null) {
			if (request.getSession().getAttribute("ipPageNo") == null) {
				pageNo = "0";
				request.getSession().setAttribute("ipPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("ipPageNo"));
				int page = Integer.parseInt(pageNo);
				pageNo = String.valueOf(page-1);
				request.getSession().setAttribute("ipPageNo",page);
			}
		}
		else {
			int page = (Integer.parseInt(pageNo)+1);
			request.getSession().setAttribute("ipPageNo",page);
		}
		
		ArrayList<OrderProduct> orderProducts = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			orderProducts = new DataProcess("backstage").SearchAllProductOrder(orderNo, pageNo);
			System.out.println("Do It: SearchAllProductOrder");
		}
		else {
			orderProducts = new DataProcess("backstage").SearchProductOrderFuzz(orderNo, fuzzyStr, pageNo);
			System.out.println("Do It: SearchProductOrderFuzz");
		}

		if (orderProducts.size() == 0) {
			request.getSession().removeAttribute("orderProducts");
			return;
		}
		
		request.getSession().removeAttribute("orderProducts");
		request.getSession().setAttribute("orderProducts", orderProducts);
	}

	boolean ComfirmOrderOutInfo(HttpServletRequest request ,HttpServletResponse response)
	{
		String op = request.getParameter("op");
		String orderNo = (String)request.getSession().getAttribute("orderNo");
		String warehouse = (String)request.getSession().getAttribute("warehouse");
		if ( op != null && op.equals("save") ) {
			new DataProcess("backstage").ComfirmOrderInInfo(orderNo,warehouse);
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
		String pname = request.getParameter("newName");
		String price = request.getParameter("newPrice");
		String pcount = request.getParameter("newCount");
		
		if (pcode != null && color != null && size != null && pname != null && price != null && pcount != null) {
			new DataProcess("backstage").EditProductInOrder(orderNo, pcode, color, size, pcount, pname, price);
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
