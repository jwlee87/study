/*
 *  10001번 포트만 생성
 *  
 *  사용자 요청 패스를 이용해서 응답처리한다.
 *  /html 일 경우 data/test.html
 *  /image 일 경우 data/test.jpg
 *  /audio 일 경우 data/test.mp3
 */
var http = require("http");
var fs = require("fs");
var url = require("url");

http.createServer(function(request, response) {
	var pathname = url.parse(request.url).pathname;
	var fName = "";
	var contentType = "";
	switch (pathname) {
	case "/html":
		fName = "test.html";
		contentType = "text/html; charset=UTF-8";
		break;
	case "/image":
		fName = "test.jpg";
		contentType = "image/jpeg";
		break;
	case "/audio":
		fName = "test.mp3";
		contentType = "audio/mp3";
		break;
	}
	fs.readFile("data/" + fName, function (err, data) {
		response.writeHead(200, {"Content-Type": contentType});
		response.end(data);
	});


}).listen(10001, function() {console.log("10001 구동");});
