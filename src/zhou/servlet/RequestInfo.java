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
 * Servlet implementation class RequestInfo
 */
@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestInfo() {
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
		
		String info = null;
		switch (request.getParameter("type").charAt(0)) {
		case 'i':
			info = GetWarehouseInfo();
			//System.out.println(info);
			break;
		case 'o':
			//isExist = CheckProductIsExist(request);
		default:
			break;
		}
		out.print(info);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	String GetWarehouseInfo()
	{
		return new DataProcess("backstage").SearchAllWarehouseInfo();
	}
}
