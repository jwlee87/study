// ejs : 화면 처리 템플릿
// 외부모듈 : npm install ejs
var http = require("http");
var fs = require("fs");
var ejs = require("ejs");

http.createServer(function(request, response) {
	fs.readFile("exam02.ejs", "utf-8", function(err, data) {
		var result = ejs.render(
				data, 
				{
					"title": "노드 게시판",
					"data": [2, 4, 6, 8]
				}
		);
		response.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
		response.write(result);
		response.end();
	});
})
.listen(10001, function() {
	console.log("서버 구동중입니다...");
});







