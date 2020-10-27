package ilerofv.entity;

import java.util.Date;

public class Transaction {

    String id;
    Date date; //(format "DD/MM/YYYY hh:mm:ss")
    double amount; //(dollars and cents)
    String merchant;
    Type type; //PAYMENT or REVERSAL
    String related; //In the case a REVERSAL transaction, this field will contain the ID of the transaction it is reversing.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }
}
