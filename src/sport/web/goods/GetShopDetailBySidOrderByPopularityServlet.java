package sport.web.goods;

import java.io.IOException;
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
 * Servlet implementation class GetAllGoodsesBySidServlet
 */
@WebServlet("/GetShopDetailBySidOrderByPopularityServlet")
public class GetShopDetailBySidOrderByPopularityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetShopDetailBySidOrderByPopularityServlet() {
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
		String sidStr = request.getParameter("sid");
		int sid = 0;
		if (null != sidStr) {
			sid = Integer.parseInt(request.getParameter("sid"));
		}

		Map<String, String> map = new HashMap<String, String>();

		ShopService shopService = new ShopService();
		Shop shop = shopService.getShopBySid(sid);
		map.put("shop", new Gson().toJson(shop));

		GoodsService goodsService = new GoodsService();
		List<Goods> goodses = goodsService
				.getAllGoodsesBySidOrderByPopularity(sid);
		map.put("goodses", new Gson().toJson(goodses));

		response.getWriter().print(new Gson().toJson(map));
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
