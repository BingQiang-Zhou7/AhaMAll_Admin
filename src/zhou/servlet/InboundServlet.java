package zhou.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.dao.OrderIn;
import zhou.db.DataProcess;

/**
 * Servlet implementation class InboundServlet
 */
@WebServlet("/InboundServlet")
public class InboundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboundServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		if (request.getSession().getAttribute("admin") == null) {
			response.sendRedirect("pages/login/login.html");
			return;
		}
		
		//PrintWriter out = response.getWriter();
		System.out.println("------------------------------------------------");
		System.out.println("In Here: InboundServlet");
		
		DeleteOrderInInfo(request);
		
		EditOrderInInfo(request);
		
		SearchOrderInInfo(request);
		
		System.out.println("Go Here: pages/inbound/inbound.jsp");
		System.out.println("------------------------------------------------");
		response.sendRedirect("pages/inbound/inbound.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	void SearchOrderInInfo(HttpServletRequest request)
	{
		//System.out.println(request.getSession().getAttribute("oIPageNo"));
		String pageNo = request.getParameter("pageNo");
		String fuzzyStr = request.getParameter("fuzzyStr");
		
		if (pageNo == null) {
			if (request.getSession().getAttribute("oIPageNo") == null) {
				pageNo = "0";
				request.getSession().setAttribute("oIPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("oIPageNo"));
				int page = Integer.parseInt(pageNo);
				pageNo = String.valueOf(page-1);
				request.getSession().setAttribute("oIPageNo",page);
			}
		}
		else {
			int page = (Integer.parseInt(pageNo)+1);
			request.getSession().setAttribute("oIPageNo",page);
		}
		
		ArrayList<OrderIn> orderIns = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			orderIns = new DataProcess("backstage").SearchAllOrderIn(pageNo);
			System.out.println("Do It: SearchAllOrderIn");
		}
		else {
			orderIns = new DataProcess("backstage").SearchOrderInFuzzy(fuzzyStr, pageNo);
			System.out.println("Do It: SearchOrderInFuzzy");
		}

		if (orderIns.size() == 0) {
			request.getSession().removeAttribute("orderIns");
			return;
		}
		
		request.getSession().removeAttribute("orderIns");
		request.getSession().setAttribute("orderIns", orderIns);
	}

	void EditOrderInInfo(HttpServletRequest request)
	{
		String orderInNo = request.getParameter("newNo");
		String orderInWarehouse = request.getParameter("newWarehouse");
		String orderInBefrom = request.getParameter("newFrom");
		String orderinPerson;
		if (request.getSession().getAttribute("admin") != null) {
			orderinPerson = (String)request.getSession().getAttribute("admin");
		}
		else {
			orderinPerson = "admin";
		}
		if (orderInNo != null && orderInWarehouse != null && orderInBefrom != null) {
			if (orderInNo.equals("auto generate")) {
				orderInNo = "I"+String.valueOf(System.currentTimeMillis());
			}
			new DataProcess("backstage").EditOrderInInfo(orderInNo, orderinPerson, orderInWarehouse, orderInBefrom);;
			System.out.println("Do It: EditOrderInInfo");
		}
	}
	
	
	void DeleteOrderInInfo(HttpServletRequest request)
	{
		String orderInNo = request.getParameter("OrderInNo");
		if ( orderInNo != null && orderInNo != "") {
			new DataProcess("backstage").DeleteOrderInInfo(orderInNo);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteOrderInInfo");
		}
	}
}
