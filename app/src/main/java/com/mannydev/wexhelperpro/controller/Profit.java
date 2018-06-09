package com.mannydev.wexhelperpro.controller;

import com.mannydev.wexhelperpro.model.Pair;


public class Profit {
    private static final double KOMSA = 0.002;

    public static double getRurBuy(double rurSell, Pair usdRur){
        double buyForRubstep1 = 1 * usdRur.getSell();
        double buyForRubStep2 = buyForRubstep1 - buyForRubstep1 * KOMSA;//комиссия
        double buyForRubStep3 = buyForRubStep2 / rurSell;
        double buyForRub = buyForRubStep3 - buyForRubStep3 * KOMSA;//комиссия
        return buyForRub;
    }

    public static double getBtcBuy(double btcSell, Pair btcUsd){
        double buyForBtcstep1 = 1 / btcUsd.getBuy();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / btcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия
        return buyForBtc;
    }

    public static double getDshBuy(double dshSell, Pair dshUsd){
        double buyForBtcstep1 = 1 / dshUsd.getBuy();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / dshSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия
        return buyForBtc;
    }

    public static double getEthBuy(double ethSell, Pair ethUsd){
        double buyForBtcstep1 = 1 / ethUsd.getBuy();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / ethSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия
        return buyForBtc;
    }

    public static double getEurBuy(double eurSell, Pair eurUsd){
        double buyForBtcstep1 = 1 / eurUsd.getBuy();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / eurSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия
        return buyForBtc;
    }

    public static double getLtcBuy(double ltcSell, Pair ltcUsd){
        double buyForBtcstep1 = 1 / ltcUsd.getBuy();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / ltcSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия
        return buyForBtc;
    }

    public static double getZecBuy(double zecSell, Pair zecUsd){
        double buyForBtcstep1 = 1 / zecUsd.getBuy();
        double buyForBtcStep2 = buyForBtcstep1 - buyForBtcstep1 * KOMSA;//комиссия
        double buyForBtcStep3 = buyForBtcStep2 / zecSell;
        double buyForBtc = buyForBtcStep3 - buyForBtcStep3 * KOMSA;//комиссия
        return buyForBtc;
    }

    public static double getRurSell(double rurBuy, Pair usdRur){
        double sellStep1 = 1 * rurBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 / usdRur.getBuy();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

    public static double getBtcSell(double btcBuy, Pair btcUsd){
        double sellStep1 = 1 * btcBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 * btcUsd.getSell();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

    public static double getDshSell(double dshBuy, Pair dshUsd){
        double sellStep1 = 1 * dshBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 * dshUsd.getSell();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

    public static double getEthSell(double ethBuy, Pair ethUsd){
        double sellStep1 = 1 * ethBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 * ethUsd.getSell();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

    public static double getEurSell(double eurBuy, Pair eurUsd){
        double sellStep1 = 1 * eurBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 * eurUsd.getSell();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

    public static double getLtcSell(double ltcBuy, Pair ltcUsd){
        double sellStep1 = 1 * ltcBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 * ltcUsd.getSell();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

    public static double getZecSell(double zecBuy, Pair zecUsd){
        double sellStep1 = 1 * zecBuy;
        double sellStep2 = sellStep1 - sellStep1 * KOMSA;
        double sellStep3 = sellStep2 * zecUsd.getSell();
        double sellProfit = sellStep3 - sellStep3 * KOMSA;
        return sellProfit;
    }

}
