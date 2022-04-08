package com.example.javafinal;

import java.util.List;

public class StockMarket extends Market {

    private double transactionMargin;
    private Share share;

    public String getInfo(){
        return ("Stock Market information\n\nname: " + getName() + "\nCountry: " + getCountry() + "\nCity and address: "
                + getCity() + ", " + getAddress() + "\nTrading currency: " + getTradingCurrency() + "\nCost of trade and transaction margin: "
                + getCostOfTrade() + ", " + transactionMargin + "\nStock Market indices: " + getListOfStockMarketIndices()
                + "\nShare: " + share);
    }

    public void buy() {
        System.out.println("Buying " + this);
    }

    public void sell() {
        System.out.println("Selling " + this);
    }

    public double getTransactionMargin() {
        return transactionMargin;
    }

    public void setTransactionMargin(double transactionMargin) {
        this.transactionMargin = transactionMargin;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }


    public StockMarket(String name, String country, String tradingCurrency, String city, String address,
                       List<String> listOfStockMarketIndices, double costOfTrade, double transactionMargin, Share share) {
        super(name, country, tradingCurrency, city, address, listOfStockMarketIndices, costOfTrade);
        this.transactionMargin = transactionMargin;
        this.share = share;
    }

}