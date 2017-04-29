package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Date;

import cn.mldn.util.dao.IBaseDAO;
import cn.mldn.vo.Member;

public interface IMemberDAO extends IBaseDAO<String, Member> {
	public Member findLogin(String mid ,String password) throws SQLException ;
	public boolean doUpdateLastdate(String mid,Date lastdate) throws SQLException ;
}
