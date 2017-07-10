package kdata.manager;

public class Student {
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", sName=" + sName + ", gender=" + gender + "]";
	}
	private String stuId;
	private String sName;
	private String gender;
	
	public String getStuId() {
		return stuId;
	}
	
	public Student(String stuId, String sName, String gender) {
		super();
		this.stuId = stuId;
		this.sName = sName;
		this.gender = gender;
	}
	
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getSName() {
		return sName;
	}
	public void setSName(String sName) {
		this.sName = sName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
