/**
 * http 모듈을 이용한 서버 통신 방식
 */
var http = require("http");

// 서버 생성
var server = http.createServer();

// 구동된 서버에 이벤트 연결 : on
server.on("request", function() {
	console.log("사용자 요청옴...");
});

server.listen(10001, function() {
	console.log("10001번 포트로 구동중...");
});








