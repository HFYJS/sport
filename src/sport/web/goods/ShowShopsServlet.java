package sport.web.goods;

import java.io.IOException;
import java.io.PrintWriter;
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
import sport.entity.Shop;
import sport.service.GoodsService;
import sport.service.ShopService;

import com.google.gson.Gson;

/**
 * Servlet implementation class ShowShopsServlet
 */
@WebServlet("/ShowShopsServlet")
public class ShowShopsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowShopsServlet() {
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
		ShopService shopService = new ShopService();
		GoodsService goodsService = new GoodsService();
		List<Shop> shops = shopService.getAllShops();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		PrintWriter out = response.getWriter();

		for (Shop shop : shops) {
			List<Goods> goodses = goodsService.getAllGoodsBySid(shop.getSid());
			int n = 0;
			for (Goods goods : goodses) {
				n += goods.getSales();
			}

			Map<String, String> map = new HashMap<String, String>();
			map.put("path", shop.getImgPath());
			map.put("name", shop.getName());
			map.put("sales", n + "");
			map.put("count", goodses.size() + "");

			list.add(map);
		}

		out.print(new Gson().toJson(list));
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
