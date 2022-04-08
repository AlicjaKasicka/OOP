package com.example.javafinal;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMarket extends Market {

    private double transactionMargin;
    private String currencyName;
    private Currency currency;
    private ArrayList<Currency> currencies;

    public String getInfo(){
        return ("Currency Market information\n\nname: " + getName() + "\nCountry: " + getCountry() + "\nTrading currency: "
        + getTradingCurrency() + "\nCity and address: " + getCity() + ", " + getAddress() + "\nList of Stock Market Indices: "
        + getListOfStockMarketIndices() + "\nCost of Trade: " + getCostOfTrade() + "\nTransaction Margin: " + getTransactionMargin()
        + "\nCurrency and currency name: " + getCurrency() + ", " + getCurrencyName());
    }

    public void buy() {
        System.out.println("Buying " + this);
    }

    public void sell() {
        System.out.println("Selling " + this);
    }

    public ArrayList<Currency> getCurrencies(){
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies){
        this.currencies = currencies;
    }

    public double getTransactionMargin() {
        return transactionMargin;
    }

    public void setTransactionMargin(double transactionMargin) {
        this.transactionMargin = transactionMargin;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public CurrencyMarket(String name, String country, String tradingCurrency, String city, String address,
                          List<String> listOfStockMarketIndices, double costOfTrade, double transactionMargin, String currencyName,
                          Currency currency, ArrayList<Currency> currencies) {
        super(name, country, tradingCurrency, city, address, listOfStockMarketIndices, costOfTrade);
        this.transactionMargin = transactionMargin;
        this.currencyName = currencyName;
        this.currency = currency;
        this.currencies = currencies;
    }

}