package org.news.dao;

import java.util.List;

import org.news.entity.News;

public interface NewsDao{
	//获取所有新闻
	public List<News> getAllnews();	
	//获取某主题下的所有新闻
	public List<News> getAllnewsByTID(int Tid);	
	//获取某主题下的新闻数量
	public int getNewsCountByTID(int Tid);
	//删除新闻
	public int delNewId(int id);
	//修改新闻
	//修改
	public int updateNews(int id,Object []ob);
	//添加新闻
	public int addNews(Object []ob);
	//获取所有新闻的数量
	public int newsCount();
	//分页获取新闻
	public List<News> fenNews(int dangpage,int pagesize);
	
}