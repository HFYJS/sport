package sport.web.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import com.google.gson.Gson;

import sport.entity.Goods;
import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.Shop;
import sport.entity.temp.Order;
import sport.entity.temp.OrderInfo;
import sport.service.OrderService;
import sport.service.ShopService;

/**
 * Servlet implementation class GetAllOrdersServlet
 */
@WebServlet("/GetAllOrdersByUidServlet")
public class GetAllOrdersByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderService();
		ShopService shopService = new ShopService();

		//获取orderform
		int uid = Integer.parseInt(request.getParameter("uid"));
		//获取orderdetails
		List<Integer> oids = service.getOidByUid(uid);
		List<List<OrderDetail>> orderdetailslist = new ArrayList<List<OrderDetail>>();
		List<OrderDetail> orderdetails = null;	
		List<Integer> gids = null;
		List<List<Order>> orderlists = new ArrayList<List<Order>>();
		List<OrderInfo> orderinfolist = new ArrayList<OrderInfo>();
		
		System.out.println(oids);
		for(Integer i:oids){
			List<Order> orderlist = new ArrayList<Order>();;
			int counts = 0;
			orderdetails = service.getOrderDetailByOid(i);
			for(int a=0;a<orderdetails.size();a++){
				
				Order order = new Order();				
				int count = orderdetails.get(a).getCount();
				order.setCount(count);
				order.setGoods(orderdetails.get(a).getGoods());
				order.setOid(i);
				counts = count+counts;
				orderlist.add(order);	
			}
			orderlists.add(orderlist);
			gids = service.getGidByOid(i);
			OrderInfo orderInfo = new OrderInfo();
			int stateid = service.getSateIdByOid(i);
			if(gids.size()!=0){
				Shop shop = shopService.getShopBySid(service.getShopIdBygid(gids.get(0)));;
				orderInfo.setShop(shop);
				orderInfo.setOid(i);			
				
				orderInfo.setSum(counts);
				orderInfo.setState(service.getStateBystateid(stateid));
				orderInfo.setTotal(service.getTotalByOid(i));
//				orderInfo.setDate(service.getDateByOid(i));
				orderinfolist.add(orderInfo);
				orderdetailslist.add(orderdetails);		
			}	
			
		}

		
		Map<String,String> orderinfo = new HashMap<String, String>();

		orderinfo.put("orderlist", new Gson().toJson(orderlists));
		orderinfo.put("orderinfolist", new Gson().toJson(orderinfolist));
		
		response.getWriter().print(new Gson().toJson(orderinfo));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
