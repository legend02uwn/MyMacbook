package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Role;

public interface IRoleDAO extends IBaseDAO<Integer, Role> {
	public Set<String> findAllByMember(String mid) throws SQLException ;
}
