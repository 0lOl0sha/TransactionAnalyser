package com.gmail.ilerofv.entity;

import java.util.Date;

public class Transaction {

    private String id;
    private Date date;
    private double amount;
    private String merchant;
    private Type type;
    private String related = "";

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public Type getType() {
        return type;
    }

    public String getRelated() {
        return related;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id='" + id + '\'' + ", date=" + date + ", amount=" + amount + ", merchant='" + merchant + '\'' + ", type=" + type + ", related='" + related + '\'' + '}';
    }

    public static class Builder {
        private Transaction newTransaction;

        public Builder(){
            newTransaction = new Transaction();
        }

        public Builder withId(String id){
            newTransaction.id = id;
            return this;
        }

        public Builder withDate(Date date){
            newTransaction.date = date;
            return this;
        }

        public Builder withAmount(double amount){
            newTransaction.amount = amount;
            return this;
        }

        public Builder withMerchant(String merchant){
            newTransaction.merchant = merchant;
            return this;
        }

        public Builder withType(Type type){
            newTransaction.type = type;
            return this;
        }

        public Builder withRelated(String related){
            newTransaction.related = related;
            return this;
        }

        public Builder reset (){
            newTransaction = new Transaction();
            return this;
        }

        public Transaction build() {
            return newTransaction;
        }
    }


}
