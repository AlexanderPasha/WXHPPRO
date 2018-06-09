package com.mannydev.wexhelperpro.model.coins;

import com.mannydev.wexhelperpro.controller.Price;
import com.mannydev.wexhelperpro.controller.Profit;
import com.mannydev.wexhelperpro.model.Coin;
import com.mannydev.wexhelperpro.model.Pair;


public class Bitcoin extends Coin {
    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";
    private static final String EUR = "EUR";

    public Bitcoin(Pair altEur, Pair altRur, Pair altUsd, Pair eurUsd, Pair usdRur) {
        super("BTC", null, null, null, altEur, null, altRur, altUsd, null, null, null, null, eurUsd, null, usdRur, null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        double buyForUsd = 1/usdBuy-1/usdBuy*KOMSA;
        double buyForRur = Profit.getRurBuy(rurSell,usdRur);
        double buyForEur = Profit.getEurBuy(eurSell,eurUsd);

        if(buyForUsd>buyForRur && buyForUsd>buyForEur){
            double usdBuyProfit = buyForUsd * 100 / buyForRur - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }
        if(buyForRur>buyForUsd && buyForRur>buyForEur){
            double rubBuyProfit = buyForRur * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        }
        if(buyForEur>buyForUsd && buyForEur>buyForRur){
            double eurBuyProfit = buyForEur * 100 / buyForUsd - 100;
            return "Buy now: EUR (+" + roundResult(eurBuyProfit) + "%)";
        }

        return "Buy now: USD";
    }

    @Override
    public String getRightNowSellUsdProfit() {
        double sellForUsd = usdBuy-usdBuy*KOMSA;
        double sellForRur = Profit.getRurSell(rurBuy,usdRur);
        double sellForEur = Profit.getEurSell(eurBuy,eurUsd);

        if(sellForUsd>sellForRur && sellForUsd>sellForEur){
            double usdSellProfit = sellForUsd * 100 / sellForRur - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }
        if (sellForRur>sellForUsd && sellForRur>sellForEur){
            double rubSellProfit = sellForRur * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }
        if (sellForEur>sellForUsd && sellForEur>sellForRur){
            double eurSellProfit = sellForEur * 100 / sellForUsd - 100;
            return "Sell now: EUR (+" + roundResult(eurSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInRur = Price.getRurBuyPrice(rurBuy,usdRur);
        double buyInEur = Price.getCoinBuyPrice(eurBuy,eurUsd);
        if (buyInRur>buyInUsd && buyInUsd<buyInEur){
            return USD;
        }
        if(buyInRur<buyInUsd && buyInRur<buyInEur){
            return RUB;
        }
        if (buyInEur<buyInUsd && buyInEur<buyInRur){
            return EUR;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInRub = Price.getRurSellPrice(rurSell,usdRur);
        double sellInEur = Price.getCoinSellPrice(eurSell,eurUsd);
        if (sellInRub<sellInUsd && sellInUsd>sellInEur){
            return USD;
        }
        if (sellInRub>sellInUsd && sellInRub>sellInEur){
            return RUB;
        }
        if (sellInEur>sellInUsd && sellInEur>sellInRub){
            return EUR;
        }
        return USD;
    }
}
