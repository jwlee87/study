/**
 * url 모듈 : url 정보를 분석
 * 
 * 빌트인 모듈이기 때문에 따로 다운 받을 필요 없음
 */
var url = require("url");

var urlObj = url.parse(
		"http://localhost:10001/list.do?id=hong&name=홍길동", true); 
//		"http://localhost:10001/list.do?id=hong&name=홍길동", false); 

//console.dir(urlObj);
console.log("pathname : " + urlObj.pathname);
//console.log("query : " + urlObj.query);  // true(객체), false(문자열)
console.log("query id : " + urlObj.query.id);
console.log("query name : " + urlObj.query.name);












