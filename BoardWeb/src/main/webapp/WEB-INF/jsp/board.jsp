<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- c태그 사용하려면 라이브러리 넣어줘야됨 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- format타입으로 사용하라면 라이브러리 넣어줘야됨 -->

<link
	href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>

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
		<button class="col-sm-3 btn btn-danger" id="delReply">삭제</button>
	</div>

	<!-- datatable 활용 -->
	<table id="example" class="display">
		<thead>
			<tr>
				<th>댓글번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>댓글번호</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</tfoot>
	</table>

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

<script>
const table = new DataTable('#example', {
    ajax: 'replyList.do?bno='+bno,
    columns: [
        { data: 'replyNo' },
        { data: 'reply' },
        { data: 'replyer' },
        { data: 'replyDate' }
    ],
    lengthMenu: [5, 10, 15, -1],
     order: [[0, 'desc']]
});

// row 삭제
table.on('click', 'tbody tr', (e) => { // on이 클릭 이벤트
    let classList = e.currentTarget.classList;  // tr 부분에 e.current~ 클릭이벤트 실행하면 배열처럼 반환
 
    if (classList.contains('selected')) {  // tr에 selected가 있는지 확인하고 
        classList.remove('selected');      // selected가 있으면 지움
    }
    else {
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));  //제이쿼리방식으로 forEach가 .each로 표현됨
        classList.add('selected');   
    }
});

 // 삭제하기 전에 선택해서 지움
document.querySelector('#delReply').addEventListener('click',async function () {
	// 한건 삭제후 화면 갱신
	if(!document.querySelector('tr.selected')){
		alert('댓글을 선택하세요');
		return;
	}
	//삭제할 댓글 번호
	let rno = document.querySelector('tr.selected').children[0].innerHTML;
	let data = await fetch('removeReply.do?rno=' + rno);
	let result = await data.json();
	if(result.retCode == 'Success') {
		table.row('.selected').remove().draw(false);   //draw(false) 해줘야 화면 리프레쉬
	}
	
});


function addNewRow() {
	// ajax 호출
	let reply = document.querySelector('#reply').value;
	if(!reply || !logId){
		return;
	}
	fetch('addReply.do?bno='+ bno+ '&reply=' + reply +'&replyer=' + logId)
	.then(data => data.json())
	.then(result => {
		console.log(result);
		let rvo = result.retVal;
	// 화면에 low를추가
    table.row
        .add({replyNo: rvo.replyNo,
              reply: rvo.reply,
              replyer: rvo.replyer,
              replyDate: rvo.replyDate
             })
        .draw(false);
	})
	.catch(err => console.log(err));
}
 
document.querySelector('#addReply').addEventListener('click', addNewRow);
</script>