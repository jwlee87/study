/*
 *  http://localhost:10001/writeForm.do
 *  호출하면
 *  board/writeForm.html 의 내용을 화면에 출력
 *  
 *  등록버튼 클릭 시
 *  사용자 화면에 사용자가 입력한 파라미터 정보를 출력한다.
 *  등록된 내용
	제목 : test
	글쓴이 : 1234
	내용 : aaaaa
 */

/**
 * http 모듈
 * 내장 모듈
 */

var http = require("http");
// url  파싱하기 위해 사용
var url = require("url");
// file 처리 위해서
var fs = require("fs");
// 파라미터 처리 모듈
var qs = require("querystring");

var server = http.createServer(function(request, response) {
	var urlObj = url.parse(request.url, true);  

	if (urlObj.pathname == "/writeForm.do") {
		fs.readFile("board/writeForm.html", function (error, data) {
			response.writeHead(200, 
					{"Content-Type": "text/html; charset=utf-8"});
			response.write(data);
			response.end();
		});
	}
	// write.do 에 대한 처리하는 코드 작성
	else if (urlObj.pathname == "/write.do") {
		//  post 방식일 경우 처리 방법
		var bodyData = "";
		// 데이터를 읽어 들일때 발생 이벤트
		request.on("data", function (data) {
			bodyData += data;
		});
		// end 이벤트 : post 방식일 경우
		//            : 바디의 데이터를 모두 읽었을때 발생
		request.on("end", function () {
			// title=aaa&writer=bbb&content=ccc
			var param = qs.parse(bodyData);
			
			response.writeHead(200, 
					{"Content-Type": "text/html; charset=utf-8"});
			response.write("<h1>등록된 내용</h1>");
			response.write("<h1>제목 : " + param.title + "</h1>");
			response.write("<h1>글쓴이 : " + param.writer + "</h1>");
			response.write("<h1>내용 : " + param.content + "</h1>");
			response.end();
		});
	}
});

server.listen(10001, function() {
	console.log("10001 번으로 구동중");
});















