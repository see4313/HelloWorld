/**
 * reply.js
 */
//글목록 출력
let page = 1; // page 선택. (보고싶은 페이지를 입력해주면 됨)

console.log(bno);
// Data 객체에 format 메소드 추가
Date.prototype.format = function() {
	let yyyy = this.getFullYear();    //2025-05-27 12:39 형태의 포멧으로 만들어냄
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();

	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2); //  // sclie는 뒤에서 두자리만 잘라서 들고오겠다의미
	//+ ' ' + ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2);  
}

// 댓글목록 출력
showReplyList();
function showReplyList() {
	document.querySelector('#target').innerHTML = "";  // 목록지우기(화면 초기화) // document.querySelector는 요소를 가지고 오는 것
	svc.replyList({ bno, page }  //게시글번호
		, result => {
			let ul = document.querySelector('#target');
			let template = document.querySelector('#target li');  //첫번쨰 li만 select해서 가지고 오겠다의미 queryall 이면 전부 갖고오겠다의미
			for (let reply of result) {
				template = makeTemplate(reply);  // 밑에 template의 li들의 값을 teplate변수에 담아줌
				//
				ul.insertAdjacentHTML("beforeend", template);  //ul태크를 기준으로 beforeend 는 끝에 붙음
			}
			// 댓글페이지
			showPageList();
		}
		, err => console.log(err)

	);  //end of replyList.
} // end oif showReplyList.

//이벤트
// 1)댓글등록 이벤트
document.querySelector('#addReply').addEventListener('click', addReplyHandler);

// 2)댓글링크에 이벤트함수등록
function pagingEvent() {
	document.querySelectorAll('.footer nav a').forEach(function(elem, idx) {
		elem.addEventListener('click', function(e) {
			page = e.target.dataset.page;  // a태그의 <a data-page="1">1</a>  // 페이지라는 속성 가지고와서 이동할 페이지로
			showReplyList();
			
		})
	});
} // end of pagingEvent

// 댓글등록이벤트 핸들러
function addReplyHandler(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert('값을 확인하세요!');
		return;
	} 
	// 정상적으로 있으면 댓글 등록메소드
	svc.addReply({ bno, reply, replyer: logId }  // replyer만 속성과 변수명이 달라서 따로 써주고 나머지는 속성과 변수명이 같아서 한번만 써줌
		, result => {
			let ul = document.querySelector('#target');
			if (result.retCode == "Success") {
				let rval = result.retVal;
				//ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));   // afterbegin는 ul태그를 기준으로 앞에 붙음
				page = 1; // 첫페이지로 지정
				showReplyList();  // 댓글목록 출력
				document.querySelector('#reply').value = "";   // 입력값 초기화
			}  // end of if.
		}
		, err => console.log(err)
	)
}

//댓글삭제함수
async function deleteReply(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno; 
	// 다른 방식 => let replyer = e.target.parentElement.parentElement.children[2].textContent;
	let data = await fetch('replyInfo.do?rno=' + rno);  
	let result = await data.json();
		if (result.replyer != logId) {  // 댓글작성자와 아이디가 일치하지 않으면 권한 없음
			alert('권한없음!');
			return;
		}
	
	 // 권한이 있을 경우에 삭제함
	svc.removeReply(rno,
		result => {
			if (result.retCode == "Success") {
				alert("처리성공");
				//e.target.parentElement.parentElement.remove;
				showReplyList();
			} else {
				alret("처리실패");
			}
		}
		, err => console.log(err)
	);
}// end of deleteReply

// 댓글화면출력함수
function showPageList() {
	svc.replyCount(bno  // 첫번째 매개값
		, result => {
			console.log(result.totalCnt);  //{totalCnt: 80}
			let totalCnt = result.totalCnt;
			let start, end;  // 첫번쨰페이지부터 마지막페이지
			let prev, next;  // 이전, 이후 페이지의 존재여부
			let realEnd = Math.ceil(totalCnt / 5)  // 실제 건수를 기준으로 계산한 마지막 페이지

			end = Math.ceil(page / 10) * 10;  // 계산상의 마지막 페이지.
			start = end - 9;
			end = end > realEnd ? realEnd : end; // 원래 마지막 페이지로 한번 더 마지막 페이지를 구해줌		
			prev = start > 1;
			next = end < realEnd;
			// 기존 페이징 clear.
			document.querySelector('nav ul.pagination-sm').innerHTML = "";  // 지우기
			// 계산했는 값을을 가지고 페이지 목록을 출력
			let target = document.querySelector('nav ul.pagination-sm');
			// 이전페이지
			let str;
			if (prev) {
				str = `<li class="page-item">
					<a class="page-link" href="#" data-page="${start - 1}">Previous</a>
					</li>`;
			} else {
				str = `	<li class="page-item disabled">
					<span class="page-link">Previous</span>
					</li>`;

			}
			target.insertAdjacentHTML('beforeend', str);
			// 1~ 10페이지까지
			for (let p = start; p <= end; p++) {
				if (p == page) {
					str = `<li class="page-item active" aria-current="page">
					   <span class="page-link">${p}</span>
					   </li>`;
				} else {
					str = `<li class="page-item">
						<a class="page-link" href="#" data-page="${p}">${p}</a>
						</li>`;
				}
				target.insertAdjacentHTML('beforeend', str);
			}

			// 이후페이지
			if (next) {
				str = `<li class="page-item">
					<a class="page-link" href="#" data-page="${end + 1}">Next</a>
					</li>`;
			} else {
				str = `	<li class="page-item disabled">
					<span class="page-link">Next</span>
					</li>`;

			}
			target.insertAdjacentHTML('beforeend', str);
			// 생성한 A태크에 이벤트 등록
			pagingEvent();
		}
		, err => console.log(err)
	);
} // end of showPagingList.

// 댓글화면출력
function makeTemplate(reply = {}) {
	let rdate = new Date(reply.replyDate).format();  //date객체의 formate메소드를 활용해서 rdate를 갖고올수 있음

	template = `
       <li data-rno=${reply.replyNo}>
	      <span class = "col-sm-2">${reply.replyNo}</span>
	      <span class = "col-sm-4">${reply.reply}</span>
	      <span class = "col-sm-2">${reply.replyer}</span>
	      <span class = "col-sm-2">${rdate}</span>
	      <span class = "col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
	    </li>
		`;
	return template;  // <li>...</li> 반환
}// makeTemplete