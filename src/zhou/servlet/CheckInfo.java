package zhou.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.db.DataProcess;

/**
 * Servlet implementation class CheckInfo
 */
@WebServlet("/CheckInfo")
public class CheckInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInfo() {
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
		
		boolean isExist = false;
		switch (request.getParameter("type").charAt(0)) {
		case 'u':
			//System.out.println("hello");
			isExist = CheckUserIsExist(request);
			break;
		default:
			break;
		}
		out.print(isExist);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	boolean CheckUserIsExist(HttpServletRequest request)
	{
		String user = request.getParameter("user");
		//System.out.println("111");
		boolean result = new DataProcess("backstage").CheckUser(user, "null","0");
		return result;
	}
}
