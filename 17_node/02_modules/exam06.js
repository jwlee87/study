/**
 * fs : 파일을 읽거나 쓰거나 할때 사용함
 * Sync가 붙은 함수는 동기적 읽기, 붙지 않은 함수는 비동기적 읽기
 */
var fs = require("fs");

fs.readFile("test.txt", "utf-8", function(err, data) {
	console.log("비동기 읽은 데이터");
	console.log(data);
});
console.log("비동기 파일 읽기 호출 후.....");

var result = fs.readFileSync("test.txt", "utf-8");
console.log("동기 파일 읽기 호출 후.....");
console.log(result);







