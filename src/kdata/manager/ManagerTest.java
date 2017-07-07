package kdata.manager;

import java.sql.SQLException;
import java.util.Scanner;



public class ManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentManager mg = new StudentManager();
		Scanner sc = new Scanner(System.in);
		//학생 객체 생성
		while(true){
			System.out.println("input 1 to add Student Info");
			System.out.println("input 2 to print Student Info");
			System.out.println("input 3 to search Student Info");
			System.out.println("input 4 to exit");
			
			int input = sc.nextInt();
			
			// 1번 학생 정보 추가
			if(input == 1){
				sc.nextLine();
				System.out.println("input Student ID");
				String StudentID = sc.nextLine();
				System.out.println("input Student Name");
				String StudentName = sc.nextLine();
				System.out.println("input Student's gender");
				String Gender = sc.nextLine();
				
				//학생 객체 생성
				Student s = new Student(StudentID, StudentName, Gender);
				
				//학생 객체 추가
				try {
					int result = mg.insert(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			// 2번 학생 리스트 출력
			}
		}
		
		
		
	}

}
