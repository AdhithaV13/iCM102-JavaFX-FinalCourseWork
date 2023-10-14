package model;

public class Bill {
    private String billId;
    private String customerId;
    private String customerName;
    private String supplierId;
    private String supplierName;
    private String itemCodes;
    private double itemPrices;
    private int qty;
    private double total;

    public Bill() {
    }

    public Bill(String billId, String customerId, String customerName, String supplierId, String supplierName, String itemCodes, double itemPrices, int qty, double total) {
        this.billId = billId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.itemCodes = itemCodes;
        this.itemPrices = itemPrices;
        this.qty = qty;
        this.total = total;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getItemCodes() {
        return itemCodes;
    }

    public void setItemCodes(String itemCodes) {
        this.itemCodes = itemCodes;
    }

    public double getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(double itemPrices) {
        this.itemPrices = itemPrices;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
