package model;

public class Supplier {
    private String id;
    private String name;
    private String contactNumber;
    private String gender;

    public Supplier() {
    }

    public Supplier(String id, String name, String contactNumber, String gender) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
