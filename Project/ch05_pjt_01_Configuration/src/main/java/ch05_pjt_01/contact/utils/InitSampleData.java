package ch05_pjt_01.contact.utils;

public class InitSampleData {
	private String[] names;
	private String[] phoneNumbers;
	
	public InitSampleData() {
		System.out.println("InitSampleData의 기본생성자");
	}
	
	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
