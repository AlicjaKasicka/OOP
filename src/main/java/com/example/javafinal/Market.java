package com.example.javafinal;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private String name;
    private String country;
    private String tradingCurrency;
    private String city;
    private String address;
    private List<String> listOfStockMarketIndices = new ArrayList<String>();
    private double costOfTrade;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getTradingCurrency() {
        return tradingCurrency;
    }
    public void setTradingCurrency(String tradingCurrency) {
        this.tradingCurrency = tradingCurrency;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<String> getListOfStockMarketIndices() {
        return listOfStockMarketIndices;
    }
    public void setListOfStockMarketIndices(List<String> listOfStockMarketIndices) {
        this.listOfStockMarketIndices = listOfStockMarketIndices;
    }
    public double getCostOfTrade() {
        return costOfTrade;
    }
    public void setCostOfTrade(double costOfTrade) {
        this.costOfTrade = costOfTrade;
    }



    public Market(String name, String country, String tradingCurrency, String city, String address,
                  List<String> listOfStockMarketIndices, double costOfTrade) {
        super();
        this.name = name;
        this.country = country;
        this.tradingCurrency = tradingCurrency;
        this.city = city;
        this.address = address;
        this.listOfStockMarketIndices = listOfStockMarketIndices;
        this.costOfTrade = costOfTrade;
    }

}