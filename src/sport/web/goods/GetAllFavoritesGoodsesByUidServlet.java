package sport.web.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Goods;
import sport.service.GoodsFavoritesService;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetAllGoodsesByGidServlet
 */
@WebServlet("/GetAllGoodsesByUidServlet")
public class GetAllFavoritesGoodsesByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllFavoritesGoodsesByUidServlet() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		GoodsFavoritesService goodsFavoritesService = new GoodsFavoritesService();
		List<Goods> goodses = goodsFavoritesService.getAllGoodsesByUid(uid);
		PrintWriter out = response.getWriter();

		out.print(new Gson().toJson(goodses));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
