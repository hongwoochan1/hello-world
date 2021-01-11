<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<h1>fileNum page.</h1>
	
	<h1>id = ${id}</h1>
	
	<c:forEach var="orgname" items="${list}">
		<B>파일 이름 = ${orgname}</B><br />
	</c:forEach>
	
	<h1>orgname = ${orgname}</h1>
	
	<h1> 총${n} 개</h1>