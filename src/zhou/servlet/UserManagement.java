package zhou.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.dao.User;
import zhou.db.DataProcess;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/UserManagement")
public class UserManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("hello,world");
		//request.getSession().setAttribute("admin", "hello");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		
		if (request.getSession().getAttribute("admin") == null) {
			response.sendRedirect("pages/login/login.html");
			return;
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("In Here: UserManagementServlet");
		
		DeleteUserInfo(request);
		
		EditUserInfo(request);
		
		SearchUserInfo(request);
		
		System.out.println("Go Here: pages/usermanagement/usermanagement.jsp");
		System.out.println("------------------------------------------------");
		response.sendRedirect("pages/usermanagement/usermanagement.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	void EditUserInfo(HttpServletRequest request)
	{
		String account = request.getParameter("userAccount");
		String name = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		String description = request.getParameter("userDescription");
		if (account != null && name != null && password != null && description != null) {
			new DataProcess("backstage").EditUser(account, name, password, description);
			System.out.println("Do It: EditUserInfo");
		}
	}
	
	void DeleteUserInfo(HttpServletRequest request)
	{
		String account = request.getParameter("account");
		if ( account != null && account != "") {
			new DataProcess("backstage").DeleteUserInfo(account);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteUserInfo");
		}
	}
	
	void SearchUserInfo(HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		String fuzzyStr = request.getParameter("fuzzyStr");
		
		if (pageNo == null) {
			if (request.getSession().getAttribute("uPageNo") == null) {
				pageNo = "0";
				request.getSession().setAttribute("uPageNo","1");
			}
			else {
				pageNo = String.valueOf(request.getSession().getAttribute("uPageNo"));
				int page = Integer.parseInt(pageNo);
				pageNo = String.valueOf(page-1);
				request.getSession().setAttribute("uPageNo",page);
			}
		}
		else {
			int page = (Integer.parseInt(pageNo)+1);
			request.getSession().setAttribute("uPageNo",page);
		}
		
		ArrayList<User> users = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			users = new DataProcess("backstage").SearchAllUser(pageNo);
			//System.out.println("hello");
			System.out.println("Do It: SearchAllUser");
		}
		else {
			users = new DataProcess("backstage").SearchUserFuzzy(fuzzyStr, pageNo);
			System.out.println("Do It: SearchUserFuzzy");
		}
		if (users.size() == 0) {
			//System.out.println("11");
			request.getSession().removeAttribute("users");
			return;
		}
		request.getSession().setAttribute("users", users);
		
	}
}
