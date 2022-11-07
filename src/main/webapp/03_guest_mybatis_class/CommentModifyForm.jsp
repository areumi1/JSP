<%@ page language="java" contentType="text/html; charset=utf-8"%>
 <%@ page import="mybatis.guest.model.Comment" %>   
 <%@ page import="mybatis.guest.service.CommentService" %>  
   
<% 
  int commentNo = Integer.parseInt( request.getParameter("cId"));
  Comment comment = CommentService.getInstance().selectCommentByPrimaryKey(commentNo);

  %> 

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정하기</title>
</head>
<body>

메세지를 수정해주세요.
<form name="frm" action="CommentModify.jsp" >
<table>
	<tr><td>글번호</td><td><input type="text" name="commentNo" size="3" value='<%= comment.getCommentNo()  %>' readonly></td></tr>
	<tr><td>사용자</td><td><input type="text" name="userId" size="15" value='<%= comment.getUserId()  %>'/></td></tr>
	<tr><td>메세지</td><td><textarea name="commentContent" rows="10" columns="40"><%= comment.getCommentContent()  %></textarea></td></tr>
	<tr><td><input type="submit" value="입력"/></td></tr>
</table>
</form>
</body>

</html>