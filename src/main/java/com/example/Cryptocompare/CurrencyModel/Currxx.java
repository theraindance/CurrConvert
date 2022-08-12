package com.example.Cryptocompare.CurrencyModel;

//with getter/setter, spring will get html to, save it inside model to
public class Currxx {
    
    
    private String to;
    private String from;
    private int amount;

    //getTo, get result from user form, put inside object
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
