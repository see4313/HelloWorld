/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: './images/basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2, 
	image: './images/basket1.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: './images/basket1.jpg'
}]

let cont = document.getElementById('basket');

//상품목록 출력하기
cartItems.forEach(function(e) { 
	str = `<div class="row data" data-id=${e.itemId}>
	               <div class="subdiv">
	                   <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
	                   <div class="img"><img src=${e.image} width="60"></div>
	                   <div class="pname"> <span>${e.itemName}-${e.itemId}</span> </div>
	               </div>
	               <div class="subdiv">
	                   <div class="basketprice">
	                       <input type="hidden" name="p_price" id="p_price${e.itemId}" class="p_price" value="${e.price}"> ${e.price}원</div>
	                   <div class="num">
	                       <div class="updown">
	                           <input type="text" name="p_num1" id="p_num${e.itemId}" size="2" maxlength="4" class="p_num" value=${e.qty}
	                               onkeyup="javascript:basket.changePNum(event);">
	                           <span onclick="javascript:basket.changePNum(event);">
	                               <i class="fas fa-arrow-alt-circle-up up"></i> </span>
	                           <span onclick="javascript:basket.changePNum(event);">
	                               <i class="fas fa-arrow-alt-circle-down down"></i> </span>
	                       </div>
	                   </div>
	                   <div class="sum">${e.price * e.qty}원</div>
	               </div>
	               <div class="subdiv">
	                   <div class="basketcmd">
	                       <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(event);">삭제</a>
	                   </div>
	               </div>
	           </div>`;
	console.log(str);
	cont.insertAdjacentHTML("beforeend", str);  // <div>~</div>의 덩어리를 beforeend(마지막)에 추가해줌 // forEach안에 있으니까 배열만큼 반복해줌.
})


// basket 객체와 메소드
const basket = {
	// 장바구니 수량 변경.
	changePNum(e) {
		let elem = e.target;  // 이벤트대상찾기
		let subdiv = elem.closest('div.subdiv'); // elem의 부모요소에서 <div class="subdiv"></div> 찾기.
		let inputElem = subdiv.querySelector('input[name="p_num1"]');  // 하위요소중에서 <input name="p_num1">을 찾아서...
		let currentQty = parseInt(inputElem.value);  // 현재수량
		console.log(currentQty);
		let itemPrice = subdiv.querySelector('input[name="p_price"]').value;  // 가격
		
		// icon의 up/down을 나눠서 처리
		if (elem.classList.contains('up') || e.key == 'ArrowUp') { //수량증가  // elem.classList.contains('up') = 위로모양의 버튼을 눌렀을떄 
					currentQty++;
				} else if (elem.classList.contains('down') || e.key == 'ArrowDown') { //수량감소  // e.key == 'ArrowDown' = 키보드 방향키를 위로 눌렀을떄
					if (!(currentQty - 1)) { // 최소수량은 1로 정하자.
						return;
					}
					currentQty--;
				}
				inputElem.value = currentQty;
				subdiv.querySelector('div.sum').innerText = currentQty * itemPrice + "원";
				
				// 합계결과.
				this.allItem();

	},
	// 상품삭제.
	delItem(e) {
		e.target.closest('div.data').remove(); // closet: 클래스(.)이름이 data인 div를 찾는것 // 하나위가 아닌 위에 있는 부모 요소는 다 찾는것
		this.allItem();
	},
	// 선택상품삭제.
	delCheckedItem() {
		document.querySelectorAll('input[name="buy"]').forEach(item => {
			if (item.checked) {
				item.closest('div.data').remove();
			}
		});
		//합계결과
		this.allItem();  // 전체금액과 전체 수량이 바뀌기때문에 다시 한번 담아줘야됨. 

	},
	// 장바구니 비우기.
	delAllItem() {
		document.querySelectorAll('input[name="buy"]').forEach(item => item.closest('div.data').remove());
		//합계결과
		this.allItem();
	},
	
	// 전체수량과 금액을 계산해서 보여주기
	allItem() {
		// 전체수량출력, 합계금액 출력
		let sumQty = 0, sumPrice = 0;
		document.querySelectorAll('div.data input[name="p_num1"]').forEach(item => {
			sumQty += parseInt(item.value);
		})
		document.querySelectorAll('div.data div.sum').forEach(item => {
			sumPrice += parseInt(item.innerText.substring(0,item.innerText.length -1));
		})
		document.querySelector('div.sumcount>span').innerText = sumQty;
		document.querySelector('div.summoney>span').innerText = sumPrice;
		
	}
}

// 화면 출력시 합계정보를 보여주기 위해서 call
 basket.allItem();  // 페이지가 최초실행될떄 떠야하니 호출