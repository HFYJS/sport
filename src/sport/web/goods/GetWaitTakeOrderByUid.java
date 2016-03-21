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

import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.temp.Order;
import sport.entity.temp.OrderInfo;
import sport.service.OrderService;
import sport.service.ShopService;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetWaitTakeOrderByUid
 */
@WebServlet("/GetWaitTakeOrderByUid")
public class GetWaitTakeOrderByUid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderService service = new OrderService();
		ShopService shopService = new ShopService();

		// 获取orderform
		int uid = Integer.parseInt(request.getParameter("uid"));
		// 获取orderdetails
		List<Integer> oids = new ArrayList<Integer>();
		List<List<OrderDetail>> orderdetailslist = new ArrayList<List<OrderDetail>>();
		List<OrderForm> orderformls = service.getAllOrderFormByUid(uid);
		List<OrderDetail> orderdetails = null;
		List<Integer> gids = null;

		List<List<Order>> orderlists = new ArrayList<List<Order>>();
		List<OrderInfo> orderinfolist = new ArrayList<OrderInfo>();

		for (OrderForm o : orderformls) {
			if (o.getState().getStateid() == 3) {
				oids.add(o.getOid());
			}
		}
		for (Integer i : oids) {
			List<Order> orderlist = new ArrayList<Order>();
			;
			int counts = 0;
			orderdetails = service.getOrderDetailByOid(i);
			for (int a = 0; a < orderdetails.size(); a++) {

				Order order = new Order();
				int count = orderdetails.get(a).getCount();
				order.setCount(count);

				order.setGoods(orderdetails.get(a).getGoods());
				order.setOid(i);
				counts = count + counts;
				orderlist.add(order);
			}
			orderlists.add(orderlist);

			gids = service.getGidByOid(i);

			int sid = 0;
			for (Integer j : gids) {
				sid = service.getShopIdBygid(j);

			}

			int stateid = service.getSateIdByOid(i);
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOid(i);

			orderInfo.setSum(counts);
			orderInfo.setState(service.getStateBystateid(stateid));
			orderInfo.setTotal(service.getTotalByOid(i));
			orderInfo.setShop(shopService.getShopBySid(sid));
			;
			// orderInfo.setDate(service.getDateByOid(i));
			orderinfolist.add(orderInfo);
			orderdetailslist.add(orderdetails);
		}

		Map<String, String> orderinfo = new HashMap<String, String>();

		orderinfo.put("orderlist", new Gson().toJson(orderlists));
		orderinfo.put("orderinfolist", new Gson().toJson(orderinfolist));

		response.getWriter().print(new Gson().toJson(orderinfo));
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
