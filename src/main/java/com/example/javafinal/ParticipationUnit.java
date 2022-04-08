package com.example.javafinal;

public class ParticipationUnit {

    private String fundName;
    private Fund fund;

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public ParticipationUnit(String fundName, Fund fund) {
        super();
        this.fundName = fundName;
        this.fund = fund;
    }

}