package com.mannydev.wexhelperpro.model.coins;

import com.mannydev.wexhelperpro.controller.Price;
import com.mannydev.wexhelperpro.controller.Profit;
import com.mannydev.wexhelperpro.model.Coin;
import com.mannydev.wexhelperpro.model.Pair;

import java.util.ArrayList;
import java.util.Collections;


public class ZecCoin extends Coin {
    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String BTC = "BTC";
    private static final String ETH = "ETH";
    private static final String LTC = "LTC";
    private static final String ZEC = "ZEC";

    public ZecCoin(Pair altBtc, Pair altLtc, Pair altUsd, Pair btcUsd, Pair ltcUsd) {
        super("ZEC", altBtc, null, null, null, altLtc, null, altUsd, null, btcUsd, null, null, null, ltcUsd, null, null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        double buyForUsd = 1/usdBuy-1/usdBuy*KOMSA;
        double buyForBtc = Profit.getBtcBuy(btcSell,btcUsd);
        double buyForLtc = Profit.getLtcBuy(ltcSell,ltcUsd);

        ArrayList<Double> list = new ArrayList<>();
        list.add(buyForBtc);
        list.add(buyForLtc); list.add(buyForUsd);

        Collections.sort(list);

        if(list.get(list.size()-1)==buyForBtc){
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForLtc){
            double ltcBuyProfit = buyForLtc * 100 / buyForUsd - 100;
            return "Buy now: LTC (+" + roundResult(ltcBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForUsd){
            double usdBuyProfit = buyForUsd * 100 / buyForBtc - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

        return "Buy now: USD";
    }

    @Override
    public String getRightNowSellUsdProfit() {
        double sellForUsd = usdBuy-usdBuy*KOMSA;
        double sellForBtc = Profit.getBtcSell(btcBuy,btcUsd);
        double sellForLtc = Profit.getLtcSell(ltcBuy,ltcUsd);

        ArrayList<Double>list = new ArrayList<>();
        list.add(sellForBtc);
        list.add(sellForLtc);list.add(sellForUsd);

        Collections.sort(list);

        if(list.get(list.size()-1)==sellForBtc){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForLtc){
            double ltcSellProfit = sellForLtc * 100 / sellForUsd - 100;
            return "Sell now: LTC (+" + roundResult(ltcSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForUsd){
            double usdSellProfit = sellForUsd * 100 / sellForBtc - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInBtc = Price.getCoinBuyPrice(btcBuy,btcUsd);
        double buyInLtc = Price.getCoinBuyPrice(ltcBuy,ltcUsd);

        ArrayList<Double>list = new ArrayList<>();
        list.add(buyInBtc);
        list.add(buyInLtc); list.add(buyInUsd);

        Collections.sort(list);

        if (list.get(0)==buyInBtc){
            return BTC;
        }

        if (list.get(0)==buyInLtc){
            return LTC;
        }

        if (list.get(0)==buyInUsd){
            return USD;
        }

        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInBtc = Price.getCoinSellPrice(btcSell,btcUsd);
        double sellInLtc = Price.getCoinSellPrice(ltcSell,ltcUsd);

        ArrayList<Double> list = new ArrayList<>();
        list.add(sellInBtc);
        list.add(sellInLtc); list.add(sellInUsd);

        Collections.sort(list);

        if(list.get(list.size()-1)==sellInBtc){
            return BTC;
        }

        if(list.get(list.size()-1)==sellInLtc){
            return LTC;
        }

        if(list.get(list.size()-1)==sellInUsd){
            return USD;
        }

        return USD;
    }
}
