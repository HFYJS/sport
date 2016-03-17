package sport.web.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sport.entity.User;
import sport.service.UserService;
/*
 * 修改内容：
 * 1.db.properties密码
 * 2.userservice中重写userlogin
 */
/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userservice = new UserService();
		String name =request.getParameter("name");
		String pwd =request.getParameter("pwd");
		User user = userservice.userlogin(name, pwd);
		if(user!=null){
			PrintWriter out = response.getWriter();
			out.print(new Gson().toJson(user));
			out.flush();
			out.close();
		}else{
			System.out.println("null");
		}
	}

}
