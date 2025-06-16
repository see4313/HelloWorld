/**
 * service.js
 */
// svc 객체의 add메소드
const svc = {
	add: function(num1 = 0, num2 = 0) {
		return num1 + num2;
	},

	//목력을 출력해주는 메소드
	replyList(param = { bno, page }, successCallback, errorCallback) {
		// ajax호출
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(data => data.json()) // data는 매개변수 이름 // 매개변수를 json pasing 하겠다의미
			.then(successCallback)
			.catch(errorCallback)

	},
	//댓글 삭제 메소드
	removeReply(rno, successCallback, errorCallback) {
		// ajax호출
		fetch('removeReply.do?rno=' + rno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	// 댓글 등록 메소드
	addReply(param = { bno, reply, replyer }, successCallback, errorCallback) {  // bno:bno, reply:reply 와 동일 의미인데 줄여서 사용
		//ajax호출
		fetch('addReply.do', { //등록은 get방식보다 post방식
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'bno=' + param.bno + '&reply=' + param.reply + ' &replyer=' + param.replyer
		})
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)

	},

	// 댓글 전체 건수
	replyCount(bno, successCallback, errorCallback) {
		// ajax 호출
		fetch('replyCount.do?bno=' + bno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	}

} // end of replyCount

// add라는 함수
const add = (num1, num2) => {
	return num1 + num2;
}

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
	btn.addEventListener('click', deleteReplyFnc);   // deleteReplyFnc가 실행되는 함수 
	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;   // makeRow함수를 호출한 영역으로 여기까지 만들었던 tr을 반환하겠다의미
} // end of makeRow

