package advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test06 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			// 3단계 : 
			String sql = "update tb_board set title='연습중..' where no = 11 ";
			// 4단계 : 
			pstmt = con.prepareStatement(sql);
			// 5단계 : 
			int cnt = pstmt.executeUpdate();
			// 6단계 : 
			System.out.println(cnt + "개의 행이 변경되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}














