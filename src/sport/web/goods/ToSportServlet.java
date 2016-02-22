package sport.web.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Shop;
import sport.service.ShopService;

/**
 * Servlet implementation class ToSportServlet
 */
@WebServlet("/ToSportServlet")
public class ToSportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int sid = (Integer) request.getAttribute("sid");
		ShopService shopService = new ShopService();
		Shop shop = shopService.getShopBySid(sid);
		if (null != shop) {
			request.setAttribute("shop", shop);
		}
		request.getRequestDispatcher("sport.jsp").forward(request, response);
	}

}
