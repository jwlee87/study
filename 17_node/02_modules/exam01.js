/**
 * request 외부 모듈
 * 
 * 다운로드 해야 한다.
 * npm install request
 */
var request = require("request");
request("http://www.daum.net", function (error, response, body) {
	if (error || response.statusCode !== 200) {
		console.log("요청시 에러발생");
	} else {
		console.log(body);
	}
});