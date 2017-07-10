package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SugangManager {
// 수강신청 학번, 과목코드, 성적, 신청일 입력
	
	public int insertSugang(Sugang s) throws SQLException {
		//이 연결 객체를 이 기능만 쓰고 버리겠다
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
		//2. DB서버 연결
		con = DBUtil.getConnection();
		String sql = "insert into class (studentID, SubCode, grade)"
				+ "values(?,?,'0')";
		
		
		// 3. Statement 객체 생성
		pstmt = con.prepareStatement(sql);
		
		// 물음표 채우기
		pstmt.setString(1, s.getStuId());
		pstmt.setString(2, s.getSubCode());
					
					
		// 4. SQL문 전송
		result = pstmt.executeUpdate();
		
		
		}finally {
			DBUtil.close(con, pstmt);	
		}
		return result;
	}
// 수강신청 취소

	// 성적주기
	public int updateGrade(Sugang s) throws SQLException {
		//이 연결 객체를 이 기능만 쓰고 버리겠다
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
		//2. DB서버 연결
		con = DBUtil.getConnection();
		String sql = "update class set grade = ? "
				+ "where trim(studentid) = ? and trim(subcode) = ?";
		
		System.out.println(s);
		// 3. Statement 객체 생성
		pstmt = con.prepareStatement(sql);
		
		// 물음표 채우기
		pstmt.setInt(1, s.getGrade());
		pstmt.setString(2, s.getStuId());
		pstmt.setString(3, s.getSubCode());
		
				
		// 4. SQL문 전송
		result = pstmt.executeUpdate();
		
		
		}finally {
			DBUtil.close(con, pstmt);	
		}
		return result;
	}
	// 수강 리스트 출력
	
		public List<Sugang> selectSugang() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Sugang> list = new ArrayList<>();
			
			try {
				con = DBUtil.getConnection();
				String sql = "select * from class";
				//3. Statement 객체 생성
				pstmt = con.prepareStatement(sql);
					
					// 4. SQL문 전송
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Sugang sg = new Sugang(rs.getString("studentid"),
					rs.getString("subcode"),
					rs.getInt(3),
					rs.getDate(4));
					list.add(sg);
				}
				
			}finally {
				DBUtil.close(con, pstmt, rs);
			}
			return list; 
		}
		
}
