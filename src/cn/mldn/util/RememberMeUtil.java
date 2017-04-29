package cn.mldn.util;

import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RememberMeUtil {
	private static final String REMEBER_ME_TITLE = "menuuser" ;
	private HttpServletRequest request ;
	private HttpServletResponse response ;
	public RememberMeUtil(HttpServletRequest request, HttpServletResponse response) {
		this.request = request ;
		this.response = response ;
	}
	public void saveRemeber(String mid,String password) {
		String str = mid + ":" + password ;
		String newStr = new String(Base64.getEncoder().encode(str.getBytes())) ;
		Cookie c = new Cookie(REMEBER_ME_TITLE,newStr) ;
		c.setMaxAge(86400);
		c.setPath(this.request.getContextPath());
		this.response.addCookie(c);
	}
	public void clear() {
		Cookie c = new Cookie(REMEBER_ME_TITLE,"") ;
		c.setMaxAge(0);
		c.setPath(this.request.getContextPath());
		this.response.addCookie(c);
	}
	public String[] loadRemeber() {
		Cookie c[] = this.request.getCookies() ;
		if(c == null) {
			return null ;
		}
		for(int i = 0; i < c.length; i ++) {
			if(REMEBER_ME_TITLE.equalsIgnoreCase(c[i].getName())) {
				String str = c[i].getValue() ;
				if("".equals(str)) {
					return null ;
				}
				String old = new String(Base64.getDecoder().decode(str.getBytes())) ;
				return old.split(":") ;
			}
		}
		return null ;
	}
}
