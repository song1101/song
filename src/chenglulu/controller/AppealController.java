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

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import com.mysql.fabric.Response;

import chenglulu.dao.AppealDAO;
import chenglulu.model.Appeal;
import chenglulu.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AppealController
 */
@WebServlet("/AppealController")
public class AppealController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppealController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		System.out.println(method);
		if(method.equals("setAppealID")) { 
			int appealID=Integer.parseInt(request.getParameter("appealID"));
			System.out.println(appealID);
			setAppealID(appealID,response); 
		}else if(method.equals("dispatcherRelease")) {
			int orderID=Integer.parseInt(request.getParameter("orderID"));
			System.out.println(orderID);
			String orders=request.getParameter("orders");
			System.out.println(orders);
			if(orders==null&&orders.equals("")) {
				JOptionPane.showMessageDialog(null, "您的订单尚未完成！", "投诉失败", JOptionPane.NO_OPTION);
				return;
			}
			request.getSession().setAttribute("orderID", orderID);
			request.getSession().setAttribute("becomplainant", orders);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/appeal.jsp");
			System.out.println("aaaaaaaa");
			dispatcher.forward(request,response);
			System.out.println("vvvvvvvvv");
		}else if(method.equals("dispatcherOrder")) {
			/*
			 * int orderID=Integer.parseInt(request.getParameter("orderID")); String
			 * publisher=request.getParameter("publisher");
			 * request.getSession().setAttribute("orderID", orderID);
			 * request.getSession().setAttribute("becomplainant", publisher);
			 */
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("appeal.jsp");
			dispatcher.forward(request,response);	
		}else if (method.equals("setAppeal")) {
			setAppeal(request);
		}else if(method.equals("cancelAppeal")) {
			int appealID=Integer.parseInt(request.getParameter("appealID"));
			cancelAppeal(appealID);
		}else if (method.equals("findAppeal")){		 
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
	        JSONObject jsonObject=new JSONObject();
	        jsonObject.put("code",0);
	        jsonObject.put("msg","");
	        jsonObject.put("count",1000);
			
			JSONArray result=null;
	        AppealDAO appealDAO=new AppealDAO();
			result = JSONArray.fromObject(appealDAO.findAppeals());
	        jsonObject.put("data",result);
	        System.out.println(jsonObject.toString());
	        out.println(jsonObject.toString());
	        out.flush();
	        out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void setAppealID(int appealID,HttpServletResponse response) throws IOException {
		AppealDAO appealDAO=new AppealDAO();
		appealDAO.setAppealID(appealID);
		System.out.println("aaaaaaaaaaaaaaaaa");
		response.getWriter().print("<script>alert('登录成功!');</script>");
		JOptionPane.showMessageDialog(null, "纠纷处理成功！", "处理成功", JOptionPane.NO_OPTION);
	}
	public void setAppeal(HttpServletRequest request) {
		int orderID=(int) request.getSession().getAttribute("orderID");
		String reason=request.getParameter("reason");
		String descriptions=request.getParameter("descriptions");
		User user=(User)request.getSession().getAttribute("user");
		String complainant=user.getAccount();
		String becomplainant=(String) request.getSession().getAttribute("becomplainant");
		Appeal appeal=new Appeal();
		appeal.setOrderID(orderID);
		appeal.setReason(reason);
		appeal.setDescriptions(descriptions);
		appeal.setComplainant(complainant);
		appeal.setBecomplainant(becomplainant);
		appeal.setIshandled(0);
		AppealDAO appealDAO=new AppealDAO();
		appealDAO.setAppeal(appeal);
		request.getSession().setAttribute("orderID", "");
		request.getSession().setAttribute("becomplainant", "");
		JOptionPane.showMessageDialog(null, "申诉提交成功！", "提交成功", JOptionPane.NO_OPTION);
	}
	public void cancelAppeal(int appealID) {
		AppealDAO appealDAO=new AppealDAO();
		appealDAO.cancelAppeal(appealID);
		JOptionPane.showMessageDialog(null, "申诉已成功取消！", "取消成功", JOptionPane.NO_OPTION);
	}
}
