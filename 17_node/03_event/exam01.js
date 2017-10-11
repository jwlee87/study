/**
 * 이벤트를 연결할 수 있는 모든 객체는 EventEmitter 객체의 상속을 받는다.
 * 사용자가 이벤트를 정의 하려면 EventEmitter 객체를 이용한다.
 * 
 * on   : 이벤트 설정
 * emit : 이벤트 호출
 */
var EventEmitter = require("events").EventEmitter;
var util = require("util");

// member 객체 
var Member = function() {};

// 상속 처리
util.inherits(Member, EventEmitter);

Member.prototype.join = function () {
	// join 이벤트 발생
	this.emit("join", "tester", "테스터");
};

Member.prototype.list = function () {
	// list 이벤트 발생
	this.emit("list");
};

// 이벤트 등록
var mem = new Member();
mem.on("join", function (id, name) {
	console.log("id : %s, name : %s 환영~~", id, name);
});
mem.on("list", function () {
	console.log("list 이벤트 발생");
});

mem.join();
mem.list();





