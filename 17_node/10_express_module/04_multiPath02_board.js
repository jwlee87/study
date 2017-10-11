// 모듈을 추출합니다.
var http = require('http');
var express = require('express');
var fs = require("fs");
var bodyParser = require("body-parser");
var ejs = require("ejs");
var mysql = require("mysql");

// 서버를 생성합니다.
var app = express();

var con = mysql.createConnection({
  host : 'localhost',
  port : 3306,
  user : 'root',
  password : 'admin',
  database : 'bitlec'
});

app.use(bodyParser.json());                       // JSON 데이터 처리 
app.use(bodyParser.urlencoded({extended:true}));  // POST 데이터 처리

// 경로설정
app.get('/', function (request, response) {
  fs.readFile("views/index.html", function(err, data) {
    response.writeHeader(200, {"Content-Type": "text/html; charset=UTF-8"});
    response.end(data);
  });
});

app.get('/board/list.do', function (request, response) {
  list(request, response);
});

function list(request, response) {
  
  // 파라미터 처리
  console.log(request.query.pageNo);
  
  var pageNo = request.query.pageNo;
  
  if (!pageNo) { pageNo = 1; }
  
  // 데이터베이스 조회 후 적용 필요
  // limit 시작위치, 가져올 갯수
  var sql = "select no, title, writer " +
            "  from tb_board " +
            " order by no desc " +
            " limit ?, 10";

  con.query(sql, [(pageNo - 1) * 10], function(err, rows, fields) {
    // 에러발생시
    if (err) {
      console.log("쿼리 실행시 오류 발생함..");
      console.log(err);
      return;
    }

    fs.readFile("views/board/list.ejs", "utf-8", function (error, data) {
      var result = ejs.render(data, {"rows": rows});
      console.log(result);
      response.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
      response.write(result);
      response.end();
    });
  });
}

app.get('/board/writeForm.do', function (request, response) {
  fs.readFile("views/board/writeForm.html", function(err, data) {
    response.writeHeader(200, {"Content-Type": "text/html; charset=UTF-8"});
    response.end(data);
  });
});

app.post('/board/write.do', function (request, response) {
  write(request, response);
});

function write(request, response) {
  
  // POST 요청
  // body-parser 설정후에나 가능함
  // 설정하지 않은 상태에서 사용할 경우 오류 발생
  // : Cannot read property 'no' of undefined
  console.log(request.body.no);
  console.log(request.body.title);
  
  var sql = "insert into tb_board(writer, title, content) values(?, ?, ?)";

  con.query(sql, [request.body.writer, request.body.title, request.body.content], function(err, result) {
   
    // 에러발생시
    if (err) {
      console.log("쿼리 실행시 오류 발생함..");
      console.log(err);
      return;
    }
    response.redirect('/board/list.do');
  });
}

// 서버를 실행합니다.
http.createServer(app).listen(10001, function () {
    console.log('Server running at http://127.0.0.1:10001');
});















