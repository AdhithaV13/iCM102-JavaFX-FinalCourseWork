package model.tm;

public class CustomerTm extends RecursiveTreeObject<CustomerTm>{
    String id;
    String name;
    String contactNumber;
    String address;
    String gender;

    public CustomerTm() {
    }

    public CustomerTm(String id, String name, String contactNumber, String address, String gender) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
