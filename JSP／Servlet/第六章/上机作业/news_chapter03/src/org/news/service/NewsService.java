package org.news.service;

import org.news.util.Page;

public interface NewsService {

	//ɾ��ɹ��ж�
	public String delPanDuan(int id);

	//�޸��ж�
	public int upPanDuan(int id,Object []ob);
	
	//����ж�
	public int addPanDuan(Object []ob);
	//新闻分页
	public void fenYe(Page page);
}
