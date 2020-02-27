package chenglulu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import chenglulu.dao.UserDAO;
import chenglulu.model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String phone=request.getParameter("phone");
		User user=new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setNickname(nickname);
		user.setPhone(phone);
		UserDAO.insert(user);
		JOptionPane.showMessageDialog(null, "注册成功，请返回登录页面重新登录！", "注册成功", JOptionPane.ERROR_MESSAGE);
		response.sendRedirect("login.jsp");
	}
}
