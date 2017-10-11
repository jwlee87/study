var http = require("http");

// 서버 생성
// createServer(function - 서버 요청시에 자동 호출되는 함수)
var server = http.createServer(function(request, response) {
	response.writeHead(200, {"Content-Type": "text/html; charset=UTF-8"});
	
	response.write("<h1>화면에 데이터 보내기</h1>");
	response.write("<h1>노드를 이용한 출력</h1>");
	
	response.end("<h1>Hello!! 노드~~");
});

server.listen(10001, function() {
	console.log("10001번 포트로 서버 구동중...");
});