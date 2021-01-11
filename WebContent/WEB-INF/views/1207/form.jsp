<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<H1> form page.</H1>
	
	<form method="post" action="/spring/file/upload.do" enctype="multipart/form-data">
		id : <input type="text" name="id" /> &nbsp;
		파일 : <input type="file" name="save" />
			<input type="submit" value="전송" />
	</form>