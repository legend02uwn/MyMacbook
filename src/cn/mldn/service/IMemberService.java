package cn.mldn.service;

import java.util.Map;

public interface IMemberService {
	public Map<String,Object> login(String mid,String password) throws Exception ;
}
