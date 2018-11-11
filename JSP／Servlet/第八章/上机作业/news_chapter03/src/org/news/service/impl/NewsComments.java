package org.news.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.news.dao.BaseDao;

public class NewsComments extends BaseDao{

	public int updateComments(Object[]ob){
		Connection co = super.getConnection();
		String sql="insert into comments(cnid,ccontent,cdate,cip,cauthor) values(?,?,?,?,?)";
		PreparedStatement pr=null;
		int num=0;
		try {
			 pr= co.prepareStatement(sql);
			 for(int i=0;i<ob.length;i++){
				 pr.setObject(i+1, ob[i]);
			 }
			  num = pr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.closeAll(co, pr, null);
		return num;
		
	}
	
}
