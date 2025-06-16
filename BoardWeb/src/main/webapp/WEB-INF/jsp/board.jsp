<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- c태그 사용하려면 라이브러리 넣어줘야됨 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- format타입으로 사용하라면 라이브러리 넣어줘야됨 -->


<%
BoardVO board = (BoardVO) request.getAttribute("board");

String pg = (String) request.getAttribute("page");
String sc = (String) request.getAttribute("searchCondition");
String kw = (String) request.getAttribute("keyword");

String logId = (String) session.getAttribute("logId");
%>
<h3>상세화면(board.jsp)</h3>
<form action="modifyBoard.do">
	<input type="hidden" name="bno" value="${board.boardNo}"> <input
		type="hidden" name="page" value="${pg } "> <input
		type="hidden" name="searchCondition" value="${sc } }"> <input
		type="hidden" name="keyword" value="${kw } }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
			<th>조회수</th>
			<td>${board.readCnt}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea cols="45" rows="4" readonly>${board.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3">${board.writeDate }</td>
		</tr>
		<tr>
			<td colspan="4" align="center"><c:choose>
					<c:when test="${board.writer == logId}">
						<input type="submit" value="수정" class="btn btn-warning">
						<button class="btn btn-danger" type='button'>삭제</button>
						<!-- 타입을 버튼으로 작성해줘야 밑에 script부분이 실행이 됨 -> 버튼을 눌렀을때 실행되야 삭제 됨 -->
						<!-- 타입을 버튼으로 안줬으면 기본값인 submit으로 실행됨, submit으로 실행되면 밑에 script가 아닌 form태그를 실행시킴 -->
					</c:when>

					<c:otherwise>
						<input type="submit" value="수정" class="btn btn-warning" disabled>
						<!-- disabled 불가능하게 하다 (로그인되어있는 아이디와 게시글작성한 아이디가 다르면 변경 불가능) -->
						<button class="btn btn-danger" type='button' disabled>삭제</button>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</form>

<!-- 댓글관련 페이지  -->
<div class="container reply">
	<div class="header">
		<input class="col-sm-8 " id="reply">
		<button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
	</div>

	<div class="content">
		<ul id="title">
			<li><span class="col-sm-2">글번호</span>
			    <span class="col-sm-4">글내용</span>
				<span class="col-sm-2">작성자</span>
			    <span class="col-sm-2">작성일시</span>
				<span class="col-sm-1">삭제</span>
			</li>
		</ul>

		<ul id="target"></ul>

	</div>
	
	<div class="footer">
		<!-- 푸터에는 댓글 페이징 넣기 -->
		<nav aria-label="...">
			<ul class="pagination pagination-sm">
				<li class="page-item disabled">
				<span class="page-link">Previous</span>
				</li> <!-- 이전페이지 -->
				
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item active" aria-current="page">
				<span class="page-link">2</span></li>
				<li class="page-item">
				<a class="page-link" href="#">3</a></li>
				<li class="page-item">
				<a class="page-link" href="#">Next</a>
				</li> <!-- 이후 페이지 -->
			</ul>
		</nav>
	</div>
</div>
<!-- 댓글관련 페이지  -->
<style>
div.reply ul {
	list-style-type: none;
}

div.reply span {
	display: inline-block;
}
</style>
<script>
	let bno = "${board.boardNo}";
	let logId = "${logId}";
	console.log(bno);
	document.querySelector('button.btn-danger').addEventListener('click',
			function() {
				location.href = 'removeBoard.do?bno=' + bno; //href사용하면 get방식
			})
</script>
<script src="js/service.js"></script>
<script src="js/reply.js"></script>