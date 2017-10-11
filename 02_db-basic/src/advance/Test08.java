package advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test08 {
	public static void main(String[] args) {
		// 조회된 결과값을 저장하기 위한 리스트 선언
		List<EmployeesVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			String sql = "select employee_id, last_name, salary " + " from employees " + " order by last_name ";
			pstmt = con.prepareStatement(sql);
			// 실행하기
			ResultSet rs = pstmt.executeQuery();
			// 조회된 데이터 접근하기
			while (rs.next()) {
				EmployeesVO vo = new EmployeesVO();
				vo.setEmployeeId(rs.getInt("Employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getInt("Salary"));
				list.add(vo);
			}

			for (EmployeesVO vo : list) {
				System.out.printf("%4d%12s%6d\n", vo.getEmployeeId(), vo.getLastName(), vo.getSalary());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
