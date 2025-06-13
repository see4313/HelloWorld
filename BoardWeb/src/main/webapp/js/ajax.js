/**
 * ajax.js 
 * ajax: Asynchronous Javascript And Xml
 */
// 비동기 vs 동기 방식
// 비동기방식 -(작업시간에따라 콘솔에 찍히는 순서가 달라짐) 초가 빠를수록 빠른 순서로 콘솔에 찍힘, 작업 속도가 빠름

/*setTimeout(function() {
	console.log("1");
}, 1000);   //settimeout 1(1000)초 기다렸다가 안에있는 함수 실행

setTimeout(function() {
	console.log("2");
}, 2000);   // 2000 = 2초

setTimeout(function() {
	console.log("start");
}, 2500);   // 2500 = 2.5초 */


//{"id": 1, "first_name": "Hong"}  => json객체(문자열)
// {id: 1, "first_name": Hong}     => 문자열 객체를 자바스크립트객체로 바꾸는 작업을 parsing 이라고함

// 객체. XMLHttpRequest
//console.log("start");
let xhtp = new XMLHttpRequest();   // ajax 호출
xhtp.open('get', 'replyList.do?bno=213');  //페이지 요청할 페이지 지정 (get방식의, 요청하는 페이지)형태로 작성
xhtp.send();  // 실제 페이지요청을 실행
xhtp.onload = function() {
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);  // json 문자열 -> 자바스크립트 객체로 pasing
	data.forEach(function(item) {
		//console.log(item);
		
		let tr = makeRow(item);   
		// tr을 tbody에 추가

		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);   //2번째 table의 tbody
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

// 등록이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

// 댓글등록 함수
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;  //document.querySelector('#bno') == input태를 말함
	const reply = document.querySelector('#reply').value;  // 댓글내용

	// 필수입력
	if (!bno || !reply || !logId) {  // 입력값들이 없을떄는 false
		alert('필수값 입력!');
		return;
	}
	const addAjax = new XMLHttpRequest();
	addAjax.open('get', 'addReply.do?bno=' + bno + '&reply=' + reply + '&replyer=' + logId);
	addAjax.send();
	addAjax.onload = function(ev) {
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'Success') {
			alert('등록성공!');
			let tr = makeRow(result.retVal);
			//부모요소의 insertBefore(새요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) tbody tr')
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target); //insertBefore(tr, target) 댓글순서를 최근걸 맨 위로 설정
		} else {
			alert('등록실패!');
		} 
	}
}

// 댓글삭제 함수
function deleteReplyFnc(e) {  //(e)이벤트
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	let rno = e.target.parentElement.parentElement.dataset.rno;  //데이터 처리
	console.log(rno);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeReply.do?rno=' + rno);
	delAjax.send();  //센드가 실행되야 데이터에도 요청
	delAjax.onload = function(ev) {  // onload 이벤트가 발생하면 함수가 실행됨
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Success') {
			e.target.parentElement.parentElement.remove();  //화면에서 지우는 기능.
		}
		else {
			alert('처리실패')
		}
	}
}  // end of deleteReplyFnc

// 댓글출력 함수를 row로 생성
function makeRow(item) {
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

//멤버리스트 함수
function memberList() {
	//console.log("1");
	//console.log(xhtp.responseText);  //parsing
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>"
	data.forEach(function(item, idx, arr) {
		console.log(item);
		str += "<li>" + item.id + "," + item.first_name + "</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
console.log("end");


//fetch('data/sample.json')
