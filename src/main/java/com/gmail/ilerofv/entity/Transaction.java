package com.gmail.ilerofv.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private String id;
    private Date date;
    private double amount;
    private String merchant;
    private TransactionType transactionType;
    private String related = "";



//    public static class Builder {
//        private Transaction newTransaction;
//
//        public Builder(){
//            newTransaction = new Transaction();
//        }
//
//        public Builder withId(String id){
//            newTransaction.id = id;
//            return this;
//        }
//
//        public Builder withDate(Date date){
//            newTransaction.date = date;
//            return this;
//        }
//
//        public Builder withAmount(double amount){
//            newTransaction.amount = amount;
//            return this;
//        }
//
//        public Builder withMerchant(String merchant){
//            newTransaction.merchant = merchant;
//            return this;
//        }
//
//        public Builder withType(Type type){
//            newTransaction.type = type;
//            return this;
//        }
//
//        public Builder withRelated(String related){
//            newTransaction.related = related;
//            return this;
//        }
//
//        public Builder reset (){
//            newTransaction = new Transaction();
//            return this;
//        }
//
//        public Transaction build() {
//            return newTransaction;
//        }
//    }

}
