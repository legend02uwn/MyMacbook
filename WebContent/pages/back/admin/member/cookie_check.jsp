<%@page import="cn.mldn.util.RememberMeUtil"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.mldn.vo.*"%>
<%@ page import="cn.mldn.util.factory.*"%>
<%@ page import="cn.mldn.service.*"%>
<%@ page import="cn.mldn.util.enctype.*"%>
<html>
<head>
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
</head>
<%
	request.setCharacterEncoding("UTF-8") ;
	String url = "login.jsp" ;
	String msg = "您还未登录，请先进行登录！" ;
	RememberMeUtil rmu = new RememberMeUtil(request,response) ;
	String user[] = rmu.loadRemeber() ;
	if(user == null) {
%>
		<jsp:forward page="/pages/plugins/forward.jsp">
			<jsp:param value="<%=url%>" name="url" />
			<jsp:param value="<%=msg%>" name="msg" />
		</jsp:forward>
<%
	} else {
		String mid = user[0];
		String password = user[1] ;
		IMemberService memberService = Factory.getServiceInstance("member.service") ;
		Map<String,Object> map = memberService.login(mid,password) ;
		int result = (Integer) map.get("status") ;
		if(result == 1) {
			session.setAttribute("mid", mid) ;
			session.setAttribute("name", map.get("name")) ;
			session.setAttribute("lastdate", map.get("lastdate")) ;
			session.setAttribute("allRoles", map.get("allRoles")) ;
			session.setAttribute("allActions", map.get("allActions")) ;
			url = "index.jsp" ;
			msg = "用户登录成功，欢迎您回来！" ;
		} else if (result == 2){
			url = "index.jsp" ;
			msg = "该用户已被锁定，请与管理员联系！" ;
		} else {
			msg = "您的本地登录认证信息已过期，请重新登陆！" ;
		}
	}
%>
<body>
	<div class="top-content">
		<div class="inner-bgx">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>企业人事管理系统</h3>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"><img src="images/login-lock.png"></i>
							</div>
						</div>
						<div class="form-bottom">
							<jsp:forward page="/pages/plugins/forward.jsp">
								<jsp:param value="<%=url%>" name="url" />
								<jsp:param value="<%=msg%>" name="msg" />
							</jsp:forward>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>