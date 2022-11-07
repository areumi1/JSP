<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> JSTL </title>
</head>
<body>

<!--  변수선언  -->
<c:set var='gender' value='female'/>

<c:if test="${gender eq 'male'}"> 당신은 남성</c:if>
<c:if test="${gender eq 'female'}"> 당신은 여성</c:if>

<c:set var='age'>7</c:set>
<c:choose>
	<c:when test="${age lt 10}">어린이 입니다.</c:when>
	<c:when test="${age ge 10 and age lt 20 }">청소년 입니다.</c:when>
	<c:otherwise>성인 입니다.</c:otherwise>
</c:choose>
<hr/>

<c:set var='sum' value='0'/>
<c:forEach var='i' begin='1' end='100'>
	<c:set var='sum' value='${sum+i}'/>
</c:forEach>
1~100 까지의 합 : ${sum}<hr/>

<!--  1~ 100 짝수의 합/ 홀수의 합 구하기 -->

<c:forEach var='i' begin='1' end='100'>
	<c:choose>
		<c:when test="${i mod 2 ne 0}">
			<c:set var='odd' value='${odd+i}'/>
		</c:when>
		<c:otherwise>
			<c:set var='even' value='${even+i}'/>
		</c:otherwise>
	</c:choose>
</c:forEach>
1~100 까지의 홀수 합 : ${odd}<hr/>
1~100 까지의 짝수 합 : ${even}<hr/>

<c:forEach var='i' begin='1' end='100'>

		<c:if test="${i mod 2 ne 0}">
			<c:set var='odd1' value='${odd1+i}'/>
		</c:if>
		<c:if test="${i mod 2 eq 0}" >
			<c:set var='even1' value='${even1+i}'/>
		</c:if>

</c:forEach>
1~100 까지의 홀수 합 : ${odd1}<hr/>
1~100 까지의 짝수 합 : ${even1}<hr/>


</body>
</html>

<!-- 

	* JSP 기초 문법
	
	< %@ %> : 설정
			- page
			- include
			- taglib : JSTL 사용
			
	< %! %> : 선언(변수, 함수)
	< % %> : 스크립트릿 (자바코드)
	< %= %> : 표현식 ( 화면결과 

--> 