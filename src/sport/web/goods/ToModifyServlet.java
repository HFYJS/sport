package sport.web.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Activity;
import sport.entity.Cate;
import sport.service.ActivityService;
import sport.service.CateService;

/**
 * Servlet implementation class ToModifyServlet
 */
@WebServlet("/ToModifyServlet")
public class ToModifyServlet extends HttpServlet {
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
		CateService cateService = new CateService();
		ActivityService activityService = new ActivityService();
		List<Cate> cates = cateService.search();
		List<Activity> activities = activityService.search();
		request.setAttribute("cates", cates);
		request.setAttribute("activities", activities);
		request.getRequestDispatcher("goods/goods_modify.jsp").forward(request,
				response);
	}

}
