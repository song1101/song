package chenglulu.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ChangeInfoController
 */
@WebServlet("/ChangeInfoController")
public class ChangeInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String newphone =request.getParameter("newphone");
		String newpwd =request.getParameter("newpwd");
		User user=(User)request.getSession().getAttribute("user");
		String account=user.getAccount();
		UserDAO userDAO=new UserDAO();
		userDAO.update(account, newphone, newpwd);
		response.getWriter().print("<script>alert('修改成功!');</script>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/changeinformation.jsp");
		dispatcher.forward(request,response);
	}

}
