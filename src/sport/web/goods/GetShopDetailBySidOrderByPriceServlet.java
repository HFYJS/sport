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
 * Servlet implementation class GetShopDetailBySidOrderByPriceServlet
 */
@WebServlet("/GetShopDetailBySidOrderByPriceServlet")
public class GetShopDetailBySidOrderByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetShopDetailBySidOrderByPriceServlet() {
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
		Double[] prices = new Double[goodses.size()];
		for (int i = 0; i < prices.length; i++) {
			if (null == goodses.get(i).getActivity()) {
				prices[i] = goodses.get(i).getPrice();
			} else {
				prices[i] = goodses.get(i).getActPrice();
			}
		}
		prices = order(prices);
		List<Goods> goodsesOrdered = new ArrayList<Goods>();
		for (int i = 0; i < prices.length; i++) {
			for (Goods goods : goodses) {
				if (null == goods.getActivity()) {
					if (prices[i] == goods.getPrice()) {
						goodsesOrdered.add(goods);
						goodses.remove(goods);
						break;
					}
				} else {
					if (prices[i] == goods.getActPrice()) {
						goodsesOrdered.add(goods);
						goodses.remove(goods);
						break;
					}
				}
			}
		}

		map.put("goodses", new Gson().toJson(goodsesOrdered));

		response.getWriter().print(new Gson().toJson(map));
	}

	private Double[] order(Double[] prices) {
		// TODO Auto-generated method stub
		double temp;

		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] > prices[j]) {
					temp = prices[i];
					prices[i] = prices[j];
					prices[j] = temp;
				}
			}
		}

		return prices;
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
