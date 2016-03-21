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

import com.google.gson.Gson;

import sport.entity.Address;
import sport.entity.Goods;
import sport.entity.OrderDetail;
import sport.entity.Shop;
import sport.entity.State;
import sport.entity.temp.Order;
import sport.entity.temp.OrderInfo;
import sport.service.GoodsService;
import sport.service.OrderService;
import sport.service.ShopService;

/**
 * Servlet implementation class GetAllOrderInfo
 */
@WebServlet("/GetOrderDetailsByOidServlet")
public class GetOrderDetailsByOidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService orderservice = new OrderService();
		ShopService shopService = new ShopService();
		int oid = Integer.parseInt(request.getParameter("oid"));
		List<Integer> gids = orderservice.getGidByOid(oid);
		List<OrderDetail> orderdetails = orderservice.getOrderDetailByOid(oid);
		List<Order> orders = new ArrayList<Order>();
		int counts = 0;
		OrderInfo orderInfo = new OrderInfo();
		Order order;

		
		for (OrderDetail o : orderdetails) {
			order = new Order();
			order.setOid(oid);
			System.out.println(o.getGoods().getGid());
			int count = o.getCount();
			
			order.setCount(count);
			order.setGoods(o.getGoods());
			counts = counts + count;
			orders.add(order);
		}
		Shop shop = shopService.getShopBySid(orderservice.getShopIdBygid(gids.get(0)));
		orderInfo.setShop(shop);

		Address address = orderservice.getAddressByaid(orderservice.getAddressIdByOid(oid));
		orderInfo.setAddress(address);
		State state = orderservice.getStateBystateid(orderservice.getSateIdByOid(oid));
		orderInfo.setState(state);
		orderInfo.setTotal(orderservice.getTotalByOid(oid));
		Map<String, String> orderinfos = new HashMap<String, String>();
		//
		orderinfos.put("orderlist", new Gson().toJson(orders));
		orderinfos.put("orderinfo", new Gson().toJson(orderInfo));
		//
		response.getWriter().print(new Gson().toJson(orderinfos));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
