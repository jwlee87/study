// 모듈을 추출합니다.
var http = require('http');
var express = require('express');

// 서버를 생성합니다.
var app = express();

// 미들웨어를 설정합니다.
// express 미들웨어 모듈 적용
// 웹서버의 루트로 사용할 정적 위치 지정
app.use(express.static('public'));
app.use(function (request, response) {
    // 응답합니다.
    response.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
    response.write("<h1>정적 위치 접근</h1>");
    // 해당 자원을 정적 루트로 지정된 위치에서 찾는다.
    response.write('<img src="/images/pic1.jpg" width="400" height="300" />');
    response.end();
});

// 서버를 실행합니다.
http.createServer(app).listen(10001, function () {
    console.log('Server running at http://127.0.0.1:10001');
});
