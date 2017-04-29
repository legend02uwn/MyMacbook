package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMemberDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vo.Member;

public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
	@Override
	public boolean doCreate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<String> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findLogin(String mid, String password) throws SQLException {
		String sql = "SELECT name,lastdate,locked FROM member WHERE mid=? AND password=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		super.pstmt.setString(2, password);
		ResultSet rs = super.pstmt.executeQuery() ;
		if(rs.next()) {
			Member vo = new Member() ;
			vo.setName(rs.getString(1));
			vo.setLastdate(rs.getDate(2));
			vo.setLocked(rs.getInt(3));
			vo.setMid(mid);
			return vo ;
		}
		return null;
	}

	@Override
	public boolean doUpdateLastdate(String mid, Date lastdate) throws SQLException {
		String sql = "UPDATE member SET lastdate=? WHERE mid=?" ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setDate(1, new java.sql.Date(lastdate.getTime())) ;
		super.pstmt.setString(2, mid) ;
		return super.pstmt.executeUpdate() > 0 ;
	}
}
