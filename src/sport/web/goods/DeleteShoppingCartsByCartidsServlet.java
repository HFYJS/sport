package sport.web.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.service.ShoppingCartService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class DeleteShoppingCartsByCartidsServlet
 */
@WebServlet("/DeleteShoppingCartsByCartidsServlet")
public class DeleteShoppingCartsByCartidsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteShoppingCartsByCartidsServlet() {
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
		String cartidsJson = request.getParameter("cartids");
		String[] cartidsStr = new Gson().fromJson(cartidsJson,
				new TypeToken<String[]>() {
				}.getType());

		int[] cartids = new int[cartidsStr.length];
		for (int i = 0; i < cartidsStr.length; i++) {
			cartids[i] = Integer.parseInt(cartidsStr[i]);
		}

		new ShoppingCartService().deleteShoppingCartsByCartids(cartids);
	}

}
