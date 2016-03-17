package sport.web.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sport.entity.OrderDetail;
import sport.service.OrderService;

/**
 * Servlet implementation class GetAllOrderInfo
 */
@WebServlet("/GetOrderDetailsServlet")
public class GetOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderService();
		int uid = Integer.parseInt(request.getParameter("uid"));
		List<Integer> oids = service.getOidByUid(uid);
		List<OrderDetail> orderdetails = null;
		for(Integer i:oids){
			orderdetails = service.getOrderDetailByOid(i);
			response.getWriter().print(new Gson().toJson(orderdetails));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
