package cn.mldn.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.dao.IActionDAO;
import cn.mldn.dao.IMemberDAO;
import cn.mldn.dao.IMemberLogsDAO;
import cn.mldn.dao.IRoleDAO;
import cn.mldn.service.IMemberService;
import cn.mldn.util.factory.Factory;
import cn.mldn.vo.Member;
import cn.mldn.vo.MemberLogs;

public class MemberServiceImpl implements IMemberService {

	@Override
	public Map<String, Object> login(String mid, String password) throws Exception {
		IMemberDAO memberDAO = Factory.getDAOInstance("member.dao") ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		Member result = memberDAO.findLogin(mid, password) ;
		if(result == null) {
			map.put("status", 0) ;
		} else {
			if(result.getLocked().equals(0)) {
				map.put("status", 1) ;		
				map.put("name", result.getName()) ;
				map.put("lastdate", result.getLastdate()) ;
				if(memberDAO.doUpdateLastdate(mid, new Date())) {
					IMemberLogsDAO memberLogsDAO = Factory.getDAOInstance("memberlogs.dao") ;
					MemberLogs mlvo = new MemberLogs() ;
					mlvo.setMid(mid);
					mlvo.setLogindate(new Date());
					memberLogsDAO.doCreate(mlvo) ;
				}
				IRoleDAO roleDAO = Factory.getDAOInstance("role.dao") ;
				map.put("allRoles", roleDAO.findAllByMember(mid)) ;
				IActionDAO actionDAO = Factory.getDAOInstance("action.dao") ;
				map.put("allActions", actionDAO.findAllByMember(mid)) ;	
			} else {
				map.put("status", 2) ;
			}
		}
		return map ;
	}
}
