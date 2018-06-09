package com.mannydev.wexhelperpro.model;

import lombok.Getter;
import lombok.Setter;


public class Coin {
    private static final double KOMSA = 0.002;
    @Getter @Setter private String name;

    protected String rightNowBuyProfit;
    protected String rightNowSellProfit;

    protected Pair btcUsd, dshUsd,ethUsd,eurUsd,ltcUsd,usdRur,zecUsd;

    @Getter @Setter protected double btcBuy,btcSell;
    @Getter @Setter protected String btcSprd;

    @Getter @Setter protected double dshBuy,dshSell;
    @Getter @Setter protected String dshSprd;

    @Getter @Setter protected double ethBuy,ethSell;
    @Getter @Setter protected String ethSprd;

    @Getter @Setter protected double eurBuy,eurSell;
    @Getter @Setter protected String eurSprd;

    @Getter @Setter protected double ltcBuy,ltcSell;
    @Getter @Setter protected String ltcSprd;

    @Getter @Setter protected double rurBuy,rurSell;
    @Getter @Setter protected String rurSprd;

    @Getter @Setter protected double usdBuy,usdSell;
    @Getter @Setter protected String usdSprd;

    @Getter @Setter protected double zecBuy,zecSell;
    @Getter @Setter protected String zecSprd;

    public Coin (String name, Pair altBtc, Pair altDsh, Pair altEth, Pair altEur, Pair altLtc, Pair altRur, Pair altUsd, Pair altZec, Pair btcUsd, Pair dshUsd, Pair ethUsd, Pair eurUsd, Pair ltcUsd, Pair usdRur, Pair zecUsd){
        this.name = name;

        if(altBtc!=null){
            this.btcBuy = altBtc.getSell();
            this.btcSell = altBtc.getBuy();
            this.btcSprd = getSpread(btcBuy,btcSell);
        }

        if(altDsh!=null){
            this.dshBuy = altDsh.getSell();
            this.dshSell = altDsh.getBuy();
            this.dshSprd = getSpread(dshBuy,dshSell);
        }

        if(altEth!=null){
            this.ethBuy = altEth.getSell();
            this.ethSell = altEth.getBuy();
            this.ethSprd = getSpread(ethBuy,ethSell);
        }

        if(altEur!=null){
            this.eurBuy = altEur.getSell();
            this.eurSell = altEur.getBuy();
            this.eurSprd = getSpread(eurBuy,eurSell);
        }

        if(altLtc!=null){
            this.ltcBuy = altLtc.getSell();
            this.ltcSell = altLtc.getBuy();
            this.ltcSprd = getSpread(ltcBuy,ltcSell);
        }

        if(altRur!=null){
            this.rurBuy = altRur.getSell();
            this.rurSell = altRur.getBuy();
            this.rurSprd = getSpread(rurBuy,rurSell);
        }

        if(altUsd!=null){
            this.usdBuy = altUsd.getSell();
            this.usdSell = altUsd.getBuy();
            this.usdSprd = getSpread(usdBuy,usdSell);
        }

        if(altZec!=null){
            this.zecBuy = altZec.getSell();
            this.zecSell = altZec.getBuy();
            this.zecSprd = getSpread(zecBuy,zecSell);
        }

        if (btcUsd!=null){
            this.btcUsd = btcUsd;
        }

        if (dshUsd!=null){
            this.dshUsd = dshUsd;
        }

        if (ethUsd!=null){
            this.ethUsd = ethUsd;
        }

        if (eurUsd!=null){
            this.eurUsd = eurUsd;
        }

        if (ltcUsd!=null){
            this.ltcUsd = ltcUsd;
        }

        if (usdRur!=null){
            this.usdRur = usdRur;
        }

        if (zecUsd!=null){
            this.zecUsd = zecUsd;
        }

    }


    public String getRightNowBuyUsdProfit(){return null;}

    public String getRightNowSellUsdProfit(){return null;}

    public String getBestBuyProfit(){return null;}

    public String getBestSellProfit(){return null;}

    public static String getSpread(double buy, double sell) {
        double start = 100.0;
        double step1 = start / buy - (start / buy * KOMSA);
        double end = step1 * sell - (step1 * sell * KOMSA);
        double rez = (end - start) * 100 / start;
        return roundResult(rez) + " %";
    }

    public static String roundResult(double d) {
        return String.format("%.2f", d);
    }

}


