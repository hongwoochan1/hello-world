<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "ch11.Logon.LogonDBBean" %>
<%@ include file="/resource/etc/color.jsp"%>

<link href="/spring/resource/style/style.css" rel="stylesheet" type="text/css">

<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr bgcolor="${title_c}"> 
    <td height="39"  align="center">
	  <font size="+1" ><b>ȸ�������� �����Ǿ����ϴ�.</b></font></td>
  </tr>
  <tr>
    <td bgcolor="${value_c}" align="center"> 
      <p>�Է��Ͻ� ������ ������ �Ϸ�Ǿ����ϴ�.</p>
    </td>
  </tr>
  <tr>
    <td bgcolor="${value_c}" align="center"> 
      <form>
	    <input type="button" value="��������" onclick="window.location='/spring/member/main.do'">
      </form>
      3�� �Ŀ� �������� �̵��˴ϴ�.<meta http-equiv="Refresh" content="3;url=/spring/member/main.do" >
    </td>
  </tr>
</table>
</body>
</html>
