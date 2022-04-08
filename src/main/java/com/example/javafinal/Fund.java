package com.example.javafinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fund implements Runnable{

    Thread thread = new Thread();

    @Override
    public synchronized void run() {
        Random r = new Random();
        int random_sleep = 500 + r.nextInt(5000);
        try {
            thread.sleep(random_sleep);
            extracted();
            if (Math.random() < 0.3){
                if (worldClass.getCurrMarketArray().size() > 0) {
                    Currency cur = buyCurrency();
                    thread.sleep(1000);
                }
            }
            if (Math.random() < 0.3){
                if (worldClass.getStockMarketArray().size() > 0) {
                    Share sh = buyShare();
                    thread.sleep(1000);
                }
            }
            if (Math.random() < 0.25){
                if (currencies.size() > 0) {
                    Currency curs = sellCurrency();
                    thread.sleep(1000);
                }
            }
            if (Math.random() < 1){
                if (commodities.size() > 0){
                    Commodity coms = sellCommodity();
                    thread.sleep(1000);
                }
            }
            if (Math.random() < 1){
                if (shares.size() > 0){
                    Share shs = sellShare();
                    thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void extracted() throws InterruptedException {
        if (Math.random() < 0.3){
            if (worldClass.getCommMarketArray().size() > 0){
                Commodity com = buyCommodity();
                thread.sleep(1000);
            }
        }
    }

    private String name;
    private String managerInfo;
    private WorldClass worldClass = new WorldClass();
    private double price;
    Random r = new Random();

    private ArrayList<Share> shares = new ArrayList<Share>();
    private ArrayList<Commodity> commodities = new ArrayList<Commodity>();
    private ArrayList<Currency> currencies = new ArrayList<Currency>();

    private List<Integer> changes = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

    public void setNewChanges(double new_value){
        ArrayList<Integer> change = new ArrayList<Integer>();
        for (int ch = 0; ch < 9; ch++){
            Integer i = (int) getChanges().get(ch + 1);
            change.add(ch, i);
        }
        change.add(9, (int) new_value);
        setChanges(change);
    }

    public void setChanges(List<Integer> changes) {
        this.changes = changes;
    }

    public List<Integer> getChanges(){
        return changes;
    }

    public String getInfo(){
        return ("Fund information\n\nName: " + getName() + "\nManager info: " + getManagerInfo() + "\nPrice: "  + getPrice()
                + "\nShares: " + getShares() + "\nCommodities: " + getCommodities() + "\nCurrencies: " + getCurrencies());
    }


    public synchronized Share buyShare() {
        int ind = r.nextInt(worldClass.getStockMarketArray().size());
        StockMarket sh_mar = worldClass.getStockMarketArray().get(ind);
        Share sh = sh_mar.getShare();
        ArrayList<Share> shs = new ArrayList<Share>(getShares());
        shs.add(sh);
        setShares(shs);
        Company comp = sh.getCompany();
        comp.setTradingVolume(comp.getTradingVolume() + sh.getValue());
        System.out.println("Buying new share: " + sh);
        return sh;
    }

    public synchronized Share sellShare() {
        int ind = r.nextInt(getShares().size());
        ArrayList<Share> shs = new ArrayList<Share>(getShares());
        Share sh = shs.get(ind);
        shs.remove(ind);
        setShares(shs);
        Company comp = sh.getCompany();
        comp.setTotalSales(comp.getTotalSales() + 1);
        comp.setTradingVolume(comp.getTradingVolume() + sh.getValue());
        comp.setRevenue(comp.getRevenue() + sh.getValue());
        comp.setProfit(comp.getProfit() + sh.getValue());
        System.out.println("FUND Selling share: " + this);
        return sh;
    }

    public synchronized Commodity buyCommodity() {
        int ind = r.nextInt(worldClass.getCommMarketArray().size());
        CommodityMarket com_mar = worldClass.getCommMarketArray().get(ind);
        Commodity com = com_mar.getCommodity();

        ArrayList<Commodity> coms = new ArrayList<Commodity>(getCommodities());
        coms.add(com);
        setCommodities(coms);

        System.out.println("Buying commodity: " + com);
        return com;
    }

    public synchronized Commodity sellCommodity() {
        int ind = r.nextInt(getCommodities().size());
        ArrayList<Commodity> coms = new ArrayList<Commodity>(getCommodities());
        Commodity com = coms.get(ind);
        coms.remove(ind);
        setCommodities(coms);
        System.out.println("FUND Selling commodity: " + this);
        return com;
    }

    public synchronized Currency buyCurrency() {
        int ind = r.nextInt(worldClass.getCurrMarketArray().size());
        CurrencyMarket cur_mar = worldClass.getCurrMarketArray().get(ind);
        Currency cur = cur_mar.getCurrency();

        ArrayList<Currency> curs = new ArrayList<Currency>(getCurrencies());
        curs.add(cur);
        setCurrencies(curs);

        System.out.println("Buying currency: " + cur);
        return cur;
    }

    public synchronized Currency sellCurrency(){
        int ind = r.nextInt(getCurrencies().size());
        ArrayList<Currency> curs = new ArrayList<Currency>(getCurrencies());
        Currency cur = curs.get(ind);
        curs.remove(ind);
        setCurrencies(curs);
        System.out.println("Selling currency: " + this);
        return cur;
    }

    public ArrayList<Share> getShares(){
        return shares;
    }

    public void setShares(ArrayList<Share> shares){
        this.shares = shares;
    }

    public ArrayList<Commodity> getCommodities(){
        return commodities;
    }

    public void setCommodities(ArrayList<Commodity> commodities){
        this.commodities = commodities;
    }

    public ArrayList<Currency> getCurrencies(){
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies){
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public String getManagerInfo() {
        return managerInfo;
    }

    public void setManagerInfo(String managerInfo) {
        this.managerInfo = managerInfo;
    }

    public Fund(String name, String managerInfo, double price, ArrayList<Share> shares, ArrayList<Commodity> commodities, ArrayList<Currency> currencies) {
        super();
        this.name = name;
        this.managerInfo = managerInfo;
        this.price = price;
        this.shares = shares;
        this.commodities = commodities;
        this.currencies = currencies;
    }

}