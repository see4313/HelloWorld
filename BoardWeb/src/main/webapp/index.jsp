<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="boardList.do" />
	<%
	// 자바영역 <% 안은 자바영역, <% 밖은 html영역
	//sample.jsp -> sample_jsp.java -> sample_jsp.class 실행
	
	String str = "Hello, World";
	for (int i = 0; i < 10; i++) {
	%>
	<h3>여기는 HTML영역입니다</h3>
	<%
	} // end of for
		// 여기 자바영역임...
	BoardService svc = new BoardServiceImpl();
	List<BoardVO> list = svc.boardList(null);  //1은 그냥 오류 없앨려고 넣음!
	out.print("<ul>");
	for (BoardVO board : list) {
		%>
		<li><%=board.getBoardNo() %>,<%=board.getTitle() %></li>
		<% 
	}out.print("</ul>");
	System.out.println(str);
	%>
</body>
</html>