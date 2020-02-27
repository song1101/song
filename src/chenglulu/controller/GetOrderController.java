package chenglulu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chenglulu.dao.OrderDAO;
import chenglulu.model.User;

/**
 * Servlet implementation class GetOrderController
 */
@WebServlet("/GetOrderController")
public class GetOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderID=Integer.parseInt(request.getParameter("order"));
		OrderDAO orderDAO=new OrderDAO();
		User user=(User)request.getSession().getAttribute("user");
		String account=user.getAccount();
		orderDAO.getOrder(account,orderID);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
