package com.example.Cryptocompare.CurrencyModel;

import java.util.HashMap;

//need a constructor when converting JSON to JAVA
public class jsontojava {
    private String success;
    private HashMap query;
    private HashMap info;
    private String date;
    private double result;

    public jsontojava() {
    }
    public jsontojava(String success, HashMap query, HashMap info, String date, double result) {
        this.success = success;
        this.query = query;
        this.info = info;
        this.date = date;
        this.result = result;
    }
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public HashMap getQuery() {
        return query;
    }
    public void setQuery(HashMap query) {
        this.query = query;
    }
    public HashMap getInfo() {
        return info;
    }
    public void setInfo(HashMap info) {
        this.info = info;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
}
