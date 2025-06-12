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
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=213');  //페이지 요청할 페이지 지정 (get방식의, 요청하는 페이지)형태로 작성
xhtp.send();  // 실제 페이지요청을 실행
xhtp.onload = function() {
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item) {
		console.log(item);
		let tr = document.createElement('tr');  //<tr></tr>
		//글번호, 내용, 작성자
		for (let prop of ['replyNo', 'reply', 'replyer']) {
			let td = document.createElement('td');  //<td>3</td>
			td.innerHTML = item[prop]; //item['replyNo'] ==item.replyNo;  //배열[]로 넣는 이유는 조금더 동적으로 사용 가능
			tr.appendChild(td);    //<tr><td>3</tr></td>
		}

		// 삭제버튼
		let td = document.createElement('td');
		let btn = document.createElement('td');
		btn.innerHTML = '삭제';
		btn.className = 'btn btn-danger';
		td.appendChild(btn);
		tr.appendChild(td);
		document.querySelector('tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

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
