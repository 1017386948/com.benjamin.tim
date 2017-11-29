<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- wo shi ni die! -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Today's date</title>
</head>
<body>
	<jsp:forward page="welcome.jsp">
	<jsp:param name="text" value="Please login"/>
	</jsp:forward>
	<%
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = dateFormat.format(new Date());
		out.write(s);

	/* 	pageContext.setAttribute("hehe", 11111L, pageContext.SESSION_SCOPE);
		for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
			String header = e.nextElement();
			out.println(header + ": " + request.getHeader(header) + "<br/>");
		} */
	%>
</body>
</html>