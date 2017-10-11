var http = require("http");
var fs = require("fs");
// POST 방식으로 들어온 파라미터를 파싱하기 위해서 
var qs = require("querystring");

http.createServer(function(request, response) {
	if (request.method === "GET") {
		fs.readFile("data/form.html", function(err, data) {
			response.writeHead(200, {"Content-Type": "text/html; charset=UTF-8"});
			response.end(data);
		});
	} 
	else if(request.method === "POST") {
		console.log("POST 방식으로 요청왔음");
		// POST 방식일 경우 파라미터 처리
		// 이벤트 : data(파라미터 읽는 동안 발생), 
		//          end(body의 파라미터 내용을 다 읽은다음 호출) 이용해서 처리한다.
		/*
		request.emit("data", "aaaa");
		request.emit("data", "bbbb");
		*/
		var pData = "";
		request.on("data", function (data) {
			pData += data;
		});
		
		request.on("end", function () {
			console.log("pData : " + pData);
			var param = qs.parse(pData);
			response.writeHead(200, {"Content-Type": "text/html; charset=UTF-8"});
			response.write("<h1>" + param.jumin1 + "</h1>");
			response.write("<h1>" + param.jumin2 + "</h1>");
			response.end();
		});
	} 
})
.listen(10001, function() {
	console.log("10001번 구동중입니다.");
});











