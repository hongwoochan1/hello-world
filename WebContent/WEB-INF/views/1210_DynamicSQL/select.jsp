<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<h1>Select page.</h1><br />
	
	<c:forEach var="dto" items="${list }">
		${dto.num} / ${dto.id} / ${dto.orgname} / ${dto.reg}
		<br />
	</c:forEach>
	