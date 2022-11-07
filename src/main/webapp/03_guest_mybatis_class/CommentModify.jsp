<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="mybatis.guest.model.Comment" %>   
 <%@ page import="mybatis.guest.service.CommentService" %>  
<%
	// 0. 넘겨받는 데이타의 한글 처리
	request.setCharacterEncoding("utf-8");
%>

<!-- 1. 이전 화면의 입력값을 넘겨받아 BoardRec 객체의 각 멤버변수로 지정 -->
 <jsp:useBean id="comment" class="mybatis.guest.model.Comment">
 	<jsp:setProperty name="comment" property="*"/>
 </jsp:useBean>   
 

<% 

  	CommentService.getInstance().updataComment(comment);
  %> 

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판글수정</title>
</head>
<body>


    <jsp:forward page="listComment.jsp"/>

</body>
</html>