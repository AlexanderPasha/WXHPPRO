package com.mannydev.wexhelperpro.model.coins;

import com.mannydev.wexhelperpro.controller.Price;
import com.mannydev.wexhelperpro.controller.Profit;
import com.mannydev.wexhelperpro.model.Coin;
import com.mannydev.wexhelperpro.model.Pair;


public class Litecoin extends Coin {
    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String BTC = "BTC";

    public Litecoin(Pair altBtc, Pair altEur, Pair altRur, Pair altUsd, Pair btcUsd, Pair eurUsd, Pair usdRur) {
        super("LTC", altBtc, null, null, altEur, null, altRur, altUsd, null, btcUsd, null, null, eurUsd, null, usdRur, null);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        double buyForUsd = 1/usdBuy-1/usdBuy*KOMSA;
        double buyForRur = Profit.getRurBuy(rurSell,usdRur);
        double buyForEur = Profit.getEurBuy(eurSell,eurUsd);
        double buyForBtc = Profit.getBtcBuy(btcSell,btcUsd);

        if(buyForUsd>buyForRur && buyForUsd>buyForEur && buyForUsd>buyForBtc){
            double usdBuyProfit = buyForUsd * 100 / buyForRur - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }
        if(buyForRur>buyForUsd && buyForRur>buyForEur && buyForRur>buyForBtc){
            double rubBuyProfit = buyForRur * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rubBuyProfit) + "%)";
        }
        if(buyForEur>buyForUsd && buyForEur>buyForRur && buyForEur>buyForBtc){
            double eurBuyProfit = buyForEur * 100 / buyForUsd - 100;
            return "Buy now: EUR (+" + roundResult(eurBuyProfit) + "%)";
        }
        if(buyForBtc>buyForUsd && buyForBtc>buyForRur && buyForBtc>buyForEur){
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        return "Buy now: USD";
    }

    @Override
    public String getRightNowSellUsdProfit() {
        double sellForUsd = usdBuy-usdBuy*KOMSA;
        double sellForRur = Profit.getRurSell(rurBuy,usdRur);
        double sellForEur = Profit.getEurSell(eurBuy,eurUsd);
        double sellForBtc = Profit.getBtcSell(btcBuy,btcUsd);

        if(sellForUsd>sellForRur && sellForUsd>sellForEur && sellForUsd>sellForBtc){
            double usdSellProfit = sellForUsd * 100 / sellForRur - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }
        if (sellForRur>sellForUsd && sellForRur>sellForEur && sellForRur>sellForBtc){
            double rubSellProfit = sellForRur * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }
        if (sellForEur>sellForUsd && sellForEur>sellForRur && sellForEur>sellForBtc){
            double eurSellProfit = sellForEur * 100 / sellForUsd - 100;
            return "Sell now: EUR (+" + roundResult(eurSellProfit) + "%)";
        }

        if(sellForBtc>sellForUsd && sellForBtc>sellForRur && sellForBtc>sellForEur){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInRur = Price.getRurBuyPrice(rurBuy,usdRur);
        double buyInEur = Price.getCoinBuyPrice(eurBuy,eurUsd);
        double buyInBtc = Price.getCoinBuyPrice(btcBuy,btcUsd);

        if (buyInRur>buyInUsd && buyInUsd<buyInEur && buyInUsd<buyInBtc){
            return USD;
        }
        if(buyInRur<buyInUsd && buyInRur<buyInEur && buyInRur<buyInBtc){
            return RUB;
        }
        if (buyInEur<buyInUsd && buyInEur<buyInRur && buyInEur<buyInBtc){
            return EUR;
        }
        if (buyInBtc<buyInUsd && buyInBtc<buyInRur && buyInBtc<buyInEur){
            return BTC;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInRub = Price.getRurSellPrice(rurSell,usdRur);
        double sellInEur = Price.getCoinSellPrice(eurSell,eurUsd);
        double sellInBtc = Price.getCoinSellPrice(btcSell,btcUsd);

        if (sellInRub<sellInUsd && sellInUsd>sellInEur && sellInUsd>sellInBtc){
            return USD;
        }
        if (sellInRub>sellInUsd && sellInRub>sellInEur && sellInRub>sellInBtc){
            return RUB;
        }
        if (sellInEur>sellInUsd && sellInEur>sellInRub && sellInEur>sellInBtc){
            return EUR;
        }
        if (sellInBtc>sellInUsd && sellInBtc>sellInRub && sellInBtc>sellInEur){
            return BTC;
        }
        return USD;
    }
}
