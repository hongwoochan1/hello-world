<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<H1> List page.</H1>
	
	<table border="1" >
		<tr>
		   <td>NO</td>
		    <td>ID</td>
		    <td>Save Name</td>
		     <td>Original Name</td>
		      <td>Date</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
			   <td>${dto.num}</td>
			    <td>${dto.id}</td>
			    <td> <a href="/spring/file/down.do?file=${dto.savename}">${dto.savename}</a></td>
			     <td>${dto.orgname}</td>
			      <td>${dto.reg}</td>
			</tr>
		</c:forEach>
	</table>