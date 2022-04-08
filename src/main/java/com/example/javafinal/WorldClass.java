package com.example.javafinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorldClass {

    public static final int DECREASER_MODIFIER = 15;
    private static int bull = 50; //bull increases -> higher values

    public int getBull(){
        return bull;
    }
    public void setBull(int bull){
        this.bull = bull;
    }

    public double getIncreaser() {
        if (getBull() >= 50) {
            return (getBull() / 10);
        } else {
            return (getBull() / 100);
        }
    }

    public double getDecreaser() {
        if (getBull() >= 50) {
            return (getBull() / 100);
        } else {
            return (getBull() / 10);
        }
    }

    static ArrayList<Commodity> array = new ArrayList <Commodity>();
    static List<String> commodity_name = Arrays.asList("ConchShell", "JunoniaShell", "LightningWhelkShell", "CockleShell",
            "TulipBandedShell", "SandDollarShell", "OliveShell", "MurexShell", "CoquinaShell", "CerithsShell", "WormSnailShell",
            "SpottedSlipperShell", "Limpet", "TurkeyWingShell", "WentletrapShell", "CalicoScallop", "FloridaSpinyJewelbox",
            "JingleShell");

    static ArrayList<Currency> curr_array = new ArrayList<Currency>();
    static List <String> countries = Arrays.asList("Albania", "Bahamas", "Cabo Verde", "Dominican Republic", "Egypt", "Fiji",
            "Greece", "Haiti", "Italy", "Jamaica", "Kenya", "Laos", "Madagascar", "Nepal", "Oman", "Peru", "Rwanda", "Sri Lanka",
            "Tanzania", "United Arab Emirates", "Venezuela", "Yemen", "Zimbabwe");
    static List<String> currency_name = Arrays.asList("Sun", "Sunshine", "Tourist", "Beach", "FlipFlops", "Flippers", "Snorkel",
            "Sunbed", "SunCream", "SunGlasses", "SunShade", "SurfBoard", "StarFish", "Binoculars", "Camera", "BackPack", "Tent",
            "Caravan", "Cruise", "Luggage", "Map", "Lighthouse", "Safari", "WaterPark");

    static ArrayList<CurrencyMarket> curr_market_array = new ArrayList<CurrencyMarket>();
    static List<String> curr_market_name = Arrays.asList("TUI", "FirstChoice", "BalkanHolidays", "RedSea", "RIU", "Olympic",
            "Crystal", "TheGambiaExperience", "SkyTours", "ExpediaGroup", "IntrepidTravel", "Itaka", "DreamTours", "DreamGo",
            "TravelPlanet", "Safari", "RainbowTours", "Coral");

    static ArrayList<CommodityMarket> comm_market_array = new ArrayList<CommodityMarket>();
    static List<String> comm_market_name = Arrays.asList("Clam", "HermitCrab", "Nautilidae", "Scallop", "BuccinumUndatum",
            "KingCrab", "BlueMussel", "Mollusk", "Crustacean", "StarFish", "Bivalvia", "TrueCrab", "Conch", "Mussel",
            "SeaUrchin", "Octopus", "SeaAnemone", "Cockle", "Lobster", "Cephalopod", "Shrimp", "Limpet", "Whelk", "HorseshoeCrab");

    static ArrayList<StockMarket> stock_market_array = new ArrayList<StockMarket>();
    static List<String> stock_market_name = Arrays.asList("GlassSand", "GypsumSand", "DesertSand", "VolcanicSand", "GarnetSand",
            "OlivineSand");

    static ArrayList<Company> companies_array = new ArrayList<Company>();
    static List<String> company_market_name = Arrays.asList("CapellaUbud", "ShintaManiWild", "TripleCreekRanch", "COMOBhutan",
            "AndBeyondSandibe", "CLazyURanch", "CheetahPlains", "SixSenses", "TheBodrumEdition", "DoradoBeach", "Nanuku",
            "ThorntreeRiverLodge", "RoyalChampagne", "Amanyara", "TierraAtacama", "AirelessCourchevel", "HaciendaAltaGracia");

    static ArrayList<Share> shares_array = new ArrayList<Share>();
    static List<String> shares_name = Arrays.asList("Quartz", "Mica", "Agregates", "O.terrigeneous", "Molluscs", "PlanctoniquesForaminifers",
            "BenthiquesForaminifers", "Equinoderms", "OBiogenic");

    static ArrayList<Investor> investors_array = new ArrayList<Investor>();
    static List<String> investors_name = Arrays.asList("Abigay", "Bembe", "Cedella", "Damerae", "Eralia", "Fayard", "Gabrielle",
            "Ife", "Jaqweshia", "Khenan", "Lakresha", "Martisha", "Omario", "Roje", "Shanise", "Tarone", "Usain", "Vea", "Vinisha",
            "Xaviera", "Zidane");
    static List<String> surnames = Arrays.asList("Brown", "Williams", "Smith", "Campbell", "Johnson", "Thompson", "Clarke",
            "Anderson", "Davis", "Wilson", "Lewis", "Edwards", "Francis", "Grant", "Robinson", "Gordon", "Reid", "Henry", "Thomas",
            "Wright", "Steward");

    static ArrayList<Fund> funds_array = new ArrayList<Fund>();
    static List<String> fund_name = Arrays.asList("A", "B", "C", "D");
    static List<String> manager_name = Arrays.asList("Adio", "Brianna", "Chandice", "Dajuan", "Edgerin", "Fayard", "Gabrielle",
            "Ini", "Javel", "Kaleisha", "Libano", "Martisha", "Omario", "Raeni", "Shamar", "Tashelle", "Usain", "Vegas", "Xaviera",
            "Zhade", "Ziggy");

    static ArrayList<StockMarketIndex> stock_indices = new ArrayList<StockMarketIndex>();
    static List<String> index_name = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "R", "S", "T", "U", "W", "V", "X", "Y", "Z");

    public ArrayList<Investor> getInvestorArrayList(){
        return (ArrayList<Investor>) investors_array.clone();
    }
    public void setInvestorArray(ArrayList<Investor> investors_array){
        this.investors_array = investors_array;
    }
    public Commodity getCommodity(int index){
        return array.get(index);
    }
    public ArrayList<Commodity> getCommodityArrayList(){
        return (ArrayList<Commodity>) array.clone();
    }
    public static ArrayList<Currency> getCurrencyArrayList(){
        return (ArrayList<Currency>) curr_array.clone();
    }
    public ArrayList<CurrencyMarket> getCurrMarketArray(){
        return (ArrayList<CurrencyMarket>) curr_market_array.clone();
    }
    public ArrayList<CommodityMarket> getCommMarketArray(){
        return (ArrayList<CommodityMarket>) comm_market_array.clone();
    }
    public ArrayList<StockMarket> getStockMarketArray(){
        return (ArrayList<StockMarket>) stock_market_array.clone();
    }
    public ArrayList<Company> getCompanyArray(){
        return (ArrayList<Company>) companies_array.clone();
    }
    public ArrayList<Share> getShareArray(){
        return (ArrayList<Share>) shares_array.clone();
    }
    public ArrayList<Fund> getFundsArray(){
        return (ArrayList<Fund>) funds_array.clone();
    }
    public void setCommodityArray(ArrayList <Commodity> array) {
        this.array = array;
    }
    public void setCurrencyArray(ArrayList<Currency> curr_array){
        this.curr_array = curr_array;
    }
    public void setCurrencyMarketArray(ArrayList<CurrencyMarket> curr_market_array){
        this.curr_market_array = curr_market_array;
    }
    public void setCommodityMarketArray(ArrayList<CommodityMarket> comm_market_array){
        this.comm_market_array = comm_market_array;
    }
    public void setStockMarketArray(ArrayList<StockMarket> stock_market_array){
        this.stock_market_array = stock_market_array;
    }
    public void setCompanyArray(ArrayList<Company> companies_array){
        this.companies_array = companies_array;
    }
    public void setSharesArray(ArrayList<Share> shares_array){
        this.shares_array = shares_array;
    }
    public void setFundsArray(ArrayList<Fund> funds_array){
        this.funds_array = funds_array;
    }

    public static Commodity createCommodityObject(){
        Random r = new Random();
        Commodity object = new Commodity("NULL", "NULL", "NULL", 0, 0, 0);
        int random_index = r.nextInt(commodity_name.size());
        double price = r.nextInt(267) + 100;
        object.setName("Commodity " + commodity_name.get(random_index)+ price);
        object.setMaxPrice(price);
        object.setMinPrice(price);
        object.setCurrentPrice(price);
        String random_curr = currency_name.get(r.nextInt(currency_name.size()));
        object.setTradingCurrency(random_curr);
        object.setTradingUnit(commodity_name.get(random_index));
        array.add(object);
        return object;
    }

    public static Currency createCurrencyObject(){
        Random r = new Random();
        Currency object = new Currency("NULL", 0, 0, countries);
        int random_index = r.nextInt(commodity_name.size());
        double price = r.nextInt(172) + 100;
        object.setName("Currency " + commodity_name.get(random_index) + "Coin" + price);
        object.setListOfCountries(currency_name);
        object.setBuyCost(price);
        double price2 = r.nextInt(172) + 50;
        object.setSellPrice(price2);
        curr_array.add(object);
        return object;
    }

    public static CurrencyMarket createCurrencyMarket(ArrayList<Currency> curr){
        Random r = new Random();
        int random_curr = r.nextInt(curr.size());
        Currency cur = curr.get(random_curr);
        int random_index = r.nextInt(curr_market_name.size());
        CurrencyMarket object = new CurrencyMarket("NULL", "NULL", "NULL", "NULL", "NULL",
                countries, 0, 0, "NULL", cur, curr_array);
        object.setCurrency(cur);
        object.setCurrencyName(cur.getName());
        int street = r.nextInt(investors_name.size());
        object.setAddress(investors_name.get(street) + " Alley " + street);
        String city = surnames.get(r.nextInt(surnames.size()));
        object.setCity(city);
        int price = r.nextInt(150);
        object.setTransactionMargin(price + 100.23);
        object.setCostOfTrade(price);
        object.setName("Currency Market " + curr_market_name.get(random_index) + "Market" + price);
        String country = countries.get(r.nextInt(countries.size()));
        object.setCountry(country);
        object.setTradingCurrency(cur.getName());
        object.setListOfStockMarketIndices(curr_market_name);
        ArrayList<Currency> mini = new ArrayList<Currency>();
        mini.add(cur);
        object.setCurrencies(mini);
        curr_market_array.add(object);
        return object;
    }

    public static CommodityMarket createCommodityMarket(ArrayList<Commodity> comm){
        Random r = new Random();
        int random_comm = r.nextInt(comm.size());
        Commodity com = comm.get(random_comm);
        int random_index = r.nextInt(comm_market_name.size());
        CommodityMarket object = new CommodityMarket("NULL", "NULL", "NULL", "NULL", "NULL",
                countries, 829.1, 930.22, "NULL", com);
        Currency random_cur = curr_array.get(r.nextInt(curr_array.size()));
        int price = r.nextInt(146);
        object.setName("Commodity Market " + comm_market_name.get(random_index) + "Market" + price);
        object.setTradingCurrency(random_cur.getName());
        int street = r.nextInt(manager_name.size());
        String city = surnames.get(r.nextInt(surnames.size()));
        String country = countries.get(r.nextInt(countries.size()));
        object.setCountry(country);
        object.setCity(city);
        object.setAddress(manager_name.get(street) + " Alley " + street);
        object.setListOfStockMarketIndices(comm_market_name);
        object.setCostOfTrade(price);
        object.setTransactionMargin(price + 86.45);
        object.setCommodityName(com.getName());
        object.setCommodity(com);
        comm_market_array.add(object);
        return object;
    }

    public static StockMarket createStockMarket(ArrayList<Share> shh){
        Random r = new Random();
        int random_index = r.nextInt(stock_market_name.size());
        int random_share = r.nextInt(shh.size());
        Share sh = shh.get(random_share);
        StockMarket object = new StockMarket("NULL", "NULL", "NULL", "NULL", "NULL",
                countries, 91.20, 33.0, sh);
        int street = r.nextInt(investors_name.size());
        String city = surnames.get(r.nextInt(surnames.size()));
        String country = countries.get(r.nextInt(countries.size()));
        int price = r.nextInt(120);
        object.setCountry(country);
        object.setAddress(investors_name.get(street) + " Alley " + street);
        object.setName("Stock Market " + stock_market_name.get(random_index) + price);
        Currency random_cur = curr_array.get(r.nextInt(curr_array.size()));
        object.setTradingCurrency(random_cur.getName());
        object.setCity(city);
        object.setListOfStockMarketIndices(comm_market_name);
        object.setCostOfTrade(price);
        object.setTransactionMargin(price + 50.99);
        object.setShare(sh);
        stock_market_array.add(object);
        return object;
    }

    public static Company createCompany(ArrayList<Fund> fund, ArrayList<Investor> invs){
        Random r = new Random();
        int random_name = r.nextInt(company_market_name.size());
        int random_fund = r.nextInt(fund.size());
        Fund fu = fund.get(random_fund);
        Company object = new Company("NULL", "NULL", 0, 0, 0, 0,
                0, 0, 0, "NULL", 0, 0, fu, invs, shares_array);
        int price = r.nextInt(50);
        object.setName("Company " + company_market_name.get(random_name) + price);
        object.setIPOdate("24.10.1923");
        object.setIPOshareValue(price);
        object.setOpeningPrice(price + 187.37);
        object.setCurrentPrice(price + 187.37);
        object.setMinPrice(price + 187.37);
        object.setMaxPrice(price + 187.37);
        object.setProfit(price + 82.29);
        object.setRevenue(price + 82.29);
        String capital = investors_name.get(r.nextInt(investors_name.size()));
        object.setCapital(capital);
        object.setTradingVolume(0);
        object.setTotalSales(0);
        object.setFund(fu);
        object.setInvestorList(invs);

        int random_num = r.nextInt(5);
        ArrayList<Share> shs = new ArrayList<Share>();

        for (int e = 0; e<random_num; e++){
            Share sh = createShare(object);
            shs.add(sh);
            shares_array.add(sh);
        }
        object.setShares(shs);
        companies_array.add(object);
        return object;
    }

    public static Investor createInvestor(){
        Random r = new Random();
        int random_name = r.nextInt(investors_name.size());
        int random_surname = r.nextInt(surnames.size());
        int random_num = r.nextInt(8999) + 1000;
        Investor object = new Investor("NULL", "NULL", "NULL", 0, shares_array,
                curr_array, array, funds_array);
        object.setFirstName("Investor " + investors_name.get(random_name));
        object.setLastName(surnames.get(random_surname));
        object.setTradingIdentifier(Character.toString(object.getFirstName().charAt(0))
                + Character.toString(object.getLastName().charAt(0)) + random_num);
        object.setInvestmentBudget(random_num + r.nextInt(10000));

        ArrayList<Share> shs = new ArrayList<Share>();
        object.setShares(shs);

        ArrayList<Currency> crs = new ArrayList<Currency>();
        object.setCurrencies(crs);

        ArrayList<Commodity> cms = new ArrayList<Commodity>();
        object.setCommodities(cms);

        ArrayList<Fund> fds = new ArrayList<Fund>();
        object.setFunds(fds);

        investors_array.add(object);
        return object;
    }

    public static Fund createFund(){
        Random r = new Random();
        int random_name = r.nextInt(fund_name.size());
        int random_surname = r.nextInt(surnames.size());
        int random_mname = r.nextInt(manager_name.size());
        Fund object = new Fund("NULL", "NULL", 0, shares_array, array, curr_array);
        object.setName("Fund " + fund_name.get(random_name) + random_name);
        object.setManagerInfo(manager_name.get(random_mname) + " " + surnames.get(random_surname));
        object.setPrice(r.nextInt(300));

        ArrayList<Share> shs = new ArrayList<Share>();
        if (shares_array.size() > 0){
            shs.add(shares_array.get(r.nextInt(shares_array.size())));}
        ArrayList<Commodity> com = new ArrayList<Commodity>();
        if (array.size() > 0){
            com.add(array.get(r.nextInt(array.size())));}
        ArrayList<Currency> cur = new ArrayList<Currency>();
        if (curr_array.size() > 0){
            cur.add(curr_array.get(r.nextInt(curr_array.size())));}

        object.setShares(shs);
        object.setCommodities(com);
        object.setCurrencies(cur);
        funds_array.add(object);
        return object;
    }

    public static StockMarketIndex createIndex(ArrayList <Company> comps){
        Random r = new Random();
        int num_of_companies = r.nextInt(2, companies_array.size());
        ArrayList<Company> cps = new ArrayList<Company>();
        double value = 0;

        for (int e = 0; e <= num_of_companies; e++){
            int ind = r.nextInt(companies_array.size());
            Company cpn = companies_array.get(ind);
            ArrayList <Share> srs = cpn.getShares();
            for (int i = 0; i < srs.size(); i++){
                Share s = srs.get(i);
                value += s.getValue();
            }
            if (cps.contains(cpn) == false){
                cps.add(cpn);
                }
            }

        StockMarketIndex object = new StockMarketIndex("NULL", companies_array, 0);
        object.setNamesOfCompanies(cps);
        object.setValue(value);
        int random_name = r.nextInt(index_name.size());
        object.setName("Index " + index_name.get(random_name) + value);
        stock_indices.add(object);
        return object;
    }

    public static Share createShare(Company comp){
        Share sh = new Share("NULL", 0, comp);
        Random r = new Random();
        int ind = r.nextInt(shares_name.size());
        int price = r.nextInt(355);
        sh.setValue(price);
        sh.setName("Share " + shares_name.get(ind) + price);
        return sh;
    }

    public static void addSharesArray(Share share){
        shares_array.add(share);
    }

    public Currency currencyChange(Currency currency){
        ArrayList<Currency> curs = new ArrayList<Currency>(getCurrencyArrayList());
        currency.setBuyCost(currency.getBuyCost() + (40 * getIncreaser()));
        currency.setSellPrice(currency.getSellPrice() + (30 * getIncreaser()));
        currency.setNewChanges(currency.getBuyCost());
        curs.remove(currency);
        for (int c = 0; c < curs.size(); c++){
            Currency cr = curs.get(c);
            cr.setBuyCost(cr.getBuyCost() - (5 * getDecreaser()));
            cr.setSellPrice(cr.getSellPrice() - (10 * getDecreaser()));
            if (cr.getBuyCost() < 0){
                cr.setBuyCost(0);
            }
            if (cr.getSellPrice() < 0){
                cr.setSellPrice(0);
            }
            cr.setNewChanges(cr.getBuyCost());
        }
        curs.add(currency);
        setCurrencyArray(curs);
        return currency;
    }

    public Share shareChange(Share share){
        ArrayList<Share> shars = new ArrayList<Share>(getShareArray());
        share.setValue(share.getValue() + (25 * getIncreaser()));
        shars.remove(share);
        share.setNewChanges(share.getValue());
        for (int s = 0; s < shars.size(); s++){
            Share ss = shars.get(s);
            ss.setValue(ss.getValue() - (10 * getDecreaser()));
            if (ss.getValue() < 0){
                ss.setValue(0);
            }
            ss.setNewChanges(ss.getValue());
        }
        shars.add(share);
        setSharesArray(shars);
        return share;
    }

    public Commodity commodityChange(Commodity commodity){
        ArrayList<Commodity> coms = new ArrayList<Commodity>(getCommodityArrayList());
        double price = commodity.getCurrentPrice() + (40* getIncreaser());
        commodity.setCurrentPrice(price);
        commodity.setNewChanges(commodity.getCurrentPrice());
        if (commodity.getCurrentPrice() > commodity.getMaxPrice()){
            commodity.setMaxPrice(commodity.getCurrentPrice());
        }
        coms.remove(commodity);
        for (int c = 0; c < coms.size(); c++){
            Commodity cc = coms.get(c);
            cc.setCurrentPrice(cc.getCurrentPrice() - (DECREASER_MODIFIER * getDecreaser()));
            if (cc.getCurrentPrice() < 0){
                cc.setCurrentPrice(0);
            }
            if (cc.getCurrentPrice() < cc.getMinPrice()){
                cc.setMinPrice(cc.getCurrentPrice());
            }
            cc.setNewChanges(cc.getCurrentPrice());
        }
        coms.add(commodity);
        setCommodityArray(coms);
        //System.out.println(commodity.getCurrentPrice());
        return commodity;
    }

    public Fund fundChange(Fund fund){
        ArrayList<Fund> fds = new ArrayList<Fund>(getFundsArray());
        fund.setPrice(fund.getPrice() + (30 * getIncreaser()));
        fund.setNewChanges(fund.getPrice());
        fds.remove(fund);
        for (int f = 0; f < fds.size(); f++){
            Fund ff = fds.get(f);
            ff.setPrice(ff.getPrice() - (20 * getDecreaser()));
            if (ff.getPrice() < 0){
                ff.setPrice(0);
            }
            ff.setNewChanges(ff.getPrice());
        }
        fds.add(fund);
        setFundsArray(fds);
        return fund;
    }
}
