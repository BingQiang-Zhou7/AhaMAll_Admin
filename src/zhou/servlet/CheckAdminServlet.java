package zhou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.db.DataProcess;

/**
 * Servlet implementation class CheckAdminServlet
 */
@WebServlet("/CheckAdminServlet")
public class CheckAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");
		
		//System.out.println(admin+"\t"+password);
		
		boolean result = new DataProcess("AhaMall").CheckAdmin(admin, password);
		
		if (password != null && result == true) {
			System.out.println("go Here:pages/index/index.html result: "+result);
			response.sendRedirect("pages/index/index.html");
		}
		else if(password != null && result == false){
			System.out.println("go Here:pages/login/login.html?isNotMatch=true result: "+result);
			response.sendRedirect("pages/login/login.html?isNotMatch=true");
		}
		else {
			out.print(result);
			out.flush();
			System.out.println("go Here:CheckAdminServlet result: "+result);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
