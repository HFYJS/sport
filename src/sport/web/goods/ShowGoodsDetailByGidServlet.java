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

import com.google.gson.Gson;

import sport.entity.Comment;
import sport.entity.Goods;
import sport.entity.User;
import sport.service.CommentService;
import sport.service.GoodsService;
import sport.service.ShopService;
import sport.service.UserService;

/**
 * Servlet implementation class ShowGoodsDetailServlet
 */
@WebServlet("/ShowGoodsDetailServlet")
public class ShowGoodsDetailByGidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, String> goodsDetail = new HashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowGoodsDetailByGidServlet() {
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

		// 获取传过来的gid，由gid获取商品的信息
		int gid = Integer.parseInt(request.getParameter("gid"));
		GoodsService goodsService = new GoodsService();
		Goods goods = goodsService.getGoodsByGid(gid);
		int sid = goods.getSid();
		String gName = goods.getName();
		String gPic = goods.getImgPath();
		// 判断是否有活动价
		double gPrice = (goods.getActPrice() == 0) ? goods.getPrice() : goods
				.getActPrice();
		int gSales = goods.getSales();
		//
		goodsDetail.put("gName", gName);
		goodsDetail.put("gPrice", String.valueOf(gPrice));
		goodsDetail.put("gPic", gPic);
		goodsDetail.put("gSales", String.valueOf(gSales));

		// 根据商品号查询所有包含此商品的评价
		CommentService commnetService = new CommentService();
		List<Comment> listComment = commnetService.getCommentByGid(gid);
		String count = String.valueOf(listComment.size());
		// 根据商家id查询到商家
		ShopService shopService = new ShopService();
		String sAddress = shopService.getShopBySid(sid).getAddress();
		// 根据评价单查询到用户(查询此订单)，遍历集合
		UserService userServlet = new UserService();
		Comment comment = listComment.get(listComment.size() - 1);

		int uid = comment.getUid();
		String content = comment.getContent();
		String date = comment.getDate();
		User user = userServlet.getUserByUid(uid);
		String userName = user.getName();
		String userPic = user.getHeadPath();

		goodsDetail.put("userName", userName);
		goodsDetail.put("userPic", userPic);
		goodsDetail.put("content", content);
		goodsDetail.put("date", date);
		goodsDetail.put("sAddress", sAddress);
		goodsDetail.put("count", count);

		// 将goodsDetail转换成json
		response.getWriter().print(new Gson().toJson(goodsDetail));

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
