package kdata.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentManager mg = new StudentManager();
		SugangManager sm = new SugangManager();
		Scanner sc = new Scanner(System.in);
		//학생 객체 생성
		while(true){
			System.out.println("input 1 to add Student Info");
			System.out.println("input 2 to print Student Info");
			System.out.println("input 3 to search Student Info");
			System.out.println("input 4 to add Sugang Info");
			System.out.println("input 5 to print Sugang Info");
			System.out.println("input 6 to update grade");
			
			int input = sc.nextInt();
			
			// 1번 학생 정보 추가
			if(input == 1){
				int idLength;
				
				sc.nextLine();
				System.out.println("input Student ID");
				String StudentID = sc.nextLine();
				idLength = StudentID.length();
				if(idLength != 7) {
					System.out.println("7자리학번을 입력해주세요.");
					continue;
				}
					
				System.out.println("input Student Name");
				String StudentName = sc.nextLine();
				System.out.println("input Student's gender");
				String Gender = sc.nextLine();
				if(!(Gender.equals("M") || Gender.equals("F") || Gender.equals("m") || Gender.equals("f"))){
					System.out.println("'M' 또는 'F' 또는 'm' 또는 'f'를 입력하세요");
					continue;
				}
					
				//학생 객체 생성
				Student s = new Student(StudentID, StudentName, Gender);
				int result =0;
				//학생 객체 추가
				try {
					result = mg.insert(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result == 0) {
					System.out.println("삽입 실패");
				}else
					System.out.println("삽입 성공");
			// 2번 학생 리스트 출력
			}
			if(input ==2) {
				List<Student> list = new ArrayList<>();
				try {
					list = mg.selectAll();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i< list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
			
			// 3번 학생 이름 검색
			if(input == 3) {
				System.out.println("검색하고 싶은 학생이름을 입력하세요");
				
				//엔터키 버퍼 비우기
				sc.nextLine();
				String name = sc.nextLine();
				try {
					System.out.println(mg.selectByName(name));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// 4번 수강 신청 
			if(input == 4) {
				int idLength;
				//버퍼 비우기
				sc.nextLine();
				// 학번 입력
				System.out.println("input Student ID");
				String StudentID = sc.nextLine();
				idLength = StudentID.length();
				if(idLength != 7) {
					System.out.println("7자리학번을 입력해주세요.");
					continue;
				}
				// 과목코드 입력
				System.out.println("input Subject code");
				String SubCode = sc.nextLine();
				
				//수강 객체 생성
				Sugang sg = new Sugang(StudentID, SubCode, 0);
				int result =0;
				//수강 객체 추가
				try {
					result = sm.insertSugang(sg);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result == 0) {
					System.out.println("삽입 실패");
				}else
					System.out.println("삽입 성공");
				
			}
			// 5번 수강 리스트 출력
			if(input == 5) {
				List<Sugang> list = new ArrayList<>();
				try {
					list =  sm.selectSugang();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0; i< list.size(); i++) {
					System.out.println(list.get(i));
				}
			}
			// 6번 성적 업데이트
			if(input == 6) {
				int idLength;
				//버퍼 비우기
				sc.nextLine();
				// 학번 입력
				System.out.println("input Student ID");
				String StudentID = sc.nextLine();
				idLength = StudentID.length();
				if(idLength != 7) {
					System.out.println("7자리학번을 입력해주세요.");
					continue;
				}
				// 과목코드 입력
				System.out.println("input Subject code");
				String SubCode = sc.nextLine();
				
				// 업데이트할 성적 입력
				System.out.println("input Grade");
				int Grade = sc.nextInt();
				
				//수강 객체 생성
				Sugang sg = new Sugang(StudentID, SubCode, Grade);
				int result =0;
				//수강 객체 추가
				try {
					result = sm.updateGrade(sg);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(result == 0) {
					System.out.println("업데이트 실패");
				}else
					System.out.println("업데이트 성공");
			}
		}	
	}
}
