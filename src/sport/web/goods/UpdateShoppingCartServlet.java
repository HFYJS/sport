package sport.web.goods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.service.ShoppingCartService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class UpdateShoppingCartServlet
 */
@WebServlet("/UpdateShoppingCartServlet")
public class UpdateShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateShoppingCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String info = request.getParameter("info");

		List<Map<String, String>> lists = new Gson().fromJson(info,
				new TypeToken<List<Map<String, String>>>() {
				}.getType());

		ShoppingCartService shoppingCartService = new ShoppingCartService();
		for (Map<String, String> map : lists) {
			int cartid = Integer.parseInt(map.get("cartid"));
			int count = Integer.parseInt(map.get("count"));
			shoppingCartService.updateShoppingCart(cartid, count);
		}
	}
}
