<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import = "ch11.Logon.LogonDBBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/resource/etc/color.jsp"%>

<html>
<head>
<title>ȸ��Ż��</title>
<link href="/spring/resource/style/style.css" rel="stylesheet" type="text/css">

</head>

<c:if test="${check == 1}">
<body bgcolor="${bodyback_c}">

<form method="post" action="/spring/member/main.do" name="userinput" >

<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  
  <tr bgcolor="${title_c}"> 
    <td height="39" align="center">
	  <font size="+1" ><b>ȸ�������� �����Ǿ����ϴ�.</b></font></td>
  </tr>
  
  <tr bgcolor="${value_c}">
    <td align="center"> 
      <p>����.... �����մϴ�. �ȳ��� ������.</p>
      <meta http-equiv="Refresh" content="3;url=/spring/member/main.do" >
    </td>
  </tr>
  
  <tr bgcolor="${value_c}">
    <td align="center"> 
      <input type="submit" value="Ȯ��">
    </td>
  </tr>
</table>
</form>
</c:if>

<c:if test="${check != 1}">
	<script> 
	  alert("��й�ȣ�� ���� �ʽ��ϴ�.");
      history.go(-1);
	</script>
</c:if>

</body>
</html>
