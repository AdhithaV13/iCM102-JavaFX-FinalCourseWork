package model.tm;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class ItemTm extends RecursiveTreeObject<ItemTm> {
    private String code;
    private String description;
    private double unitPrice;
    private String kind;
    private int qty;

    public ItemTm() {
    }

    public ItemTm(String code, String description, double unitPrice, String kind, int qty) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.kind = kind;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
