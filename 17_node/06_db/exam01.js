// mysql 모듈 접근
// npm install mysql

var mysql = require("mysql");

var con = mysql.createConnection({
	host: "localhost",
	port: 3306,
	user: "root",
	password: "admin",
	database: "bitlec"
});

var sql = "select no, title, writer " +
		  "  from tb_board " +
		  " order by no desc";

con.query(sql, function (err, rows, fields) {
	// 에러가 존재할 경우
	if (err) {
		console.log("쿼리 실행시 오류 발생");
		console.log(err);
		con.end();
		return;
	}
//	console.dir(fields);
	console.log("실행된 결과");
//	console.dir(rows);
	
	rows.forEach(function (row, i) {
		console.log(
			i + " : " + row.no + ", " + row.title + ", " + row.writer);
	});
	con.end();
});









