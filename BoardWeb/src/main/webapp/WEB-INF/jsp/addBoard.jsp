<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<form action="addBoard.do" method="post"> 
		<table class="table">
			<tr>
				<th>제목</th>
				<td><input type="text" required name="title"></td> <!-- required는 등록값이 없으면 submit이 안되게 하는것 -->
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" required name="content"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" required name="writer"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td></tr>
		</table>
	</form>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>