/*
	// 사용할 모듈 정리
	1. http (웹 서버 기능) 
	2. fs (파일 내용 읽기)
	3. mysql (데이터베이스 접근)
	4. querystring (파라미터 처리)
	5. ejs (목록 화면 처리)
	
	게시판 기능중에서 등록폼, 등록, 목록 
	
	/writeForm.do 일 경우 writeForm.html 파일의 내용을 읽어서 
	사용자에게 전송
	
	/write.do 일 경우 넘어온 파라미터 값을 얻어온 다음 데이터베이스에
	입력
	
	등록된 다음 자동으로 /list.do 경로를 호출
	
	/list.do 일 경우 데이터베이스의 게시물 내용을 조회한 다음 
	사용자 화면으로 결과를 넘겨준다.
 */
var http = require("http");
var fs = require("fs");
var mysql = require("mysql");
var qs = require("querystring");
var ejs = require("ejs");

http.createServer(function(request, response) {
	console.log(request.url);
	switch (request.url) {
	case "/writeForm.do":
		writeForm(response);	
		break;
	case "/write.do":
		write(request, response);	
		break;
	case "/list.do":
		list(response);	
		break;
	}
})
.listen(10001, function() {
	console.log("10001 서버 구동중");
});

var con = mysql.createConnection({
	host: "localhost",
	port: 3306,
	user: "root",
	password: "admin",
	database: "bitlec"
});

function list(response) {
	var sql = "select no, title, writer " +
			  "  from tb_board         " +
			  " order by no desc        ";
	con.query(sql, function (err, rows, fields) {
		// 에러가 존재할 경우
		if (err) {
			console.log("쿼리 실행시 오류 발생");
			console.log(err);
			return;
		}
	    fs.readFile("list.ejs", "utf-8", function (error, data) {
	        response.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
	        response.write(ejs.render(data, {"rows": rows}));
	        response.end();
	    });
	});
}
function write(request, response) {
	var pData = "";
	request.on("data", function (data) {
		pData += data;
	});
	
	request.on("end", function () {
		var param = qs.parse(pData);
		// db 작업
		var sql = "insert into tb_board(writer, title, content) values(?, ?, ?) ";
		con.query(
				sql, 
				[param.writer, param.title, param.content], 
				function (err, result) {
					if (err) {
						console.log("등록 중 오류 발생");
						console.log(err);
						return;
					}
					response.writeHead(302, {"Location": "list.do"});
					response.end();
				}
		);
		
	});
}

function writeForm(response) {
	fs.readFile("writeForm.html", "utf-8", function(err, data) {
		// 오류에 대한 처리 코드 추가 가능
		// ....
		response.writeHead(
				200, 
				{"Content-Type": "text/html; charset=utf-8"}
		);
		response.end(data);	
	});	
}













