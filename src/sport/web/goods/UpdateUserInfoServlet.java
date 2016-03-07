package sport.web.goods;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sport.entity.User;
import sport.service.UserHobbyService;
import sport.service.UserService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class ModifyUserInfoByUidServlet
 */
@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserInfoServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userJson = request.getParameter("user");
		String hobbiesJson = request.getParameter("hobbies");

		User user = new Gson().fromJson(userJson, User.class);
		List<String> hobbies = new Gson().fromJson(hobbiesJson,
				new TypeToken<List<String>>() {
				}.getType());

		UserService userService = new UserService();
		UserHobbyService userHobbyService = new UserHobbyService();

		if (userService.updateUserInfo(user)
				&& userHobbyService.updateHobbiesByUid(user.getUid(), hobbies)) {
			response.getWriter().print("true");
		} else {
			response.getWriter().print("false");
		}
	}
}
