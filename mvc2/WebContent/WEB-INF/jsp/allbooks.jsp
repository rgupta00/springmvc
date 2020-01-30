<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
<table border="1">
	<thead>
		<tr>
			<th>book id</th>
			<th>isbn</th>
			<th>title</th>
			<th>author</th>
			<th>price</th>
			<th>pub date</th>
			<th>publisher</th>
			<th>delete</th>
			<th>update</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.bookId}</td>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.pubDate}</td>
				<td>${book.publisher}</td>
				<td><a href="deletebook?id=${book.bookId}">delete</a></td>
				<td><a href="updatebook?id=${book.bookId}">update</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br/>
<br/>
<a href="addbook">addbook</a>
</body>
</html>









