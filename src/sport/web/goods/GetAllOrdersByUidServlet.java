package sport.web.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Goods;
import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.Shop;
import sport.entity.temp.Order;
import sport.entity.temp.OrderInfo;
import sport.service.OrderService;
import sport.service.ShopService;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetAllOrdersServlet
 */
@WebServlet("/GetAllOrdersByUidServlet")
public class GetAllOrdersByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderService();
		ShopService shopService = new ShopService();

		// 获取orderform
		int uid = Integer.parseInt(request.getParameter("uid"));
		List<OrderForm> orderForms = service.getAllOrderFormByUid(uid);
		// 获取orderdetails
		List<Integer> oids = service.getOidByUid(uid);
		List<List<OrderDetail>> orderdetailslist = new ArrayList<List<OrderDetail>>();
		List<OrderDetail> orderdetails = null;
		List<Integer> gids = null;
		List<List<Integer>> gidslist = new ArrayList<List<Integer>>();
		Set<Integer> sids = new HashSet<>();
		Set<Shop> shops = new HashSet<Shop>();
		List<Goods> goodslist = new ArrayList<Goods>();
		// List<String> shopnames = new ArrayList<String>();
		// List<String> goodsnames = new ArrayList<String>();
		// List<String> total = new ArrayList<String>();
		// List<Date> dates = new ArrayList<Date>();

		List<List<Order>> orderlists = new ArrayList<List<Order>>();
		List<OrderInfo> orderinfolist = new ArrayList<OrderInfo>();
		List<Integer> countlist = new ArrayList<Integer>();

		System.out.println(oids);
		for (Integer i : oids) {
			List<Order> orderlist = new ArrayList<Order>();
			;
			int counts = 0;
			orderdetails = service.getOrderDetailByOid(i);
			for (int a = 0; a < orderdetails.size(); a++) {

				Order order = new Order();
				// goodslist.add(orderdetails.get(a).getGoods());
				String goodsname = orderdetails.get(a).getGoods().getName();
				String goodsimage = orderdetails.get(a).getGoods().getImgPath();
				double goodsprice = orderdetails.get(a).getGoods().getPrice();
				int count = orderdetails.get(a).getCount();
				order.setCount(count);
				order.setGoodsName(goodsname);
				order.setImgPath(goodsimage);
				order.setPrice(goodsprice);
				order.setOid(i);
				counts = count + counts;
				orderlist.add(order);
				// goodsnames.add(goodsname);
			}
			orderlists.add(orderlist);
			System.out.println(orderlists.size());
			// orderlist.clear();
			gids = service.getGidByOid(i);
			String shopname = null;
			String shopimage = null;
			for (Integer j : gids) {
				int sid = service.getShopIdBygid(j);
				shopname = shopService.getShopBySid(sid).getName();
				shopimage = shopService.getShopBySid(sid).getImgPath();
				sids.add(sid);
			}

			int stateid = service.getSateIdByOid(i);
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOid(i);
			orderInfo.setShopName(shopname);
			orderInfo.setSum(counts);
			orderInfo
					.setStateName(service.getStateBystateid(stateid).getName());
			orderInfo.setTotal(service.getTotalByOid(i));
			orderInfo.setShopImage(shopimage);
			// orderInfo.setDate(service.getDateByOid(i));
			orderinfolist.add(orderInfo);
			orderdetailslist.add(orderdetails);
			gidslist.add(gids);
			countlist.add(counts);
		}
		// 获取shop
		// for(Integer s:sids){
		// Shop shop = shopService.getShopBySid(s);
		// String shopname = shop.getName();
		// shopnames.add(shopname);
		// shops.add(shop);
		// }
		//
		// for(OrderForm order : orderForms){
		// String price = order.getTotal()+"";
		// Date date = order.getDate();
		// total.add(price);
		// dates.add(date);
		// }

		Map<String, String> orderinfo = new HashMap<String, String>();
		// orderinfo.put("shop", new Gson().toJson(shops));
		// orderinfo.put("goods", new Gson().toJson(goodslist));
		// orderinfo.put("oids", new Gson().toJson(oids));
		// orderinfo.put("countlist", new Gson().toJson(countlist));
		// orderinfo.put("orderdetailslist", new
		// Gson().toJson(orderdetailslist));
		orderinfo.put("orderlist", new Gson().toJson(orderlists));
		orderinfo.put("orderinfolist", new Gson().toJson(orderinfolist));

		response.getWriter().print(new Gson().toJson(orderinfo));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
