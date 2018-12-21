package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.daoimp.OrderDaoImp;
import com.daoimp.ProductDaoImp;
import com.entity.Order_detail;
import com.entity.Product;
import com.entity.Product_order;
import com.entity.Product_order_util;

public class AdminUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdminUserServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String pro = request.getParameter("pro");
		if(pro.equals("wodedingdan")){
			HttpSession session = request.getSession();
			String name =(String)session.getAttribute("name");
			OrderDaoImp odi=new OrderDaoImp();
			//根据name查询地址、金额、订单号
			Product_order_util p = odi.name_Select_Order(name);
			p.setName(name);
			//属于该订单号的商品交易记录
			List<Order_detail> dingdan_Select_Xiangqing = odi.dingdan_Select_Xiangqing(p.getDingdanhao());
			ProductDaoImp productdi=new ProductDaoImp();
			//商品信息name and filename
			List<Product> listproduct=new ArrayList();
			//存放商品数量和金额
			List<Product_order> lpo=new ArrayList();
			for(Order_detail o:dingdan_Select_Xiangqing){
				Product id_select_shangpin = productdi.id_select_shangpin(o.getProductId());
				Product_order po=new Product_order();
				po.setNum(o.getQuantity());
				po.setMoney(String.valueOf(o.getCost()));
				lpo.add(po);
				listproduct.add(id_select_shangpin);
			}
			
			int i=0;
			for(Product product:listproduct){
				Product_order product_order = lpo.get(i);
				product_order.setName(product.getName());
				product_order.setFileName(product.getFileName());
				i++;
			}
			p.setList(lpo);
			System.out.println(p.getName());
			System.out.println(p.getDingdanhao());
			System.out.println(p.getDizi());
			System.out.println(p.getMoney());
			for(Product_order fff:lpo){
				System.out.println(fff.toString());
			}
			String jsonString = JSON.toJSONString(p);
			out.print(jsonString);

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
