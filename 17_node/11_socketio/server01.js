//  npm install socket.io

var http = require("http");
var fs   = require("fs");
var io   = require("socket.io");

var server = http.createServer(function(request, response) {
	fs.readFile("server01.html", function(err, data) {
		response.writeHead(200, {"Content-Type": "text/html; charset=UTF-8"});
		response.end(data);
	});
})
.listen(10001, function () {
  console.log("서버 구동 시작...");
});

// 소켓 IO 객체 생성 및 구동
var socketIo = io.listen(server);

socketIo.sockets.on("connection", function (socket) {
  console.log("사용자 소켓 IO 접속됨...");
});










