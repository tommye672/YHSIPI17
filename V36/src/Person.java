
public class Person {
	private String fName,lName;
	private int age;
	
	public Person(String fName, String lName, int age) {
		this.fName = fName;
		this.lName = lName;
		this.age = age < 0 ? 0 : age;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return fName +" "+ lName + ": age "+ age;
	}
}
