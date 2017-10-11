// 전역변수 : 현재 작업 디렉토리
console.log("__dirname : " + __dirname);

// 전역변수 : 현재 작업 파일
console.log("__filename : " + __filename);

var msg = "Hello, NodeJS";
var person = {
	"name": "노드",
	"age": 12,
	"addr": "비트컴퓨터"
};
// %s -> string
console.log("%s!!", msg);
// %j -> json
console.log("%j", person);
// %d -> number
console.log("%d", person.age)

// long s = System.currentTimeMillis();
console.time('100-elements');
for (var i = 0; i < 10000000; i++) {
  ;
}
console.timeEnd('100-elements');







