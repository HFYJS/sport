package sport.web.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Activity;
import sport.entity.Cate;
import sport.entity.Goods;
import sport.service.ActivityService;
import sport.service.CateService;
import sport.service.GoodsService;

/**
 * Servlet implementation class ModifyGoodsServlet
 */
@WebServlet("/ModifyGoodsServlet")
public class ModifyGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Goods goods = new Goods();
		goods.setGid(Integer.parseInt(request.getParameter("gid")));
		goods.setSid(Integer.parseInt(request.getParameter("sid")));
		ActivityService activityService = new ActivityService();
		Activity activity = new Activity();
		activity = activityService.getActivityByActid(Integer.parseInt(request
				.getParameter("actid")));
		goods.setActivity(activity);
		CateService cateService = new CateService();
		Cate cate = new Cate();
		cate = cateService.getCateByCatid(Integer.parseInt(request
				.getParameter("catid")));
		goods.setCate(cate);
		goods.setName(request.getParameter("name"));
		goods.setPrice(Double.parseDouble(request.getParameter("price")));
		goods.setActPrice(Double.parseDouble(request.getParameter("actprice")));
		goods.setSales(Integer.parseInt(request.getParameter("sales")));
		goods.setAmount(Integer.parseInt(request.getParameter("amount")));
		goods.setBrand(request.getParameter("brand"));
		goods.setPopularity(Integer.parseInt(request.getParameter("popularity")));
		goods.setImgPath(request.getParameter("imgpath"));
		goods.setDes(request.getParameter("des"));

		GoodsService goodsService = new GoodsService();
		goodsService.modify(goods);

		response.setHeader("refresh", "0;url=/sport/ToGoodsListServlet");
	}
}
