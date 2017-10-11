package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test05 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1단계. 드라이버 로딩
			// 오라클 드라이버 클래스명 : 오라클 제공
			// ojdbc14.jar 에 포함된 클래스명(패키지 포함)
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			// 2단계. 연결객체 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			con = DriverManager.getConnection(url, "hr", "hr");
			// 3단계 : SQL 문 작성하기
			String sql = "insert into tb_board(no,title,writer,content) " 
			           + "values(s_board_no.nextval, ?, ?, ?)";

			// 4단계 : SQL 실행 객체 얻기
			pstmt = con.prepareStatement(sql);
			
			// ?에 값을 설정하기 : 실행하기 전에...
			pstmt.setString(1, "연습중..");
			pstmt.setString(2, "홍길동");
			pstmt.setString(3, "정말 연습중..");
			
			// 5단계 : SQL 실행하기
			int i = pstmt.executeUpdate();
			
			// 6단계 : 결과 처리
			System.out.println(i + "행이 추가");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7단계 : 객체 닫기
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
