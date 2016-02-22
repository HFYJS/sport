package sport.web.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.service.GoodsService;

/**
 * Servlet implementation class RemoveGoodsServlet
 */
@WebServlet("/RemoveGoodsServlet")
public class RemoveGoodsServlet extends HttpServlet {
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
		String gid = request.getParameter("gid");
		String[] gidsStr = gid.split("\\*");
		int length = gidsStr.length;
		int[] gids = new int[length];
		for (int i = 0; i < length; i++) {
			gids[i] = Integer.parseInt(gidsStr[i]);
		}
		
		GoodsService goodsService = new GoodsService();
		goodsService.remove(gids);
		
		response.setHeader("refresh", "0;url=/sport/ToGoodsListServlet");
	}

}
