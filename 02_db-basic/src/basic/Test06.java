package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test06 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1단계 : 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2단계 : 
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// 3단계 : 
			String sql = "update tb_board "
					   + "   set title = ? "
					   + " where no = ? ";
			// 4단계 : 
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "수정 제목");
			pstmt.setInt(2, 13);
			
			// 5단계 : 
			int cnt = pstmt.executeUpdate();
			// 6단계 : 
			System.out.println(cnt + "개의 행이 변경되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 7단계 : 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}














