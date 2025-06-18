/* 
*covid.js
*/
import { makeRow, url } from './covid_module.js';

let centerAry;  //변수선언

fetch(url)    // fetch 비동기방식
	.then(data => data.json())
	.then(result => {
		console.log(result.data);
		centerAry = result.data;  //[{}, {}, ...{}] =총 데이터 284개있음

		//시,도를 담는 배열선언
		let sidoAry = [];

		// tr > td*2 형태로 만들어줌
		//#centerList
		//배열의 메소드중에  [].forEach(function(elem, idx, ary){        })
		centerAry.forEach((center, idx) => {
			//sidoAry에 시,도 를 중복하지 않고 담기
			if (sidoAry.indexOf(center.sido) == -1) {
				sidoAry.push(center.sido);  // push는 값이 없을때 값을 추가
			}
			if (idx < 10) {
				// tr생성하기
				let tr = makeRow(center);
				document.querySelector('#centerList').appendChild(tr);  // html에서 centerList를 불러옴
			} // end of if
		}); // end of for.
		console.log(sidoAry);
		//sidoAry의 갯수만큼 <option value="sido정보"</option>
		sidoAry.forEach(sido => {
			let opt = document.createElement('option');  // <option></option>
			opt.value = sido;
			opt.innerText = sido;
			document.getElementById('sido').appendChild(opt);  // elementId의 sido는 indexHTML의 아이디임
		})
	})
	.catch(err => console.log(err))

// 조회버튼event
document.querySelector('button.btn-primary').addEventListener('click', function() {
	//목록지우기
	document.querySelector('#centerList').innerHTML = "";  //clear

	let keyword = document.getElementById('centerName').value;  // 사용자가 입력했던 검색값

	centerAry // 배열
		//.filter(center =>  center.centerName.indexOf(keyword) != -1)  // filter메소드는 배열을 반환 
		.filter(center => center.centerName.includes(keyword))  // 배열
		.forEach(center => {
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);
		})

});  // end of addListener

//select태그의 change이벤트
document.querySelector('#sido').addEventListener('change', function(e) {
	//목록지우기
	document.querySelector('#centerList').innerHTML = "";  //clear

	let keyword = document.getElementById('sido').value;  // 사용자가 입력했던 검색값

	centerAry // 배열
	.reduce((acc, center) => {
		if(center.sido == keyword) {
			let tr = makeRow(center);
			acc.appendChild(tr);
		}
		return acc;  // 다음순번의 acc값으로 반환
	}, document.querySelector('#centerList'));
	
		//.filter(center => center.sido == keyword)  // 배열
		//.forEach(center => {
		//let tr = makeRow(center);
		//document.querySelector('#centerList').appendChild(tr);
		//})
});

// []push(), [].unshift(), [].pop(), [].shift() => [].splice()  특정 위치에 추가, 수정, 삭제까지 다 가능 초강력!
//reduce();
let result = [1, 3, 5, 7].reduce(function(acc, elem, inx, ary) { //acc: 누산값
	console.log(acc, elem);
	if(elem>4) {
		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);
	}
	return acc;  // 이번순번에서 리턴된값이 다음 순번의 누산값(acc)으로 사용 
	// }, 뒤가 초기값-> ex) 0 1 => 1(acc) 3 => 3(acc) 5 => 5(acc) 7 순으로 누산값이 사용된다 
}, document.querySelector('#target')); // 초기값이 뭐냐에 따라 값이 다양하게 나올수 있음
console.log('결과: ', result);
