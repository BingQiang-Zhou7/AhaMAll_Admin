package zhou.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.dao.OrderOut;
import zhou.db.DataProcess;

/**
 * Servlet implementation class OutboundServlet
 */
@WebServlet("/OutboundServlet")
public class OutboundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutboundServlet() {
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
		System.out.println("In Here: OutboundServlet");
		
		DeleteOrderInInfo(request);
		
		EditOrderInInfo(request);
		
		SearchOrderOutInfo(request);
		
		System.out.println("Go Here: pages/outbound/outbound.jsp");
		System.out.println("------------------------------------------------");
		response.sendRedirect("pages/outbound/outbound.jsp");
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
		
		if (pageNo == null) {
			if (request.getSession().getAttribute("oOPageNo") == null) {
				pageNo = "0";
				request.getSession().setAttribute("oOPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("oOPageNo"));
				int page = (Integer.valueOf(pageNo));
				pageNo = String.valueOf(page-1);
				request.getSession().setAttribute("oOPageNo",page);
			}
		}
		else {
			int page = (Integer.valueOf(pageNo)+1);
			request.getSession().setAttribute("oOPageNo",page);
		}
		
		ArrayList<OrderOut> orderOuts = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			orderOuts = new DataProcess("backstage").SearchAllOrderOut(pageNo);
			System.out.println("Do It: SearchAllOrderOut");
		}
		else {
			orderOuts = new DataProcess("backstage").SearchOrderOutFuzzy(fuzzyStr, pageNo);
			System.out.println("Do It: SearchOrderOutFuzzy");
		}

		if (orderOuts.size() == 0) {
			request.getSession().removeAttribute("orderOuts");
			return;
		}
		
		request.getSession().removeAttribute("orderOuts");
		request.getSession().setAttribute("orderOuts", orderOuts);
	}

	void EditOrderInInfo(HttpServletRequest request)
	{
		String orderOutNo = request.getParameter("newNo");
		String orderOutWarehouse = request.getParameter("newWarehouse");
		String orderOutRperson = request.getParameter("newReceive");
		String orderOutTel = request.getParameter("newtelephone");
		String orderOutPerson;
		if (request.getSession().getAttribute("admin") != null) {
			orderOutPerson = (String)request.getSession().getAttribute("admin");
		}
		else {
			orderOutPerson = "admin";
		}
		if (orderOutNo != null && orderOutWarehouse != null && orderOutRperson != null && orderOutTel != null) {
			if (orderOutNo.equals("auto generate")) {
				orderOutNo = "O"+String.valueOf(System.currentTimeMillis());
			}
			new DataProcess("backstage").EditOrderOutInfo(orderOutNo, orderOutPerson, orderOutWarehouse, orderOutRperson, orderOutTel);
			System.out.println("Do It: EditOrderOutInfo");
		}
	}
	
	
	void DeleteOrderInInfo(HttpServletRequest request)
	{
		String orderOutNo = request.getParameter("orderOutNo");
		if ( orderOutNo != null && orderOutNo != "") {
			new DataProcess("backstage").DeleteOrderOutInfo(orderOutNo);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteOrderOutInfo");
		}
	}
}
