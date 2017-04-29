<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.util.factory.*" %>
<%@ page import="cn.mldn.service.*" %>
<%@ page import="cn.mldn.util.*" %>
<%@ page import="cn.mldn.util.enctype.*" %>
<html>
<head>
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
<jsp:include page="/pages/plugins/include_basepath.jsp" />
</head>
<%
	request.setCharacterEncoding("UTF-8") ;
	String url = "login.jsp" ;
	String msg = "用户注销成功，再见！" ; 
	RememberMeUtil rmu = new RememberMeUtil(request,response) ;
	rmu.clear() ;
	session.invalidate() ;
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
								<jsp:param value="<%=url%>" name="url"/>
								<jsp:param value="<%=msg%>" name="msg"/>
							</jsp:forward>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>