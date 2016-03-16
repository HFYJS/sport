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
import sport.entity.Shop;
import sport.service.GoodsService;
import sport.service.ShopService;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetPagedShopsByCatidServlet
 */
@WebServlet("/ShowPagedShopsByCatidServlet")
public class ShowPagedShopsByCatidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowPagedShopsByCatidServlet() {
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
		int catid = Integer.parseInt(request.getParameter("catid"));
		int pageStart = Integer.parseInt(request.getParameter("pageStart"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));

		List<Map<String, String>> lists = new ArrayList<Map<String, String>>();
		ShopService shopService = new ShopService();
		GoodsService goodsService = new GoodsService();

		List<Shop> shops = shopService.getPagedShopsByCatid(catid, pageStart,
				pageSize);
		for (Shop shop : shops) {
			List<Goods> goodses = goodsService.getAllGoodsBySid(shop.getSid());
			int n = 0;
			for (Goods goods : goodses) {
				n += goods.getSales();
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("path", shop.getImgPath());
			map.put("name", shop.getName());
			map.put("count", goodses.size() + "");
			map.put("sales", n + "");
			lists.add(map);
		}
		response.getWriter().print(new Gson().toJson(lists));
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
