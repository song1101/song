package chenglulu.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import chenglulu.dao.PublishDAO;
import chenglulu.model.Order;
import chenglulu.model.User;

/**
 * Servlet implementation class PublishController
 */
@WebServlet("/PublishController")
public class PublishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		Order order = new Order();
		order.setTitle(request.getParameter("title"));
		order.setPublisher(user.getAccount());
		order.setOrders_type(request.getParameter("type"));
		order.setStartTime(request.getParameter("start_time"));
		order.setEndTime(request.getParameter("end_time"));
		order.setCost(Float.parseFloat(request.getParameter("fee")));
		order.setReceiver(request.getParameter("receiver"));
		order.setReceivePhone(request.getParameter("receiver_phone"));
		order.setReceivePlace(request.getParameter("location"));
		order.setDescription(request.getParameter("descriptions"));
		request.getSession().setAttribute("order", order);
		PublishDAO.publish(order);
		RequestDispatcher dispatcher=request.getRequestDispatcher("release.jsp");
		dispatcher.forward(request, response);
		//JOptionPane.showMessageDialog(null, "发布订单成功！请等待管理员审核！", "发布成功", JOptionPane.NO_OPTION);
	}

}
