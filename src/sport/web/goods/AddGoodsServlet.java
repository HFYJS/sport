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
 * Servlet implementation class GoodsAddServlet
 */
@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
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
		GoodsService goodsService = new GoodsService();
		Goods goods = new Goods();

		int sid = Integer.parseInt(request.getParameter("sid"));// 获取商品所属商家ID
		String name = request.getParameter("name");// 获取商品名
		// 获取商品分类
		Cate cate = new Cate();
		CateService cateService = new CateService();
		int catId = Integer.parseInt(request.getParameter("catid"));
		String catName = cateService.getNameByCateid(catId);
		cate.setCatid(catId);
		cate.setName(catName);
		String brand = request.getParameter("brand");// 获取商品品牌
		Double price = Double.parseDouble(request.getParameter("price"));// 获取商品价格
		int amount = Integer.parseInt(request.getParameter("amount"));// 获取商品总数
		int sales = Integer.parseInt(request.getParameter("sales"));// 获取商品销量
		int popularity = Integer.parseInt(request.getParameter("popularity"));// 获取商品人气
		String des = request.getParameter("des");// 获取商品描述
		String imgPath = request.getParameter("imgpath");// 获取商品图片路径
		// 获取商品活动
		Activity activity = new Activity();
		ActivityService activityService = new ActivityService();
		int actId = Integer.parseInt(request.getParameter("actid"));
		String actName = activityService.getNameByActid(actId);
		activity.setActid(actId);
		activity.setName(actName);
		Double actPrice = Double.parseDouble(request.getParameter("actprice"));// 获取商品活动价格

		// 为新商品赋值
		goods.setSid(sid);
		goods.setName(name);
		goods.setCate(cate);
		goods.setBrand(brand);
		goods.setPrice(price);
		goods.setAmount(amount);
		goods.setSales(sales);
		goods.setPopularity(popularity);
		goods.setDes(des);
		goods.setImgPath(imgPath);
		goods.setActivity(activity);
		goods.setActprice(actPrice);

		// 添加新商品到数据库
		goodsService.add(goods);
		response.setHeader("refresh", "3;url=/sport/ToGoodsListServlet");
	}
}
