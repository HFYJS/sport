package sport.web.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.service.ShopService;
import sport.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		ShopService shopService = new ShopService();
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		int code = shopService.login(name, pwd);
		if (code == 1) {
			UserService userService = new UserService();
			int uid = userService.getUidByName(name);
			int sid = shopService.getSidByUid(uid);
			request.setAttribute("sid", sid);
			request.getRequestDispatcher("ToSportServlet")
					.forward(request, response);
		} else {
			request.setAttribute("code", code);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}

}
