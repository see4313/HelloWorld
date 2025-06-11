<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String logId = (String)session.getAttribute("logId");
%>
<h3>글등록화면(addBoard.jsp)</h3>
</head>
<body>
<form action="addBoard.do" method="post"> 
<input type="hidden" class="form-control" name="writer" value="<%=logId%>">

		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" required name="title"></td> <!-- required는 등록값이 없으면 submit이 안되게 하는것 -->
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea type="text" required name="content"></textarea></td> <!-- input은 글추가할때 한줄만 가능, textarea는 줄바꿈해서 여러줄로 가능 -->
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=logId%></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td></tr>
		</table>
	</form>
