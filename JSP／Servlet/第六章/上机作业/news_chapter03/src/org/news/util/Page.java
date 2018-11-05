package org.news.util;

import java.util.List;

import org.news.entity.News;

public class Page {

	//总条数
	private int tiaoCount=0;
	//每页的条数
	private int pageTiao=6;
	//总页数
	private int pageCount;
	//当前页面
	private int pageNumber=1;
	//当前页集合
	private List<News> newsList;
	public int getTiaoCount() {
		return tiaoCount;
	}
	public void setTiaoCount(int tiaoCount) {
		if(tiaoCount>0){
		this.tiaoCount=tiaoCount;
		this.pageCount=this.tiaoCount%pageTiao==0?(this.tiaoCount/pageTiao):(this.tiaoCount/pageTiao+1);
				}
		this.tiaoCount = tiaoCount;
	}
	public int getPageTiao() {
		return pageTiao;
	}
	public void setPageTiao(int pageTiao) {
		this.pageTiao = pageTiao;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		
		this.pageCount = pageCount;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
}
