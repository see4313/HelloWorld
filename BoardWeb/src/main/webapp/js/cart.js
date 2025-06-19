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


cartItems.forEach(function(e){
 str = `<div class="row data" data-id=${e.itemId}>
	               <div class="subdiv">
	                   <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
	                   <div class="img"><img src=${e.image} width="60"></div>
	                   <div class="pname"> <span>${e.itemName }</span> </div>
	               </div>
	               <div class="subdiv">
	                   <div class="basketprice">
	                       <input type="hidden" name="p_price" id="p_price1" class="p_price" value="${e.price}"> ${e.price}</div>
	                   <div class="num">
	                       <div class="updown">
	                           <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value="1"
	                               onkeyup="javascript:basket.changePNum(event);">
	                           <span onclick="javascript:basket.changePNum(event);">
	                               <i class="fas fa-arrow-alt-circle-up up"></i> </span>
	                           <span onclick="javascript:basket.changePNum(event);">
	                               <i class="fas fa-arrow-alt-circle-down down"></i> </span>
	                       </div>
	                   </div>
	                   <div class="sum">&{합산가격}</div>
	               </div>
	               <div class="subdiv">
	                   <div class="basketcmd">
	                       <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a>
	                   </div>
	               </div>
	           </div>`;
			   console.log(str);
cont.insertAdjacentHTML("beforeend", str);
})






const basket = {
	// 장바구니 수량 변경.
	changePNum(e) {
		let sum = e.target;
		
	},
	// 상품삭제.
	delItem() {
		
	},
	// 선택상품삭제.
	delCheckedItem(e) {
	

	},
	// 장바구니 비우기.
	delAllItem() {

	}
	
	
}