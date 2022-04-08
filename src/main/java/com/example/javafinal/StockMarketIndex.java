package com.example.javafinal;

import java.util.ArrayList;

public class StockMarketIndex {
    private String name;
    private ArrayList<Company> namesOfCompanies;
    private double value;

    public String getInfo(){
        return ("Index information\n\nName: " + getName() + "\nCompanies: " + getNamesOfCompanies() + "\nValue: " + getValue());
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Company> getNamesOfCompanies() {
        return namesOfCompanies;
    }
    public void setNamesOfCompanies(ArrayList<Company> namesOfCompanies) {
        this.namesOfCompanies = namesOfCompanies;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public StockMarketIndex(String name, ArrayList<Company> namesOfCompanies, double value) {
        super();
        this.name = name;
        this.namesOfCompanies = namesOfCompanies;
        this.value = value;
    }

}
