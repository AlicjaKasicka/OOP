package com.example.javafinal;

import java.util.ArrayList;
import java.util.Random;

public class Investor implements Runnable{

    Thread thread = new Thread();
    WorldClass worldClass = new WorldClass();

    @Override
    public synchronized void run() {
        while (investmentBudget > 0){
            Random r = new Random();
            int random_sleep = 500 + r.nextInt(7000);
            try {
                thread.sleep(random_sleep);
                if (Math.random() < 0.23){ //randomly increasing budget
                    int random_increase = r.nextInt(1670);
                    double budget = getInvestmentBudget();
                    setInvestmentBudget(budget + random_increase);
                }
                if (Math.random() < 0.45) { //buying shares
                    if (worldClass.getShareArray().size() > 0){
                        Share s = buyShare();
                        double money = getInvestmentBudget();
                        double bought = s.getValue();
                        if ((money - bought) > 0){
                            setInvestmentBudget(money-bought);
                            worldClass.shareChange(s);
                            thread.sleep(1000);
                        } else {
                            int ind = getShares().indexOf(s);
                            ArrayList<Share> shs = new ArrayList<Share>(getShares());
                            shs.remove(ind);
                            setShares(shs);
                        }
                    }
                }
                if (Math.random() < 0.35) { //selling shares
                    if (getShares().size() > 0){
                        Share ss = sellShare();
                        double money = getInvestmentBudget();
                        double sold = ss.getValue();
                        setInvestmentBudget(money+sold);
                        worldClass.shareChange(ss);
                        thread.sleep(1000);
                    }
                }
                if (Math.random() < 0.45) { //buying commodities
                    if (worldClass.getCommodityArrayList().size() > 0){
                        Commodity c = buyCommodity();
                        double money = getInvestmentBudget();
                        double bought = c.getCurrentPrice();
                        if ((money - bought) > 0) {
                            setInvestmentBudget(money-bought);
                            worldClass.commodityChange(c);
                            thread.sleep(1000);
                        } else {
                            int ind = getCommodities().indexOf(c);
                            ArrayList<Commodity> cms = new ArrayList<Commodity>(getCommodities());
                            cms.remove(ind);
                            setCommodities(cms);
                        }
                    }
                }
                if (Math.random() < 0.35) { //selling commodities
                    if (getCommodities().size() > 0){
                        Commodity cc = sellCommodity();
                        double money = getInvestmentBudget();
                        double sold = cc.getCurrentPrice();
                        setInvestmentBudget(money+sold);
                        worldClass.commodityChange(cc);
                        thread.sleep(1000);
                    }
                }
                if (Math.random() < 0.45) { //buying currencies
                    if (worldClass.getCurrencyArrayList().size() > 0){
                        Currency cr = buyCurrency();
                        double money = getInvestmentBudget();
                        double bought = cr.getBuyCost();
                        if ((money - bought) > 0){
                            setInvestmentBudget(money-bought);
                            worldClass.currencyChange(cr);
                            thread.sleep(1000);
                        } else {
                            int ind = getCurrencies().indexOf(cr);
                            ArrayList<Currency> crs = new ArrayList<Currency>(getCurrencies());
                            crs.remove(ind);
                            setCurrencies(crs);
                        }
                    }
                }
                if (Math.random() < 0.35) { //selling currencies
                    if (getCurrencies().size() > 0){
                        Currency ccr = sellCurrency();
                        double money = getInvestmentBudget();
                        double sold = ccr.getSellPrice();
                        setInvestmentBudget(money+sold);
                        worldClass.currencyChange(ccr);
                    }
                }
                if (Math.random() < 0.45) { //buying funds
                    if (worldClass.getFundsArray().size() > 0){
                        Fund f = buyFund();
                        double money = getInvestmentBudget();
                        double bought = f.getPrice();
                        if ((money - bought) > 0){
                            setInvestmentBudget(money-bought);
                            worldClass.fundChange(f);
                        } else {
                            int ind = getFunds().indexOf(f);
                            ArrayList<Fund> fds = new ArrayList<Fund>(getFunds());
                            fds.remove(ind);
                            setFunds(fds);
                        }
                    }
                }
                if (Math.random() < 0.35) { //selling funds
                    if (getFunds().size() > 0){
                        Fund ff = sellFund();
                        double money = getInvestmentBudget();
                        double sold = ff.getPrice();
                        setInvestmentBudget(money+sold);
                        worldClass.fundChange(ff);
                    }
                }
                if (getFunds().size() > 0) {
                    Fund fu = getFunds().get(r.nextInt(getFunds().size()));
                    if (Math.random() < 0.35){
                        if (worldClass.getCurrMarketArray().size() > 0) {
                            Currency cu = fu.buyCurrency();
                            double price = fu.getPrice();
                            double price2 = cu.getBuyCost();
                            double money = getInvestmentBudget();
                            if ((money - price - price2) > 0) {
                                setInvestmentBudget(money - price - price2);
                                ArrayList<Currency> crs = new ArrayList<Currency>(getCurrencies());
                                crs.add(cu);
                                setCurrencies(crs);
                                worldClass.currencyChange(cu);
                                //update market arrays???
                            }
                        }
                    }
                    if (Math.random() < 0.35){
                        if (worldClass.getCommMarketArray().size() > 0){
                            Commodity co = fu.buyCommodity();
                            double price = fu.getPrice();
                            double price2 = co.getCurrentPrice();
                            double money = getInvestmentBudget();
                            if ((money - price - price2) > 0) {
                                setInvestmentBudget(money - price - price2);
                                ArrayList<Commodity> cms = new ArrayList<Commodity>(getCommodities());
                                cms.add(co);
                                setCommodities(cms);
                                worldClass.commodityChange(co);
                                //update market arrays???
                            }
                        }
                    }
                    if (Math.random() < 0.35){
                        if (worldClass.getStockMarketArray().size() > 0){
                            Share sa = fu.buyShare();
                            double price = fu.getPrice();
                            double price2 = sa.getValue();
                            double money = getInvestmentBudget();
                            if ((money - price - price2) > 0) {
                                setInvestmentBudget(money - price - price2);
                                ArrayList<Share> shs = new ArrayList<Share>(getShares());
                                shs.add(sa);
                                setShares(shs);
                                worldClass.shareChange(sa);
                                //update market arrays???
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String firstName;
    private String lastName;
    private String tradingIdentifier;
    private double investmentBudget;
    private ArrayList<Fund> funds;
    private ArrayList<Share> shares;
    private ArrayList<Commodity> commodities;
    private ArrayList<Currency> currencies;
    Random r = new Random();

    public String getInfo(){
        return ("Investor information\n\nFirst name and Last name: " + getFirstName() + " " + getLastName() +
                "\nTrading identifier: " + getTradingIdentifier() + "\nInvestment budget: " + getInvestmentBudget());
    }

    public synchronized Fund buyFund() {
        int ind = r.nextInt(worldClass.getFundsArray().size());
        Fund fn = worldClass.getFundsArray().get(ind);
        ArrayList<Fund> fds = new ArrayList<Fund>(getFunds());
        fds.add(fn);
        setFunds(fds);
        System.out.println("Investor " + this + " is buying. ");
        return fn;
    }

    public synchronized Fund sellFund() {
        int ind = r.nextInt(getFunds().size());
        ArrayList<Fund> fds = new ArrayList<Fund>(getFunds());
        Fund f = fds.get(ind);
        fds.remove(ind);
        setFunds(fds);
        System.out.println("Investor " + this + " is selling. ");
        return f;
    }

    public synchronized Share buyShare() {
        int ind = r.nextInt(worldClass.getShareArray().size());
        Share sh = worldClass.getShareArray().get(ind);
        ArrayList<Share> shs = new ArrayList<Share>(getShares());
        shs.add(sh);
        setShares(shs);
        Company comp = sh.getCompany();
        comp.setTradingVolume(comp.getTradingVolume() + sh.getValue());
        System.out.println("Investor " + this + " is buying. ");
        return sh;
    }

    public synchronized Share sellShare() {
        int ind = r.nextInt(getShares().size());
        ArrayList<Share> shs = new ArrayList<Share>(getShares());
        Share s = shs.get(ind);
        shs.remove(ind);
        setShares(shs);
        Company comp = s.getCompany();
        comp.setTotalSales(comp.getTotalSales() + 1);
        comp.setTradingVolume(comp.getTradingVolume() + s.getValue());
        System.out.println("Investor " + this + " is selling. ");
        return s;
    }

    public synchronized Commodity buyCommodity() {
        int ind = r.nextInt(worldClass.getCommodityArrayList().size());
        Commodity cm = worldClass.getCommodityArrayList().get(ind);
        ArrayList<Commodity> cms = new ArrayList<Commodity>(getCommodities());
        cms.add(cm);
        setCommodities(cms);
        System.out.println("Investor " + this + " is buying. ");
        return cm;
    }

    public synchronized Commodity sellCommodity() {
        int ind = r.nextInt(getCommodities().size());
        ArrayList<Commodity> cms = new ArrayList<Commodity>(getCommodities());
        Commodity c = cms.get(ind);
        cms.remove(ind);
        setCommodities(cms);
        System.out.println("Investor " + this + " is selling. ");
        return c;
    }

    public synchronized Currency buyCurrency() {
        int ind = r.nextInt(worldClass.getCurrencyArrayList().size());
        Currency cr = worldClass.getCurrencyArrayList().get(ind);
        ArrayList<Currency> crs = new ArrayList<Currency>(getCurrencies());
        crs.add(cr);
        setCurrencies(crs);
        System.out.println("Investor " + this + " is buying. ");
        return cr;
    }

    public synchronized Currency sellCurrency() {
        int ind = r.nextInt(getCurrencies().size());
        ArrayList<Currency> crs = new ArrayList<Currency>(getCurrencies());
        Currency c = crs.get(ind);
        crs.remove(ind);
        setCurrencies(crs);
        System.out.println("Investor " + this + " is selling. ");
        return c;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTradingIdentifier() {
        return tradingIdentifier;
    }

    public void setTradingIdentifier(String tradingIdentifier) {
        this.tradingIdentifier = tradingIdentifier;
    }

    public double getInvestmentBudget() {
        return investmentBudget;
    }

    public void setInvestmentBudget(double investmentBudget) {
        this.investmentBudget = investmentBudget;
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

    public ArrayList<Fund> getFunds(){
        return funds;
    }

    public void setFunds(ArrayList<Fund> funds){
        this.funds = funds;
    }


    public Investor(String firstName, String lastName, String tradingIdentifier, double investmentBudget, ArrayList<Share> shares,
                    ArrayList<Currency> currencies, ArrayList<Commodity> commodities, ArrayList<Fund> funds) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.tradingIdentifier = tradingIdentifier;
        this.investmentBudget = investmentBudget;
        this.shares = shares;
        this.currencies = currencies;
        this.commodities = commodities;
        this.funds = funds;
    }

}