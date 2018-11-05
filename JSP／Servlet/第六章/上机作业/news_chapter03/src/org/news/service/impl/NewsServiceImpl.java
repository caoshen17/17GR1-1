package org.news.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.news.dao.BaseDao;
import org.news.dao.impl.NewsDaoImpl;
import org.news.entity.News;
import org.news.service.NewsService;
import org.news.util.Page;

public class NewsServiceImpl extends BaseDao implements NewsService{

	@Override
	public String delPanDuan(int id) {
		NewsDaoImpl n=new NewsDaoImpl();
		int delNewId = n.delNewId(id);
		String yu="";
		if(delNewId==1){
			yu="É¾³ı³É¹¦";
			return yu;
		}else{
			yu="É¾³ıÊ§°Ü";	
		}
		return yu;
		
	}

	@Override
	public int upPanDuan(int id,Object []ob) {
		NewsDaoImpl n=new NewsDaoImpl();
		int count = n.updateNews(id, ob);
		return count;
	}

	@Override
	public int addPanDuan(Object[] ob) {
		NewsDaoImpl n=new NewsDaoImpl();
		int addNews = n.addNews(ob);
		return addNews;
	}

	@Override
	public void fenYe(Page page) {
		NewsDaoImpl n=new NewsDaoImpl();
		int newsCount = n.newsCount();
		page.setTiaoCount(newsCount);
		if(newsCount>0){
			if(page.getPageNumber()>page.getPageCount()){
				page.setPageNumber(page.getPageCount());
			}
			List<News> fenNews = n.fenNews(page.getPageNumber(),page.getPageTiao());
			page.setNewsList(fenNews);
		}else{
			page.setPageNumber(0);
			page.setNewsList(new ArrayList<News>());
		}
		
	}

	

	
}
