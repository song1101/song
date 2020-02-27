package chenglulu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import chenglulu.dao.OrderDAO;
import chenglulu.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		System.out.println(method);
		if(method.equals("adminOrder"))
			adminFindOrders(response);
		else if(method.equals("setIsCheck")) {
			int orderID=Integer.parseInt(request.getParameter("orderID"));
			System.out.println(orderID);
			setIsCheck(orderID);
		}else if(method.equals("setIsGet")) {
			int orderID=Integer.parseInt(request.getParameter("orderID"));
			User user=(User) request.getSession().getAttribute("user");
			String account=user.getAccount();
			System.out.println("orderID:"+orderID);
			System.out.println("account:"+account);
			setIsGet(orderID,account);
			
		}else if(method.equals("findOrders")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
	        JSONObject jsonObject=new JSONObject();
	        jsonObject.put("code",0);
	        jsonObject.put("msg","");
	        jsonObject.put("count",1000);
			
			JSONArray result=null;
	        OrderDAO orderdao=new OrderDAO();
			result = JSONArray.fromObject(orderdao.findOrders());
	        jsonObject.put("data",result);
	        System.out.println(jsonObject.toString());
	        out.println(jsonObject.toString());
	        out.flush();
	        out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void adminFindOrders(HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",1000);
		
		JSONArray result=null;
        OrderDAO orderdao=new OrderDAO();
		result = JSONArray.fromObject(orderdao.adminFindOrders());
        jsonObject.put("data",result);
        System.out.println(jsonObject.toString());
        out.println(jsonObject.toString());
        out.flush();
        out.close();
	}
	public void setIsCheck(int orderID) throws IOException {
		OrderDAO orderDAO=new OrderDAO();
		orderDAO.setIsCheck(orderID);
		JOptionPane.showMessageDialog(null, "订单审核通过！", "审核通过", JOptionPane.NO_OPTION);
	}
	public void setIsGet(int orderID,String account) {
		OrderDAO orderDAO=new OrderDAO();
		orderDAO.setIsGet(orderID,account);
		JOptionPane.showMessageDialog(null, "接单成功！", "接单成功", JOptionPane.NO_OPTION);
	}
}
