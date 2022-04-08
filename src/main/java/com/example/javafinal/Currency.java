package com.example.javafinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Currency {

    private String name;
    private double buyCost;
    private double sellPrice;
    private List<String> listOfCountries = new ArrayList<String>();

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
        return ("Currency information\n\nname: " + name + "\nbuyCost: " + buyCost + "\nsellPrice: " + sellPrice
        + "\nlistOfCountries: " + listOfCountries);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getBuyCost() {
        return buyCost;
    }

    public void setBuyCost(double buyCost) {
        this.buyCost = buyCost;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public List<String> getListOfCountries() {
        return (ArrayList<String>) listOfCountries;
    }

    public void setListOfCountries(List<String> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }

    public Currency(String name, double buyCost, double sellPrice, List listOfCountries) {
        super();
        this.name = name;
        this.buyCost = buyCost;
        this.sellPrice = sellPrice;
        this.listOfCountries = listOfCountries;
    }

}