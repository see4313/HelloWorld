/**
 * covid_module.js
 */
const defaultNum = 10;
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=uNdr9wp2JAC%2FjxnP0xM%2FCLpAMljjsrAoIaemj6hTET8IEn0KJa5x0AoQuzYdD3HFwKHC6U7ZogmGO4OjhskyDA%3D%3D`;

function makeRow(center) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', function(e){
		window.open('map.jsp?lat=' + center.lat + '&lng=' + center.lng + '&centerName=' + center.centerName);   //지도가 가지고있는 위도 경도
	})
	for (const prop of ['id', 'centerName', 'phoneNumber']) {
		let td = document.createElement('td'); // <td></td>
		td.innerHTML = center[prop];  //==center['id']  //<td>1</td>
		tr.appendChild(td);
	}
	return tr;
}

export{makeRow, url} // export 내보내다 (내보내고싶은 것만 작성해주면됨)