<%@ page pageEncoding="UTF-8" %>
<jsp:include page="/pages/plugins/include_basepath.jsp" />
<% 
	String msg = request.getParameter("msg") ; 
	String url = request.getParameter("url") ; 
%> 
<script type="text/javascript"> 
	window.onload = function() { 
		goForward() ; 
	} 
	function goForward() {
		spanObject = document.getElementById("countSpan") ; 
		count = parseInt(spanObject.innerHTML) ; 
		count -- ; 
		if (count == 0) { 
			window.location = "<%=url%>" ; 
			} else { 
				spanObject.innerHTML = count ; 
				setTimeout(goForward,1000) ;
		}
	}
</script> 
<div><%=msg%></div> 
<div><span id="countSpan">4</span>秒后跳转到其它页面，如果没有跳转，请按<a href="<%=url%>">这里！</a></div>