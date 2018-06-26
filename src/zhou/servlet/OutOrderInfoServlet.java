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

		System.out.println(request.getQueryString());
		
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
		String fuzzyStr = request.getParameter("fuzzyStr");
		String orderNo = request.getParameter("orderNo");
		String flag = request.getParameter("flag");
		
		
		if (flag != null) {
			request.getSession().setAttribute("flag", flag);
			System.out.println(flag);
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
			if (request.getSession().getAttribute("opPageNo") == null) {
				pageNo = "0";
				request.getSession().setAttribute("opPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("opPageNo"));
				int page = (Integer.valueOf(pageNo));
				pageNo = String.valueOf(page-1);
				request.getSession().setAttribute("opPageNo",page);
			}
		}
		else {
			int page = (Integer.valueOf(pageNo)+1);
			request.getSession().setAttribute("opPageNo",page);
		}
		
		ArrayList<OrderProduct> orderProducts = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			orderProducts = new DataProcess("backstage").SearchAllProductOutOrder(orderNo, pageNo);
			System.out.println("Do It: SearchAllOrderOut");
		}
		else {
			orderProducts = new DataProcess("backstage").SearchProductOutOrderFuzzy(orderNo, fuzzyStr, pageNo);
			System.out.println("Do It: SearchOrderOutFuzzy");
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
		if ( op != null && op.equals("save") ) {
			new DataProcess("backstage").ComfirmOrderOutInfo(orderNo);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: ComfirmOrderOutInfo");
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
			new DataProcess("backstage").EditProductOutOrder(orderNo, pcode, color, size, pcount, pname, price);
			System.out.println("Do It: EditProductOutOrder");
		}
	}
	
	
	void DeleteOrderInInfo(HttpServletRequest request)
	{
		String orderNo = (String)request.getSession().getAttribute("orderNo");
		String code = request.getParameter("code");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		if ( code != null && color !=null && size != null) {
			new DataProcess("backstage").DeleteProductOutOrder(orderNo, code, color, size);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteProductOutOrder");
		}
	}
}
