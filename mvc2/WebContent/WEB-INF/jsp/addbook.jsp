<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Addbook/update book</title>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
		<form:hidden path="bookId"/>
	Enter isbn: <form:input path="isbn"/><form:errors path="isbn"/><br/>
	Enter title: <form:input path="title"/><form:errors path="title"/><br/>
	Enter author: <form:input path="author"/><form:errors path="author"/><br/>
	Enter publisher: <form:input path="publisher"/><form:errors path="publisher"/><br/>
	Enter price: <form:input path="price"/><form:errors path="price"/><br/>
	Enter pubDate: <form:input path="pubDate"/><form:errors path="pubDate"/><br/>
	<input type="submit">
</form:form>
</body>
</html>













