package com.example.javafinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Share {

    private String name;
    private double value;
    private Company company;

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
        return ("Share information\n\nName: " + getName() + "\nValue: " + getValue() + "\nCompany: " + getCompany());
    }

    public void buy() {
        System.out.println("Buying " + this);
    }

    public void sell() {
        System.out.println("Selling " + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Company getCompany(){
        return company;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    public Share(String name, double value, Company company) {
        super();
        this.name = name;
        this.value = value;
        this.company = company;
    }

}