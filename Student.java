package kdata;

//학생 정보만 저장하는 역할
public class Student implements Comparable<Student>{
	//학번
	private int num;
	//이름
	private String name;
	//주소
	private String address;
	//전화번호
	private String phone;
	
	private int kor;
	private int eng;
	private int math;
	
	public Student(int num, String name, String address, String phone, int kor, int eng, int math)
	{
		super();
		this.num = num;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

		public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getNum() {
		return num;
	}
	
	//학번	이름
	//---------
	//123      김충환
	

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", address=" + address + ", phone=" + phone + ", kor=" + kor
				+ ", eng=" + eng + ", math=" + math + "]";
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// 총점 구하는 것
	public int getTotal() {
		return this.kor + this.eng + this.math;
	}
	
	@Override
	public int compareTo(Student o) {
		
		return this.getName().compareTo(o.getName());
	}
	
}
