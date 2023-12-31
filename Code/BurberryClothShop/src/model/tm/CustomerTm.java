package model.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import model.Customer;

public class CustomerTm extends RecursiveTreeObject<CustomerTm> {
    String id;
    String name;
    String contact;
    String address;
    String gender;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public CustomerTm() {
    }

    public CustomerTm(String id, String name, String contactNumber, String address, String gender) {
        this.id = id;
        this.name = name;
        this.contact = contactNumber;
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
