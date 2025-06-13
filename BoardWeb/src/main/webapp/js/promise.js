/**
 * promise.js
 * 
 * 비동기 방식의 처리를 동기방식의 순서로 처리해주는게 promise
 * promise는 .then의 순서대로 실행됨
 * 
 * fetch 함수사용 
 * fetch()
 * .then()
 * .then()
 * .catch() 순으로 사용된다
 */
// 화살표 함수
/*function add(num1, num2){
  return num1 + num2;
}
const add = (num1, num2) =>  num1 + num2 */ //화살표를 활용해서 매개변수를 실행시켜줌

// 목록출력하는 기능
fetch('replyList.do?bno=213')
	.then(function(data) {
		//console.log(data);  //response결과
		return data.json();    // json -> object형태로 바꿔주는 json함수

	})
	.then(function(result) {
		console.log(result);
		result.forEach(function(item) {
			//console.log(item);

			let tr = makeRow(item);
			// tr을 tbody에 추가
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);   //2번째 table의 tbody
		});  // 댓글수만큼 tr 생성

	})
	.catch(function(err) {  // then 구문에서 에러가 발생하면 catch구문에서 처리(catch구문이 없으면 어디서 에러난지 알수가 없음)
		console.log(err);
	})  // end of 목록출력

//댓글등록 함수
document.querySelector('#addReply').addEventListener('click', addReplyFnc);


function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;  //document.querySelector('#bno') == input태를 말함
	const reply = document.querySelector('#reply').value;
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	//ajax 호출
	// fetch(url) => get 방식(url만 있으면 get방식)
	// fetch(url, option) => post방식으로 요청
	fetch('addReply.do', {
		method: 'post',  // post방식으로 요청
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + logId
	}) 
	.then(json => json.json())
	.then(result => {
		if (result.retCode == 'Success') {
			alert('등록성공!');
			let tr = makeRow(result.retVal);
			// 부모요소. insertBefore(새요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) tbody tr')
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);  //insertBefore(tr, target) 댓글순서를 최근걸 맨 위로 설정
		} else {
			alert('삭제실패!');
		}
	})
	.catch(err => console.error(err))
}// end of addReply

//삭제함수
function deleteReplyFnc(e) {
	if (!confirm("삭제하겠습니까?")) {
		return;
	}
	// remobeReply.do?rno=23
	let rno = e.target.parentElement.parentElement.dataset.rno;  //데이터 처리

	//ajax 호출
	fetch('removeReply.do?rno=' + rno)
		.then(json => json.json())   // 화살표 함수
		.then(data => {
			if (data.retCode == 'Success') {
				alert('삭제성공!');
				e.target.parentElement.parentElement.remove();  // 화면에서 삭제
			} else {
				alert('삭제실패!');
			}
		})
		.catch(err => console.error(err))
}// end of deleteReplyFnc

// 댓글출력 함수를 row로 생성
function makeRow(item) {  //makeRow가 하는게 tr을 만들어줌
	let tr = document.createElement('tr');  //<tr></tr>
	tr.setAttribute('data-rno', item.replyNo);  // <tr data rno = "8"> </tr>  == tr에 데이터가 8인 값을 담음
	//글번호, 내용, 작성자
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td');  //<td>3</td>
		td.innerHTML = item[prop]; //item['replyNo'] ==item.replyNo;  //배열[]로 넣는 이유는 조금더 동적으로 사용 가능
		tr.appendChild(td);    //<tr><td>3</tr></td>
	}

	// 버튼생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteReplyFnc);
	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;   // makeRow함수를 호출한 영역으로 여기까지 만들었던 tr을 반환하겠다의미
} // end of makeRow

