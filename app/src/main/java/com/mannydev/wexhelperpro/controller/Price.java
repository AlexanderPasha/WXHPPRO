package com.mannydev.wexhelperpro.controller;

import com.mannydev.wexhelperpro.model.Pair;



public class Price {
    private static final double KOMSA = 0.002;

    public static double getRurBuyPrice(double rubBuy, Pair usdRur){
        double step1 = rubBuy-rubBuy*KOMSA;
        double step2 = step1/usdRur.getBuy();
        double step3 = step2-step2*KOMSA;
        return step3;
    }

    public static double getCoinBuyPrice(double coinBuy, Pair coinUsd){
        double step1 = coinBuy-coinBuy*KOMSA;
        double step2 = step1*coinUsd.getSell();
        double step3 = step2-step2*KOMSA;
        return step3;
    }

    public static double getRurSellPrice (double rurSell, Pair usdRur){
        double step1 = rurSell-rurSell*KOMSA;
        double step2 = step1/usdRur.getBuy();
        double step3 = step2-step2*KOMSA;
        return step3;
    }

    public static double getCoinSellPrice (double coinSell, Pair coinUsd){
        double step1 = coinSell-coinSell*KOMSA;
        double step2 = step1*coinUsd.getSell();
        double step3 = step2-step2*KOMSA;
        return step3;
    }

}
