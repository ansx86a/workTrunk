package bean.orika;

import java.util.List;

public class OtherPerson {

	private String otherFirstName;
	private String otherLastName;
	private String address;
	private Integer age;
	private List<String> otherSkill;

	public OtherPerson() {

	}

	public OtherPerson(String otherFirstName, String otherLastName, int age) {
		super();
		this.otherFirstName = otherFirstName;
		this.otherLastName = otherLastName;
		this.age = age;
	}

	public String getOtherFirstName() {
		return otherFirstName;
	}

	public void setOtherFirstName(String otherFirstName) {
		this.otherFirstName = otherFirstName;
	}

	public String getOtherLastName() {
		return otherLastName;
	}

	public void setOtherLastName(String otherLastName) {
		this.otherLastName = otherLastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<String> getOtherSkill() {
		return otherSkill;
	}

	public void setOtherSkill(List<String> otherSkill) {
		this.otherSkill = otherSkill;
	}

}
