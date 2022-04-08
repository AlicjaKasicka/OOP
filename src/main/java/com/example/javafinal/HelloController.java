package com.example.javafinal;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private WorldClass object = new WorldClass();
    private ArrayList<Object> asset_list = new ArrayList<Object>();

    @FXML
    private Button comm_btn;

    @FXML
    private TextArea asset_info;
    String currentDisplay;

    @FXML
    private Button info_btn;

    @FXML
    void onShowAssetInfoClick(ActionEvent event) {
        currentDisplay = obj_lst.getSelectionModel().getSelectedItem();
        int ind = items.indexOf(currentDisplay);
        Object curr_it = asset_list.get(ind);
        if (curr_it instanceof Commodity) {
            asset_info.setText(((Commodity) curr_it).getInfo());
        } else if (curr_it instanceof CurrencyMarket) {
            asset_info.setText(((CurrencyMarket) curr_it).getInfo());
        } else if (curr_it instanceof CommodityMarket) {
            asset_info.setText(((CommodityMarket) curr_it).getInfo());
        } else if (curr_it instanceof StockMarket) {
            asset_info.setText(((StockMarket) curr_it).getInfo());
        } else if (curr_it instanceof Currency) {
            asset_info.setText(((Currency) curr_it).getInfo());
        } else if (curr_it instanceof Share) {
            asset_info.setText(((Share) curr_it).getInfo());
        } else if (curr_it instanceof Company) {
            asset_info.setText(((Company) curr_it).getInfo());
        } else if (curr_it instanceof StockMarketIndex) {
            asset_info.setText(((StockMarketIndex) curr_it).getInfo());
        } else if (curr_it instanceof Investor) {
            asset_info.setText(((Investor) curr_it).getInfo());
        } else if (curr_it instanceof Fund) {
            asset_info.setText(((Fund) curr_it).getInfo());
        }
    }

    @FXML
    private ListView<String> obj_lst;
    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    void onCommodityButtonClick(ActionEvent event) {
        Commodity new_one = object.createCommodityObject();
        items.add(new_one.getName());
        asset_list.add(new_one);
        obj_lst.setItems(items);
        if (asset_list.size() % 7 == 0) {
            Investor new_inv = object.createInvestor();
            Thread new_thrinv = new Thread(new_inv);
            new_thrinv.start();
            items.add(new_inv.getTradingIdentifier());
            asset_list.add(new_inv);
            obj_lst.setItems(items);
        } else if (asset_list.size() % 5 == 0) {
            Fund new_fun = object.createFund();
            Thread new_thrfun = new Thread(new_fun);
            new_thrfun.start();
            items.add(new_fun.getName());
            asset_list.add(new_fun);
            obj_lst.setItems(items);
        }
    }

    @FXML
    private Button curr_btn;

    @FXML
    void onCurrencyButtonClick(ActionEvent event) {
        Currency new_one = object.createCurrencyObject();
        items.add(new_one.getName());
        asset_list.add(new_one);
        obj_lst.setItems(items);
        if (asset_list.size() % 7 == 0) {
            Investor new_inv = object.createInvestor();
            Thread new_thrinv = new Thread(new_inv);
            new_thrinv.start();
            items.add(new_inv.getTradingIdentifier());
            asset_list.add(new_inv);
            obj_lst.setItems(items);
        } else if (asset_list.size() % 5 == 0) {
            Fund new_fun = object.createFund();
            Thread new_thrfun = new Thread(new_fun);
            new_thrfun.start();
            items.add(new_fun.getName());
            asset_list.add(new_fun);
            obj_lst.setItems(items);
        }
    }

    @FXML
    private Button curr_mkt_btn;

    @FXML
    void onCurrMarketButtonClick(ActionEvent event) {
        if (object.getCurrencyArrayList().size() > 0) {
            CurrencyMarket new_one = object.createCurrencyMarket(object.getCurrencyArrayList());
            items.add(new_one.getName());
            asset_list.add(new_one);
            obj_lst.setItems(items);
        } else {
            System.out.println("There are no currencies! Not possible to create a currency market.");
        }
    }

    @FXML
    private Button comm_mkt_btn;

    @FXML
    void OnCommMarketButton(ActionEvent event) {
        if (object.getCommodityArrayList().size() > 0) {
            CommodityMarket new_one = object.createCommodityMarket(object.getCommodityArrayList());
            items.add(new_one.getName());
            asset_list.add(new_one);
            obj_lst.setItems(items);
        } else {
            System.out.println("There are no commodities! Not possible to create a commodity market.");
        }
    }

    @FXML
    private Button stck_mkt_btn;

    @FXML
    void OnStckMarketButton(ActionEvent event) {
        if (object.getShareArray().size() > 0) {
            StockMarket new_one = object.createStockMarket(object.getShareArray());
            items.add(new_one.getName());
            asset_list.add(new_one);
            obj_lst.setItems(items);
        } else {
            System.out.println("There are no shares! Not possible to create a stock market without shares.");
        }
    }

    @FXML
    private Button cmp_btn;

    @FXML
    void onCompanyButtonClick(ActionEvent event) {
        if (object.getFundsArray().size() > 0 && object.getInvestorArrayList().size() > 0) {
            Company new_one = object.createCompany(object.getFundsArray(), object.getInvestorArrayList());
            ArrayList<Share> shares_worldclass = new ArrayList<Share>(new_one.getShares());
            for (int ee = 0; ee < shares_worldclass.size(); ee++) {
                items.add(shares_worldclass.get(ee).getName());
                asset_list.add(shares_worldclass.get(ee));
            }
            Thread new_throne = new Thread(new_one);
            new_throne.start();
            items.add(new_one.getName());
            asset_list.add(new_one);

            ArrayList<Share> new_shares = new ArrayList<Share>(new_one.getShares());
            for (int e = 0; e < new_shares.size(); e++) {
                Share shn = new_shares.get(e);
                items.add(shn.getName());
                asset_list.add(shn);
            }
            obj_lst.setItems(items);
        } else {
            System.out.println("There are no funds and investors yet! Not possible to create a company.");
        }
    }

    @FXML
    private Slider slider;
    int bull;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                bull = (int) slider.getValue();
                object.setBull(bull);
            }
        });
    }

    @FXML
    private Button ind_btn;

    @FXML
    void OnIndButtonClick(ActionEvent event) {
        if (object.getCompanyArray().size() > 2) {
            StockMarketIndex index = object.createIndex(object.getCompanyArray());
            items.add(index.getName());
            asset_list.add(index);
            obj_lst.setItems(items);
        } else {
            System.out.println("Not enough companies!");
        }
    }

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    void onGraphClick(ActionEvent event) {
        currentDisplay = obj_lst.getSelectionModel().getSelectedItem();
        int index = items.indexOf(currentDisplay);
        Object next = asset_list.get(index);
        XYChart.Series series = new XYChart.Series();
        series.setName(currentDisplay);

        if (next instanceof Currency) {
            List<Integer> ints = ((Currency) next).getChanges();
            for (int d = 0; d < 10; d++) {
                series.getData().add(new XYChart.Data<>(Integer.toString(d*10), ints.get(d)));
            }
        } else if (next instanceof Commodity) {
            List<Integer> ints = ((Commodity) next).getChanges();
            for (int d = 0; d < 10; d++) {
                series.getData().add(new XYChart.Data<>(Integer.toString(d*10), ints.get(d)));
            }
        } else if (next instanceof Share) {
            List<Integer> ints = ((Share) next).getChanges();
            for (int d = 0; d < 10; d++) {
                series.getData().add(new XYChart.Data<>(Integer.toString(d*10), ints.get(d)));
            }
        } else if (next instanceof Fund) {
            List<Integer> ints = ((Fund) next).getChanges();
            for (int d = 0; d < 10; d++) {
                series.getData().add(new XYChart.Data<>(Integer.toString(d*10), ints.get(d)));
            }
        }
        lineChart.getData().add(series);
    }

    @FXML
    void clearGraph(ActionEvent event) {
        lineChart.getData().clear();
    }
}