package zhou.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhou.dao.Product;
import zhou.db.DataProcess;

/**
 * Servlet implementation class ProductManagement
 */
@WebServlet("/ProductManagement")
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagement() {
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
		System.out.println("In Here: ProductManagementServlet");
		
		EditProductInfo(request);
		
		DeleteProductInfo(request);
		
		SearchProductInfo(request);
		
		System.out.println("Go Here: pages/productmanagement/productmanagement.jsp");
		System.out.println("------------------------------------------------------");
		response.sendRedirect("pages/productmanagement/productmanagement.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	void EditProductInfo(HttpServletRequest request)
	{
		String clothingCode = request.getParameter("newCode");
		String clothingColor = request.getParameter("newColor");
		String clothingSize = request.getParameter("newSize");
		String clothingName = request.getParameter("newName");
		String clothingPrice = request.getParameter("newPrice");
		if (clothingCode != null && clothingColor != null && clothingSize != null 
				&& clothingName != null && clothingPrice != null) {
			new DataProcess("backstage").EditProductInfo(clothingCode, clothingColor, 
					clothingSize, clothingName, clothingPrice);
			System.out.println("Do It: EditUserInfo");
		}
	}
	
	
	void DeleteProductInfo(HttpServletRequest request)
	{
		String clothingCode = request.getParameter("code");
		if ( clothingCode != null && clothingCode != "") {
			new DataProcess("backstage").DeleteProductInfo(clothingCode);
//			response.sendRedirect("pages/usermanagement/usermanagement.jsp");
//			return ;
			System.out.println("Do It: DeleteProductInfo");
		}
	}
	
	void SearchProductInfo(HttpServletRequest request)
	{
		String pageNo = request.getParameter("pageNo");
		String fuzzyStr = request.getParameter("fuzzyStr");
		
		if (pageNo == null) {
			pageNo = "0";
		}
		
		ArrayList<Product> products = null;
		if (fuzzyStr == null || fuzzyStr == "" ) {
			products = new DataProcess("backstage").SearchAllProduct(pageNo);
			System.out.println("Do It: SearchAllProduct");
		}
		else {
			products = new DataProcess("backstage").SearchProductFuzzy(fuzzyStr, pageNo);
			System.out.println("Do It: SearchProductFuzzy");
		}
		request.getSession().setAttribute("products", products);
	}
}
