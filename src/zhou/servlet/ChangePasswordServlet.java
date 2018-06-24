package zhou.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.db.DataProcess;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		System.out.println("------------------------------------------------------");
		System.out.println("In Here: ChangePasswordServlet");
		
		String admin = (String)request.getSession().getAttribute("admin");
		if (admin != null) {
			String oldPwd = request.getParameter("oldPwd");
			String password = request.getParameter("newPwd2");
			
			//System.out.println(oldPwd+"\t"+password);
			
			boolean result = new DataProcess("backstage").CheckUser(admin, oldPwd,"1");
			System.out.println("Do It: CheckUser");
			if (result == false) {
				System.out.println("Go Here: pages/changepassword/changepassword.html");
				System.out.println("------------------------------------------------");
				response.sendRedirect("pages/changepassword/changepassword.html?isNotMatch=true");
			}
			else {
				new DataProcess("backstage").ChangePassword(admin, password);
				System.out.println("Do It: ChangePassword");
				System.out.println("Go Here: pages/login/login.html");
				System.out.println("------------------------------------------------");
				response.sendRedirect("pages/login/login.html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
