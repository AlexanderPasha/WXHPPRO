package com.mannydev.wexhelperpro.model.coins;

import com.mannydev.wexhelperpro.controller.Price;
import com.mannydev.wexhelperpro.controller.Profit;
import com.mannydev.wexhelperpro.model.Coin;
import com.mannydev.wexhelperpro.model.Pair;


public class Novacoin extends Coin {
    private static final double KOMSA = 0.002;
    private static final String USD = "USD";
    private static final String BTC = "BTC";

    public Novacoin(Pair altBtc, Pair altUsd, Pair btcUsd) {
        super("NVC", altBtc, null, null, null, null, null, altUsd, null, btcUsd, null, null, null, null, null, null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        double buyForUsd = 1/usdBuy-1/usdBuy*KOMSA;
        double buyForBtc = Profit.getBtcBuy(btcSell,btcUsd);

        if(buyForUsd>buyForBtc){
            double usdBuyProfit = buyForUsd * 100 / buyForBtc - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }else{
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }
    }

    @Override
    public String getRightNowSellUsdProfit() {
        double sellForUsd = usdBuy-usdBuy*KOMSA;
        double sellForBtc = Profit.getBtcSell(btcBuy,btcUsd);

        if(sellForUsd>sellForBtc){
            double usdSellProfit = sellForUsd * 100 / sellForBtc - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }else{
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInBtc = Price.getCoinBuyPrice(btcBuy,btcUsd);
        if (buyInBtc>buyInUsd){
            return USD;
        }else{
            return BTC;
        }
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInBtc = Price.getCoinSellPrice(btcSell,btcUsd);

        if (sellInBtc<sellInUsd){
            return USD;
        }else{
            return BTC;
        }
    }
}
