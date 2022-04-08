package com.example.javafinal;

import java.util.ArrayList;
import java.util.Random;

public class Company implements Runnable {

    Thread thread = new Thread();
    WorldClass worldClass = new WorldClass();

    @Override
    public synchronized void run() {
        int min = 5;
        int max = 2500;
        while (true){
            try {
                thread.sleep(2000);
                Random r = new Random();
                int r_num = min + r.nextInt(max);
                int p_num = min + r.nextInt(max);
                double rv = getRevenue();
                setRevenue(rv+r_num);
                double pr = getProfit();
                setProfit(pr+p_num);

                if (Math.random() < 0.3){
                    Fund fund = getFund();
                    int randomized = r.nextInt(12);
                    if (randomized%2 == 0){
                        if (fund.getCommodities().size() > 0 && worldClass.getCommodityArrayList().size() > 0 &&
                        worldClass.getCommMarketArray().size() > 0) {
                            Commodity com = fund.buyCommodity();
                            worldClass.commodityChange(com);
                            thread.sleep(1000);
                            if ((getProfit() - com.getCurrentPrice() - fund.getPrice()) > 0){
                                setProfit(getProfit() - com.getCurrentPrice() - fund.getPrice());
                                setRevenue(getRevenue() + com.getCurrentPrice());
                            } else {
                                ArrayList<Commodity> coms = new ArrayList<Commodity>(fund.getCommodities());
                                coms.remove(com);
                                fund.setCommodities(coms);
                            }
                        }
                    }else if (randomized%3 == 0){
                        if (fund.getCurrencies().size() > 0 && worldClass.getCurrencyArrayList().size() > 0 &&
                        worldClass.getCurrMarketArray().size() > 0) {
                            Currency cur = fund.buyCurrency();
                            worldClass.currencyChange(cur);
                            thread.sleep(1000);
                            if ((getProfit() - cur.getBuyCost() - fund.getPrice()) > 0){
                                setProfit(getProfit() - cur.getBuyCost() - fund.getPrice());
                                setRevenue(getRevenue() + cur.getSellPrice());
                            } else {
                                ArrayList<Currency> curs = new ArrayList<Currency>(fund.getCurrencies());
                                curs.remove(cur);
                                fund.setCurrencies(curs);
                            }
                        }
                    }else{
                        if (fund.getShares().size() > 0 && worldClass.getShareArray().size() > 0 &&
                        worldClass.getStockMarketArray().size() > 0) {
                            Share sh = fund.buyShare();
                            worldClass.shareChange(sh);
                            if ((getProfit() - sh.getValue() - fund.getPrice()) > 0){
                                ArrayList<Share> array = new ArrayList<Share>(getShares());
                                array.add(sh);
                                setShares(array);
                                worldClass.addSharesArray(sh);
                                worldClass.shareChange(sh);
                                thread.sleep(1000);
                                setProfit(getProfit() - sh.getValue() - fund.getPrice());
                                setRevenue(getRevenue() + sh.getValue());
                            } else {
                                ArrayList<Share> shars = new ArrayList<Share>(fund.getShares());
                                shars.remove(sh);
                                fund.setShares(shars);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String name;
    private String IPOdate;
    private double IPOshareValue;
    private double openingPrice;
    private double currentPrice;
    private double minPrice;
    private double maxPrice;
    private double profit;
    private double revenue;
    private String capital;
    private double tradingVolume;
    private double totalSales;
    private Fund fund;
    private ArrayList<Share> shares;

    ArrayList<Investor> investorList = new ArrayList<Investor>();

    public String getInfo(){
        return ("Company information\n\nname: " + getName() + "\nIPO date and share value: " + getIPOdate() + ", " + getIPOshareValue()
        + "\nOpening price: " + getOpeningPrice() + "\nCurrent price: " + getCurrentPrice() + "\nMinimum and maximum price: "
        + getMinPrice() + ", " + getMaxPrice() + "\nProfit and revenue: " + getProfit() + ", " + getRevenue()
        + "\nCapital: " + getCapital() + "\nTrading volume and total sales: " + getTradingVolume() + ", " + getTotalSales()
        + "\nFund: " + getFund() + "\nShares: " + getShares());
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIPOdate() {
        return IPOdate;
    }
    public void setIPOdate(String iPOdate) {
        IPOdate = iPOdate;
    }
    public double getIPOshareValue() {
        return IPOshareValue;
    }
    public void setIPOshareValue(double iPOshareValue) {
        IPOshareValue = iPOshareValue;
    }
    public double getOpeningPrice() {
        return openingPrice;
    }
    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
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
    public double getProfit() {
        return profit;
    }
    public void setProfit(double profit) {
        this.profit = profit;
    }
    public double getRevenue() {
        return revenue;
    }
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public double getTradingVolume() {
        return tradingVolume;
    }
    public void setTradingVolume(double tradingVolume) {
        this.tradingVolume = tradingVolume;
    }
    public double getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
    public Fund getFund() {
        return fund;
    }
    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public ArrayList<Investor> getInvestorList() {
        return investorList;
    }
    public void setInvestorList(ArrayList<Investor> investorList) {
        this.investorList = investorList;
    }

    public ArrayList<Share> getShares(){
        return shares;
    }
    public void setShares(ArrayList<Share> shares){
        this.shares = shares;
    }

    public Company(String name, String iPOdate, double iPOshareValue, double openingPrice, double currentPrice,
                   double minPrice, double maxPrice, double profit, double revenue, String capital, double tradingVolume,
                   double totalSales, Fund fund,
                   ArrayList<Investor> investorList, ArrayList<Share> shares) {
        super();
        this.name = name;
        IPOdate = iPOdate;
        IPOshareValue = iPOshareValue;
        this.openingPrice = openingPrice;
        this.currentPrice = currentPrice;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.profit = profit;
        this.revenue = revenue;
        this.capital = capital;
        this.tradingVolume = tradingVolume;
        this.totalSales = totalSales;
        this.fund = fund;
        //this.index = index;
        this.investorList = investorList;
        this.shares = shares;
    }

}