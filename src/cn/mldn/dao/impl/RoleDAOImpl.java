package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IRoleDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
import cn.mldn.vo.Role;

public class RoleDAOImpl extends AbstractDAO implements IRoleDAO {
	@Override
	public Set<String> findAllByMember(String mid) throws SQLException {
		Set<String> set = new HashSet<String>() ;
		String sql = "SELECT flag FROM role"
				+ " WHERE rid IN ( "
				+ " SELECT rid FROM member_role WHERE mid=?) " ;
		super.pstmt = super.conn.prepareStatement(sql) ;
		super.pstmt.setString(1, mid);
		ResultSet rs = this.pstmt.executeQuery() ;
		while(rs.next()) {
			set.add(rs.getString(1)) ;
		}
		return set;
	}
	
	@Override
	public boolean doCreate(Role vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Role vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord)
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

	

}
