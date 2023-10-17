package model.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class SupplierTm extends RecursiveTreeObject<SupplierTm> {
    String id;
    String name;
    String contact;
    String gender;

    public SupplierTm() {
    }

    public SupplierTm(String id, String name, String contact, String gender) {
        this.id = id;
        this.name = name;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
