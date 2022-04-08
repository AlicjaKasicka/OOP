package com.example.javafinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commodity {

    private String name;
    private String tradingUnit;
    private String tradingCurrency;
    private double currentPrice;
    private double minPrice;
    private double maxPrice;

    private List<Integer> changes = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    public void setNewChanges(double new_value){
        ArrayList<Integer> change = new ArrayList<Integer>();
        for (int ch = 0; ch < 9; ch++){
            Integer i = (int) getChanges().get(ch + 1);
            change.add(ch, i);
        }
        change.add(9, (int) new_value);
        setChanges(change);
        //System.out.println(getChanges());
    }

    public void setChanges(List<Integer> changes) {
        this.changes = changes;
    }

    public List<Integer> getChanges(){
        return changes;
    }


    public String getInfo(){
        return ("Commodity information\n\nname: " + name + "\nTrading unit and currency: " + tradingUnit
                + ", " + tradingCurrency + "\nCurrent price: " + currentPrice + "\nMin and max price: "
                + minPrice + ", " + maxPrice);
    }

    public void buy() {
        System.out.println("Buying commodity: " + this);
    }

    public void sell() {
        System.out.println("Selling commodity: " + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingUnit() {
        return tradingUnit;
    }

    public void setTradingUnit(String tradingUnit) {
        this.tradingUnit = tradingUnit;
    }

    public String getTradingCurrency() {
        return tradingCurrency;
    }

    public void setTradingCurrency(String tradingCurrency) {
        this.tradingCurrency = tradingCurrency;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Commodity(String name, String tradingUnit, String tradingCurrency, double currentPrice, double minPrice,
                     double maxPrice) {
        super();
        this.name = name;
        this.tradingUnit = tradingUnit;
        this.tradingCurrency = tradingCurrency;
        this.currentPrice = currentPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

}