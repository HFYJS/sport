package sport.web.goods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.Hobby;
import sport.entity.User;
import sport.service.UserHobbyService;
import sport.service.UserService;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetUserInfoByUidServlet
 */
@WebServlet("/GetUserInfoByUidServlet")
public class GetUserInfoByUidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserInfoByUidServlet() {
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
		UserService userService = new UserService();
		User user = userService.getUserByUid(uid);
		List<String> list = new ArrayList<String>();
		list.add(new Gson().toJson(user));

		UserHobbyService userHobbyService = new UserHobbyService();
		List<Hobby> hobbies = userHobbyService.getAllHobbiesByUid(uid);
		list.add(new Gson().toJson(hobbies));

		response.getWriter().print(new Gson().toJson(list));
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
