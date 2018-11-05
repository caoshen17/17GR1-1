package org.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.news.dao.BaseDao;
import org.news.dao.NewsDao;
import org.news.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {
    // 获取所有新闻
    public List<News> getAllnews() {
        List<News> list = new ArrayList<News>();
        ResultSet rs = null;
        String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
                + " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
                + " WHERE `NEWS`.`ntid` = `TOPIC`.`tid`"
                + " ORDER BY `ncreateDate` DESC";
        try {
            rs = this.executeQuery(sql);
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getDate("ncreateDate"));
                news.setNsummary(rs.getString("nsummary"));
                news.setNtname(rs.getString("tname"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return list;
    }

    // 获取某主题下的所有新闻
    public List<News> getAllnewsByTID(int tid) {
        List<News> list = new ArrayList<News>();
        ResultSet rs = null;
        String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
                + " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
                + " WHERE `NEWS`.`ntid` = `TOPIC`.`tid` AND `NEWS`.`ntid` = ?"
                + " ORDER BY `ncreateDate` DESC";
        try {
            rs = this.executeQuery(sql, tid);
            News news = null;
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getDate("ncreateDate"));
                news.setNsummary(rs.getString("nsummary"));
                news.setNtname(rs.getString("tname"));
                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return list;
    }

    public int getNewsCountByTID(int tid) {
        ResultSet rs = null;
        String sql = "SELECT COUNT(`ntid`) FROM `news` WHERE `ntid` = ?";
        int count = -1;
        try {
            rs = this.executeQuery(sql, tid);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, null, rs);
        }
        return count;
    }
    @Override
	public int delNewId(int nid) {
		Connection co = super.getConnection();
		int count = 0;
		Statement st=null;
		try {
			 st= co.createStatement();
			String sql="delete from news where nid="+nid+"";
			 count= st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeAll(co, st, null);
		return count;
	}

    @Override
	public int updateNews(int id,Object ob[]) {
		PreparedStatement pr=null;
	    ResultSet rs = null;
	    News news = null;
		Connection co = super.getConnection();
		String sql="select nid,ntid,ntitle,nauthor,nsummary,ncontent from news where nid=?";
		try {
			pr = co.prepareStatement(sql);
			pr.setObject(1, id);
			rs = pr.executeQuery();
			
	            while (rs.next()) {
	                news = new News();
	                news.setNid(rs.getInt("nid"));
	                news.setNtid(rs.getInt("ntid"));
	                news.setNtitle(rs.getString("ntitle"));
	                news.setNauthor(rs.getString("nauthor"));
	                news.setNsummary(rs.getString("nsummary"));
	                news.setNcontent(rs.getString("ncontent"));
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlz="select tid from topic where tname=?";
		PreparedStatement pz=null;
		int tid = 0;
		ResultSet rr =null;
		try {
			 pz= co.prepareStatement(sqlz);
			 pz.setObject(1, ob[0]);
			  rr = pz.executeQuery();
			 while(rr.next()){
				 tid=rr.getInt("tid");
			 }
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Object qq[]={tid,ob[1],ob[2],ob[3],ob[4],id};
		String sqlup="update news set ntid=?,ntitle=?,nauthor=?,nsummary=?,ncontent=? where nid=?";
		PreparedStatement pp =null;
		int count = 0;
		try {
			pp = co.prepareStatement(sqlup);
			for(int i=0;i<qq.length;i++){
				pp.setObject(i+1, qq[i]);
			}
			count = pp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.closeAll(co, pr, rs);
		super.closeAll(null, pz, rr);
		super.closeAll(null, pp, null);
		return count;
	}

	@Override
	public int addNews(Object[] ob) {
		Connection co = super.getConnection();
		String sql="select tid from topic where tname=?";
		PreparedStatement pr =null;
		ResultSet re=null;
		int ntid=0;
		try {
			pr = co.prepareStatement(sql);
			pr.setObject(1, ob[0]);
			re = pr.executeQuery();
			while(re.next()){
			ntid=re.getInt("tid");
			}
			ob[0]=ntid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sqladd="insert into news(ntid,ntitle,nauthor,nsummary,ncontent) values (?,?,?,?,?)";
		PreparedStatement prr=null;
		int count=0;
		try {
			 prr = co.prepareStatement(sqladd);
			 for(int i=0;i<ob.length;i++){
			 prr.setObject(i+1, ob[i]);
			 }
			  count = prr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int newsCount() {
		String sql="select count('nid') from news";
		ResultSet re = this.executeQuery(sql);
		int num=0;
		try {
		 re.next();
		 num = re.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeAll(null, null, re);
		return num;
	}

	@Override
	public List<News> fenNews(int dangpage, int pagesize) {
		 List<News> list = new ArrayList<News>();
	        ResultSet rs = null;
	        String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`,"
	                + " `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC`"
	                + " WHERE `NEWS`.`ntid` = `TOPIC`.`tid`"
	                + " ORDER BY `ncreateDate` DESC LIMIT ?, ?";
	        rs = this.executeQuery(sql,(dangpage-1)*pagesize,pagesize);
	        News news = null;
            try {
				while (rs.next()) {
				    news = new News();
				    news.setNid(rs.getInt("nid"));
				    news.setNtid(rs.getInt("ntid"));
				    news.setNtitle(rs.getString("ntitle"));
				    news.setNauthor(rs.getString("nauthor"));
				    news.setNcreatedate(rs.getDate("ncreateDate"));
				    news.setNsummary(rs.getString("nsummary"));
				    news.setNtname(rs.getString("tname"));
				    list.add(news);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;
	}

	
}
