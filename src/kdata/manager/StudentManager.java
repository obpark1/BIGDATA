package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

	//학생 테이블 관리하는 클래
	public class StudentManager {
	// 학생 정보 추가
		public static int insert(Student s) throws SQLException {
			//이 연결 객체를 이 기능만 쓰고 버리겠다
			Connection con = null;
			PreparedStatement pstmt = null;
			int result=0;
			try {
			//2. DB서버 연결
			con = DBUtil.getConnection();
			String sql = "insert into student values(?,?,?)";
			
			
			// 3. Statement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getStuId());
			pstmt.setString(2, s.getSName());
			pstmt.setString(3, s.getGender());
						
						
			// 4. SQL문 전송
			result = pstmt.executeUpdate();
			}finally {
				DBUtil.close(con, pstmt);
				return result;
			}
			
		}
		public void selectAll() {
			Connection con;
		}
}
