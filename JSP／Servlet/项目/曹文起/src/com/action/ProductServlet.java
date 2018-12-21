package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.IOUtils;
import com.daoimp.OrderDaoImp;
import com.daoimp.ProductDaoImp;
import com.daoimp.UserDaoImp;
import com.entity.Product;
import com.util.MemcachedUtil;

public class ProductServlet extends HttpServlet {

	private static final String Float = null;

	/**
	 * Constructor of the object.
	 */
	public ProductServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String pro = request.getParameter("pro");
		if(pro.equals("zssp")){
			ProductDaoImp p=new ProductDaoImp();
			int id = Integer.parseInt(request.getParameter("sjid")); 
			List<Product> product = p.sjid_select(id);
			String jsonString = JSON.toJSONString(product);
			out.print(jsonString);
		}else if(pro.equals("cxwpxx")){
			int id = Integer.parseInt(request.getParameter("id"));
			ProductDaoImp pp=new ProductDaoImp();
			Product product = pp.id_select_shangpin(id);
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("name");
			if(name==null){
				name="no";
			}
			List<Product> list=(List<Product>)MemcachedUtil.get(name);
			if(list==null){
				list=new ArrayList<Product>();
			}
			list.add(product);
			//MemcachedUtil.del(name);
			MemcachedUtil.add(name, list); 
		    //list=(List<Product>)MemcachedUtil.get("name");
			session.setAttribute("listgouwuche", list);
			String jsonString = JSON.toJSONString(product);
			out.print(jsonString);
		}else if(pro.equals("cshgwc")){
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("name");
			List<Product> list=(List<Product>)MemcachedUtil.get(name);
			if(list==null){
				list=new ArrayList<Product>();
				Product e=new Product();
				e.setId(999999999);
				list.add(e);
			}
			session.setAttribute("listgouwuche", list);
			response.sendRedirect("../Index.jsp");
		}else if(pro.equals("sanchu")){
			int id =Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("name");
			List<Product> list=(List<Product>)MemcachedUtil.get(name);
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getId()==id){
					list.remove(i);
				}
			}
			if(list.size()==0){
				Product p=new Product();
				p.setId(999999999);
				p.setName("ceshi");
				list.add(p);
			}
			//MemcachedUtil.del(name);
			MemcachedUtil.add(name, list);
			session.setAttribute("listgouwuche", list);
			//String jsonString = JSON.toJSONString(list);
			//out.print(jsonString);
			out.print("true");
		}else if(pro.equals("gouwu2")){
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("name");
			List<Product> list=(List<Product>)MemcachedUtil.get(name);
			String jsonString = JSON.toJSONString(list);
			out.print(jsonString);
		}else if(pro.equals("gouwu3")){
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("name");
			String zje =request.getParameter("zje");
			Float f=new Float(zje);
		    String dizi = request.getParameter("dizi");
		    UserDaoImp ui=new UserDaoImp();
			String id =String.valueOf(ui.login_Select_userid(name));
			Date d=new Date();
			SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
			String sj = date.format(d);
			OrderDaoImp oi=new OrderDaoImp();
			Random ran=new Random();
			int nextInt = ran.nextInt(100000000);
			String serilNumber=String.valueOf(nextInt);
			oi.cr_Order(id, name, dizi, sj, f, 1, 1, serilNumber);
			System.out.println(sj);
			System.out.println(id);
			System.out.println(name);
			System.out.println(f);
			System.out.println(dizi);
			out.print(serilNumber);
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
