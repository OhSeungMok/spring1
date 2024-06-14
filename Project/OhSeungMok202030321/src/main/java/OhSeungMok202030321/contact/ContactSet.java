package OhSeungMok202030321.contact;

public class ContactSet {
	private String Id;
    private String Name;
    private String Major;

    public ContactSet(String Id, String Name, String Major) {
        this.Id = Id;
        this.Name = Name;
        this.Major = Major;
    }

	public String getId() {
		return Id;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		this.Major = major;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

    
}
