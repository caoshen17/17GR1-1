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
	public int update(int id);
}