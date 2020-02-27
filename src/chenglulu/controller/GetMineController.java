package chenglulu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chenglulu.dao.MineDAO;
import chenglulu.model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetMineController
 */
@WebServlet("/GetMineController")
public class GetMineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MineDAO mineDAO=new MineDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMineController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的方法
		String method = request.getParameter("method");
		User user=(User)request.getSession().getAttribute("user");
		String account=user.getAccount();
		if("getMyrelease".equalsIgnoreCase(method)){ 
			getMyrelease(response,account);
		} else if("getMyOrders".equalsIgnoreCase(method)){ 
			getMyOrders(response,account);
		} else if("getMyAppeal".equalsIgnoreCase(method)){
			getMyAppeal(response,account);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void getMyrelease(HttpServletResponse response,String account) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",1000);
        
        JSONArray result=null;
        result = JSONArray.fromObject(mineDAO.getMyrelease(account));
        jsonObject.put("data",result);
        System.out.println(jsonObject.toString());
        out.println(jsonObject.toString());
        out.flush();
        out.close();
	}
	
	public void getMyOrders(HttpServletResponse response,String account) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",1000);
        
        JSONArray result=null;
        result = JSONArray.fromObject(mineDAO.getMyOrders(account));
        jsonObject.put("data",result);
        System.out.println(jsonObject.toString());
        out.println(jsonObject.toString());
        out.flush();
        out.close();
	}
	
	public void getMyAppeal(HttpServletResponse response,String account) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",1000);
        
        JSONArray result=null;
        result = JSONArray.fromObject(mineDAO.getMyAppeal(account));
        jsonObject.put("data",result);
        System.out.println(jsonObject.toString());
        out.println(jsonObject.toString());
        out.flush();
        out.close();
	}
}
