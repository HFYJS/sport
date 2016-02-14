package sport.web.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Goods;
import sport.service.GoodsService;

/**
 * Servlet implementation class ToGoodsListServlet
 */
@WebServlet("/ToGoodsListServlet")
public class ToGoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsService goodsService = new GoodsService();
		List<Goods> goodses = goodsService.getAll();
		request.setAttribute("goodses", goodses);
		request.getRequestDispatcher("goods/goods_list.jsp").forward(
				request, response);
	}
}
