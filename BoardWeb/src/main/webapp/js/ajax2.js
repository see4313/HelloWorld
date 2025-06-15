/**
 *  ajax2.js
 */
console.log(svc.add(10, 20)); // add라는 함수를 사용해서 더하기함

// 목록을 출력해주는 메소드를 활용
svc.replyList(221,  // 게시글 번호
	function(result) {  // 매개값은 result
		console.log(result);
		result.forEach(function(item) {  //forEach 반복문 사용해서 각각의 한줄을 만듬
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);   //2번째 table의 tbody
		});  // 댓글수만큼 tr 생성
	},  // 성공했을 때 실행할 콜백함수
	function(err) {
		console.error(err);
	}) // 실패했을 떄 실행할 콜백함수

// 등록이벤트함수
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;  //document.querySelector('#bno') == input태를 말함
	const reply = document.querySelector('#reply').value;
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	
	// 메소드호출
	svc.addReply({ bno, reply, replyer: logId },  //속성과 변수값이 같아서 한번만 사용, replyer만 {key가 replyer value가 logId}
		function(result) {
			if (result.retCode == 'Success') {
				alert('등록성공!');
				let tr = makeRow(result.retVal);
				// 부모요소. insertBefore(새요소, 대상)
				let target = document.querySelector('table:nth-of-type(2) tbody tr')
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);  //insertBefore(tr, target) 댓글순서를 최근걸 맨 위로 설정
			} else {
				alert('삭제실패!');
			}
		},
		function(err) {
			console.error(err);
		})
}  // end of addReply

// 삭제함수
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result) {
			if (result.retCode == 'Success') {
				alert('삭제성공!');
				e.target.parentElement.parentElement.remove();  // 화면에서 삭제
			} else {
				alert('삭제실패!');
			}
		},
		function(err) {
			console.error(err);
		}
	)
}// end of deleteReplyFnc.

