package org.news.service.impl;

import org.news.dao.BaseDao;
import org.news.dao.impl.NewsDaoImpl;
import org.news.dao.impl.TopicsDaoImpl;
import org.news.entity.Topic;
import org.news.service.TopService;

public class TopServiceImpl extends BaseDao implements TopService{

	@Override
	public int delPanDuan(int id) {
		TopicsDaoImpl t=new TopicsDaoImpl();
		NewsDaoImpl n=new NewsDaoImpl();
		int newsCountByTID = n.getNewsCountByTID(id);
		if(newsCountByTID>=1){
			return 0;
		}
		int deleteTopic = t.deleteTopic(id);
		return deleteTopic;
	}

	@Override
	public int updatePanDuan(Topic top) {
		TopicsDaoImpl t=new TopicsDaoImpl();
		Topic xxx = t.findTopicByName(top.getTname());
		if(xxx!=null){
			return 0;
		}
		int updateTopic = t.updateTopic(top);
		return updateTopic;
	}

	

}
