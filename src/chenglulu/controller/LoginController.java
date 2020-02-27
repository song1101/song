package chenglulu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import chenglulu.dao.UserDAO;
import chenglulu.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    String account =request.getParameter("account");
		String password =request.getParameter("password");
		String quest=request.getParameter("quest");
		User user=new User();
		user.setAccount(account);
		user.setPassword(password);
		if(quest!=null&&quest.equals("1")){ 
			if(checkUser(user)) {
				request.getSession().setAttribute("user",user);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request,response);
			}else {
				JOptionPane.showMessageDialog(null, "账号或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
				response.sendRedirect("login.jsp");
			}
		}
		else{
			if(account.equals("admin")&&password.equals("123456")){
				request.getSession().setAttribute("user",user);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/111.jsp");
				dispatcher.forward(request,response);
			}else{
				JOptionPane.showMessageDialog(null, "账号或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
				response.sendRedirect("login.jsp");  
			}
		}
	}
	boolean checkUser(User user) {
		UserDAO ud=new UserDAO();
		if(ud.searchUser(user)) {
			return true;
		}else {
			return false;
		}
	}
}
