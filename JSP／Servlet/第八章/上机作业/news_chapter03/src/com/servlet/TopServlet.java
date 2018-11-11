package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.dao.TopicsDao;
import org.news.dao.impl.TopicsDaoImpl;
import org.news.entity.Topic;
import org.news.service.impl.NewsComments;
import org.news.service.impl.NewsServiceImpl;
import org.news.service.impl.TopServiceImpl;


public class TopServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TopServlet() {
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
		String yin = request.getParameter("yin");
		if(yin.equals("del")){
			  int tid=Integer.parseInt(request.getParameter("id"));
			  TopServiceImpl t=new TopServiceImpl();
			  int count=t.delPanDuan(tid);
			  if(count==1){
				  out.println("<script>"+
				  "alert('删除成功');"+
				  "location.href='util/do_topic_list.jsp';"+
				  "</script>");
				 
			  }else{
				  out.println("<script>"+
						  "alert('删除失败');"+
						  "location.href='util/do_topic_list.jsp';"+
						  "</script>");
			  }
		}else if(yin.equals("delnews")){
			String id=(String)request.getParameter("id");
			  NewsServiceImpl nn=new NewsServiceImpl();
			  String yuju=nn.delPanDuan(Integer.parseInt(id));
			  if(yuju.equals("删除成功")){
				  
				  out.println("<script>"+
						  "alert('删除成功');"+
						  "location.href='newspages/admin.jsp';"+
						  "</script>");
				  
			  }else if(yuju.equals("删除失败")){
				  out.println("<script>"+
						  "alert('删除失败');"+
						  "location.href='newspages/admin.jsp';"+
						  "</script>");
			  }
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
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String yin = request.getParameter("yin");
		if(yin.equals("xiutop")){//修改主题
			  int id=Integer.parseInt(request.getParameter("id"));
			  String tname=request.getParameter("tname");
			  Topic top=new Topic();
			  top.setTid(id);
			  top.setTname(tname);
			  TopServiceImpl t=new TopServiceImpl();
			  int count=t.updatePanDuan(top);
			  if(count==1){
				  out.println("<script>"
				  		+ "alert('修改成功');"+"location.href='util/do_topic_list.jsp';"+
						  "</script>");
				  //request.getRequestDispatcher("newspages/topic_list.jsp").forward(request, response);
			  }else{
				  out.println("<script>"
					  		+ "alert('修改失败');"+"location.href='util/do_topic_list';"+
							  "</script>");
			  }
		}else if(yin.equals("addtopic")){
			TopicsDao topicsDao=new TopicsDaoImpl();
			String tname = request.getParameter("tname");
			Topic topic=topicsDao.findTopicByName(tname);
				if(topic==null){
					topicsDao.addTopic(tname);
					out.println("<script type='text/javascript'>"
					+"alert('当前主题创建成功，点击确认返回主题列表！');"
					+"location.href='util/do_topic_list.jsp';"	
					+"</script>");
					
				}else{
					out.println("<script type='text/javascript'>"
							+"alert('当前主题已存在，请输入不同的主题！');"
							+"location.href='util/do_topic_list.jsp';"	
							+"</script>");
				}
		}else if(yin.equals("xiunews")){
			   int id=Integer.parseInt(request.getParameter("id"));
			   String xiala=request.getParameter("ntid");
			   String biaoti=request.getParameter("ntitle");
			   String zuozhe=request.getParameter("nauthor");
			   String zaiyao=request.getParameter("nsummary");
			   String neirong=request.getParameter("ncontent");
			   Object ob[]={xiala,biaoti,zuozhe,zaiyao,neirong};
			   NewsServiceImpl n=new NewsServiceImpl();
			   int count=n.upPanDuan(id, ob);
			   if(count==1){
				   out.println("<script>"
					  		+ "alert('修改成功');"+"location.href='newspages/admin.jsp';"+
							  "</script>");
				   
			   }else{
				   out.println("<script>"
					  		+ "alert('修改失败');"+"location.href='newspages/admin.jsp';"+
							  "</script>");
			   }
		}else if(yin.equals("addnews")){
			   String xiala=request.getParameter("ntid");
			   String biaoti=request.getParameter("ntitle");
			   String zuozhe=request.getParameter("nauthor");
			   String zaiyao=request.getParameter("nsummary");
			   String neirong=request.getParameter("ncontent");
			   Object ob[]={xiala,biaoti,zuozhe,zaiyao,neirong};
			   NewsServiceImpl n=new NewsServiceImpl();
			   int count=n.addPanDuan(ob);
			   if(count==1){
				   out.println("<script>"
					  		+ "alert('添加成功');"+"location.href='newspages/admin.jsp';"+
							  "</script>");
				   
			  }else{
				  out.println("<script>"
					  		+ "alert('添加失败');"+"location.href='newspages/admin.jsp';"+
							  "</script>");
			  }
		}else if(yin.equals("addping")){
			int parameter = Integer.parseInt(request.getParameter("nid"));
			String ccontent = request.getParameter("ccontent");
			String cip = request.getParameter("cip");
			String cauthor = request.getParameter("cauthor");
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String format = simpleDateFormat.format(date);
			NewsComments n=new NewsComments();
			Object[] ob={parameter,ccontent,format,cip,cauthor};
			int updateComments = n.updateComments(ob);
			if(updateComments==1){
				 out.println("<script>"
					  		+ "alert('添加评论成功');"+"location.href='newspages/admin.jsp';"+
							  "</script>");
			}else{
				 out.println("<script>"
					  		+ "alert('添加评论失败');"+"location.href='newspages/admin.jsp';"+
							  "</script>");
			}
		}
		
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
