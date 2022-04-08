package com.example.javafinal;

import java.util.List;

public class CommodityMarket extends Market {

    private double transactionMargin;
    private String commodityName;
    private Commodity commodity;

    public String getInfo(){
        return ("Commodity Market information\n\nname: " + getName() + "\nCountry: " + getCountry() + "\nCity and address: "
        + getCity() + ", " + getAddress() + "\nTrading currency: " + getTradingCurrency() + "\nCost of trade and transaction margin: "
        + getCostOfTrade() + ", " + transactionMargin + "\nStock Market indices: " + getListOfStockMarketIndices()
        + "\nCommodity and commodity name: " + commodity + ", " + commodityName);
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

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public CommodityMarket(String name, String country, String tradingCurrency, String city, String address,
                           List<String> listOfStockMarketIndices, double costOfTrade, double transactionMargin, String commodityName,
                           Commodity commodity) {
        super("name" , "country", "tradingCurrency", "city", "address", listOfStockMarketIndices, costOfTrade);
        this.transactionMargin = transactionMargin;
        this.commodityName = commodityName;
        this.commodity = commodity;
    }

}