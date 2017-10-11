package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;

public class Test01 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionFactory.getConnection();
			// 3단계 : SQL 문 작성하기
			String sql = "insert into tb_board(no,title,writer,content) " 
			           + "values(s_board_no.nextval,'a1','a2','a3')";

			// 4단계 : SQL 실행 객체 얻기
			pstmt = con.prepareStatement(sql);
			// 5단계 : SQL 실행하기
			int i = pstmt.executeUpdate();
			// 6단계 : 결과 처리
			System.out.println("행이추가됬어용");
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
