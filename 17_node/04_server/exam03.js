/**
 * http://localhost:10001/test.do?id=aaa&name=bbb
 */
var http = require("http");
var url = require("url");

var server = http.createServer(function(request, response) {
	var urlObj = url.parse(request.url, true);
	console.log("id : " + urlObj.query.id);
	console.log("name : " + urlObj.query.name);
	
	// 호출한 사용자 브라우져로 아래와 같은 형식으로 데이터 출력
	/*
	 *  uri : /test.do
	 *  id : aaa
	 *  name : bbb
	 */
	response.writeHead(200, {"Content-Type": "text/html; charset=UTF-8"});
	response.write("<h1>uri : " + urlObj.pathname + "</h1>");
	response.write("<h1>id : " + urlObj.query.id + "</h1>");
	response.write("<h1>name : " + urlObj.query.name + "</h1>");
	response.end();	
});
server.listen(10001, function() {
	console.log("10001번 으로 포트 구동중....");
});