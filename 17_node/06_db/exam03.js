// mysql 모듈 접근
var mysql = require("mysql");

var con = mysql.createConnection({
	host: "localhost",
	port: 3306,
	user: "root",
	password: "admin",
	database: "bitlec"
});

var sql = "insert into tb_board(writer, title, content) " +
		  "values(?, ?, ?)                               ";
con.query(
		sql, 
		['test1234', 'node insert', 'success'], 
		function (err, result) {
			if (err) {
				console.log("등록 중 오류 발생");
				console.log(err);
				con.end();
				return;
			}
			console.log("등록이 성공했습니다.");
			con.end();
		}
);










