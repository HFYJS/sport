package sport.web.goods;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import sport.entity.OrderDetail;
import sport.entity.OrderForm;
import sport.entity.temp.Order;
import sport.entity.temp.OrderInfo;
import sport.service.OrderService;

/**
 * Servlet implementation class CreateOrderServlet
 */
@WebServlet("/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderJson = request.getParameter("order");
		String orderInfoJson = request.getParameter("orderinfo");
		OrderService service = new OrderService();
		List<OrderInfo> orderInfolist = new Gson().fromJson(orderInfoJson, new TypeToken<List<OrderInfo>>() {
		}.getType());
		List<List<Order>> orderlists = new Gson().fromJson(orderJson, new TypeToken<List<List<Order>>>() {
		}.getType());
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		List<OrderForm> orderForms = new ArrayList<OrderForm>();
		OrderForm orderForm;
		OrderDetail orderDetail;
		for (OrderInfo o : orderInfolist) {
			orderForm = new OrderForm();
			orderForm.setAddress(o.getAddress());
			// orderForm.setDate(orderInfo.getDate());
			orderForm.setState(o.getState());
			orderForm.setNote(o.getNote());
			orderForm.setTotal(o.getTotal());
			orderForms.add(orderForm);
			orderDetails.clear();
			for (List<Order> l : orderlists) {

				if (l.size() != 0) {
					
					if (o.getShop().getSid() == l.get(0).getGoods().getSid()) {
						for (Order or : l) {
							orderDetail = new OrderDetail();
							orderDetail.setOrderForm(orderForm);
							orderDetail.setGoods(or.getGoods());
							orderDetail.setCount(or.getCount());
							orderDetail.setSum(or.getAllprice());
							orderDetails.add(orderDetail);
						}

					}

				}

			}
			System.out.println(orderDetails.size());
			service.createOrderForm(orderForm, orderDetails);

		}
	}
}
