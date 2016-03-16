package sport.web.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Goods;
import sport.entity.ShoppingCart;
import sport.service.GoodsService;
import sport.service.ShoppingCartService;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetShoppingCartByUidServlet
 */
@WebServlet("/GetShoppingCartByUidServlet")
public class GetShoppingCartByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetShoppingCartByUidServlet() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));

		ShoppingCartService shoppingCartService = new ShoppingCartService();
		GoodsService goodsService = new GoodsService();
		List<ShoppingCart> shoppingCart = shoppingCartService
				.getShoppingCartByUid(uid);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (ShoppingCart sc : shoppingCart) {
			Map<String, String> map = new HashMap<String, String>();
			Goods goods = goodsService.getGoodsByGid(sc.getGid());
			map.put("goods", new Gson().toJson(goods));
			map.put("count", sc.getCount() + "");
			list.add(map);
		}
		
		response.getWriter().print(new Gson().toJson(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
