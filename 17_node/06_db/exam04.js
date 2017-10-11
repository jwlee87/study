// 4번 게시물 삭제하기
var mysql = require("mysql");

var con = mysql.createConnection({
	host: "localhost",
	port: 3306,
	user: "root",
	password: "admin",
	database: "bitlec"
});

var sql = "delete from tb_board where no = ? ";
con.query(
		sql, [4],
		function (err, result) {
			if (err) {
				console.log("삭제 중 오류 발생");
				console.log(err);
				con.end();
				return;
			}
			console.log("삭제가 성공했습니다.");
			con.end();
		}
);