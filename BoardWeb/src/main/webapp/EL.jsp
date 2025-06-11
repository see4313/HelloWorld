<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	request.setAttribute("msg", "Hello"); //  request : 한번요청하면 끝
	session.setAttribute("errorMsg", "ID,PW 확인"); // session : 일정기간 서버상의 정보 유지하기위해 사용하는 객체
	application.setAttribute("projectName", "BoardWeb"); // application : 어플리케이션을 시작할때부터 종료할떄까지 계속 사용하는 객체
	String name = "hong";
	System.out.print(name);

	BoardService svc = new BoardServiceImpl();
	SearchDTO search = new SearchDTO();
	search.setPage(1);
	List<BoardVO> list = svc.boardList(search);
	request.setAttribute("blist", list);
	%>

	${'Hello, world'}
	<!-- 새로운 페이지에 출력 -->
	${10 - 5 == 10}
	<!-- 연산 가능 -->
	${10 - 5 le 10 }

	<p>${!empty msg }</p>
	<!-- =not empty 라서 true출력 -->
	<p>${errorMsg }</p>
	<!-- Attribute에 담겨잇는 정보를 순차적으로 찾아와서 읽어들임 -->
	<p>${empty hello }</p>

	<c:set var="name" value="Hongkildong"></c:set>
	<c:out value="${name }"></c:out>
	<!-- 네임태그를 출력하고싶으면 달러중괄호 안에 변수이름 사용 , 주석 사용할때 달러 중괄호 사용하면 에러 -->

	<c:set var="age" value="20"></c:set>
	<c:if test="${age >= 20 }">
		<p>성인</p>
	</c:if>

	<!-- == 조건문(if, else) -->
	<c:choose>
		<c:when test="${!empty logId }">
			<p>로그인상태</p>
		</c:when>
		<c:otherwise>
			<p>로그아웃상태</p>
		</c:otherwise>
	</c:choose>


	<!-- 반복문(for) -->
	<c:forEach var="i" begin="1" end="5">
		<span>i의 값은 ${i }</span>
	</c:forEach>

	<!-- 반복문2 -->
	<table border="1">
		<c:forEach var="board" items="${blist }">
			<tr>
				<td>${board.boardNo }</td>
				<!-- board.getBoardNo() 중괄호 안에는 메소드 사용 안함 -->
				<td>${board.title }</td>
				<!-- board.getTitle() 속성이름만 적으면 알아서 불러와짐-->
				<td><c:out value="${board.writer }"/></td>  <!-- c:out태그로 사용해서 필드이름 넣어주면 출력도 가능 -->
				<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>