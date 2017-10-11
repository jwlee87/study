var http = require("http");
var fs = require("fs");

http.createServer(function(request, response) {
	fs.readFile("data/test.html", function (err, data) {
		response.writeHead(200, {"Content-Type": "text/html; charset=UTF-8"});
		response.end(data);
	});
}).listen(10001, function() {console.log("10001 구동");});

http.createServer(function(request, response) {
	fs.readFile("data/test.jpg", function (err, data) {
		response.writeHead(200, {"Content-Type": "image/jpeg"});
		response.end(data);
	});
}).listen(10002, function() { console.log("10002 구동"); });

http.createServer(function(request, response) {
	fs.readFile("data/test.mp3", function (err, data) {
		response.writeHead(200, {"Content-Type": "audio/mp3"});
		response.end(data);
	});
}).listen(10003, function() {console.log("10003 구동"); });






