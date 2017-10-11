var fs = require("fs");

var msg = "테스트 입니다.";

fs.writeFile("backup.txt", msg, "utf-8", function(error) {
	if (error) {
		console.log("파일 쓰기중 오류 발생");
		console.log(error);
	} 
	else {
		console.log("비동기 방식 파일 쓰기 성공");
	}
});

fs.writeFileSync("backup2.txt", msg, "utf-8");
console.log("동기 파일 저장 성공");