// 모듈을 추출합니다.
// npm install body-parser
var http = require('http');
var express = require('express');
// post 요청된 데이터를 파싱처리 해준다.
var bodyParser = require("body-parser");

// 서버를 생성합니다.
var app = express();

app.use(bodyParser.json());                       // JSON 데이터 처리 
app.use(bodyParser.urlencoded({extended:true}));  // POST 데이터 처리

// 경로설정
app.get('/', function (request, response) {
  console.log("최초 메인호출 페이지 작성");
});

app.get('/board/list.do', function (request, response) {
  console.log("list 관련 페이지 작성");
});

app.get('/board/writeForm.do', function (request, response) {
  console.log("writeForm 관련 페이지 작성");
});

app.post('/board/write.do', function (request, response) {
  console.log("write 관련 페이지 작성");
});

// 서버를 실행합니다.
http.createServer(app).listen(10001, function () {
    console.log('Server running at http://127.0.0.1:10001');
});
