package com.mannydev.wexhelperpro.model.coins;


import com.mannydev.wexhelperpro.controller.Price;
import com.mannydev.wexhelperpro.controller.Profit;
import com.mannydev.wexhelperpro.model.Coin;
import com.mannydev.wexhelperpro.model.Pair;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by manny on 15.04.18.
 */

public class BitcoinCash extends Coin {
    private static final double KOMSA = 0.002;
    private static final String RUB = "RUB";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String BTC = "BTC";
    private static final String ETH = "ETH";
    private static final String LTC = "LTC";
    private static final String ZEC = "ZEC";
    private static final String DSH = "DSH";

    public BitcoinCash(Pair altBtc, Pair altDsh, Pair altEth, Pair altEur, Pair altLtc, Pair altRur, Pair altUsd, Pair altZec, Pair btcUsd, Pair dshUsd, Pair ethUsd, Pair eurUsd, Pair ltcUsd, Pair usdRur, Pair zecUsd) {
        super("BCH", altBtc, altDsh, altEth, altEur, altLtc, altRur, altUsd, altZec, btcUsd, dshUsd, ethUsd, eurUsd, ltcUsd, usdRur, zecUsd);
        rightNowBuyProfit = getRightNowBuyUsdProfit();
        rightNowSellProfit = getRightNowSellUsdProfit();
    }

    @Override
    public String getRightNowBuyUsdProfit() {
        double buyForUsd = 1/usdBuy-1/usdBuy*KOMSA;
        double buyForRur = Profit.getRurBuy(rurSell,usdRur);
        double buyForEur = Profit.getEurBuy(eurSell,eurUsd);
        double buyForBtc = Profit.getBtcBuy(btcSell,btcUsd);
        double buyForLtc = Profit.getLtcBuy(ltcSell,ltcUsd);
        double buyForEth = Profit.getEthBuy(ethSell,ethUsd);
        double buyForZec = Profit.getZecBuy(zecSell,zecUsd);
        double buyForDsh = Profit.getDshBuy(dshSell,dshUsd);

        ArrayList<Double> list = new ArrayList<>();
        list.add(buyForBtc); list.add(buyForEth); list.add(buyForEur);
        list.add(buyForLtc); list.add(buyForRur); list.add(buyForUsd);
        list.add(buyForZec); list.add(buyForDsh);
        Collections.sort(list);

        if(list.get(list.size()-1)==buyForBtc){
            double btcBuyProfit = buyForBtc * 100 / buyForUsd - 100;
            return "Buy now: BTC (+" + roundResult(btcBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForEth){
            double ethBuyProfit = buyForEth * 100 / buyForUsd - 100;
            return "Buy now: ETH (+" + roundResult(ethBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForEur){
            double eurBuyProfit = buyForEur * 100 / buyForUsd - 100;
            return "Buy now: EUR (+" + roundResult(eurBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForLtc){
            double ltcBuyProfit = buyForLtc * 100 / buyForUsd - 100;
            return "Buy now: LTC (+" + roundResult(ltcBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForRur){
            double rurBuyProfit = buyForRur * 100 / buyForUsd - 100;
            return "Buy now: RUB (+" + roundResult(rurBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForUsd){
            double usdBuyProfit = buyForUsd * 100 / buyForRur - 100;
            return "Buy now: USD (+" + roundResult(usdBuyProfit) + "%)";
        }

        if(list.get(list.size()-1)==buyForZec){
            double zecBuyProfit = buyForZec * 100 / buyForUsd - 100;
            return "Buy now: ZEC (+" + roundResult(zecBuyProfit) + "%)";
        }
        if(list.get(list.size()-1)==buyForDsh){
            double dshBuyProfit = buyForDsh * 100 / buyForUsd - 100;
            return "Buy now: DSH (+" + roundResult(dshBuyProfit) + "%)";
        }

        return "Buy now: USD";
    }

    @Override
    public String getRightNowSellUsdProfit() {
        double sellForUsd = usdBuy-usdBuy*KOMSA;
        double sellForRur = Profit.getRurSell(rurBuy,usdRur);
        double sellForEur = Profit.getEurSell(eurBuy,eurUsd);
        double sellForBtc = Profit.getBtcSell(btcBuy,btcUsd);
        double sellForLtc = Profit.getLtcSell(ltcBuy,ltcUsd);
        double sellForEth = Profit.getEthSell(ethBuy,ethUsd);
        double sellForZec = Profit.getZecSell(zecBuy,zecUsd);
        double sellForDsh = Profit.getDshSell(dshBuy,dshUsd);

        ArrayList<Double>list = new ArrayList<>();
        list.add(sellForBtc); list.add(sellForEth); list.add(sellForEur);
        list.add(sellForLtc); list.add(sellForRur); list.add(sellForUsd);
        list.add(sellForZec); list.add(sellForDsh);
        Collections.sort(list);

        if(list.get(list.size()-1)==sellForBtc){
            double btcSellProfit = sellForBtc * 100 / sellForUsd - 100;
            return "Sell now: BTC (+" + roundResult(btcSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForEth){
            double ethSellProfit = sellForEth * 100 / sellForUsd - 100;
            return "Sell now: ETH (+" + roundResult(ethSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForEur){
            double eurSellProfit = sellForEur * 100 / sellForUsd - 100;
            return "Sell now: EUR (+" + roundResult(eurSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForLtc){
            double ltcSellProfit = sellForLtc * 100 / sellForUsd - 100;
            return "Sell now: LTC (+" + roundResult(ltcSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForRur){
            double rubSellProfit = sellForRur * 100 / sellForUsd - 100;
            return "Sell now: RUB (+" + roundResult(rubSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForUsd){
            double usdSellProfit = sellForUsd * 100 / sellForRur - 100;
            return "Sell now: USD (+" + roundResult(usdSellProfit) + "%)";
        }

        if(list.get(list.size()-1)==sellForZec){
            double zecSellProfit = sellForZec * 100 / sellForRur - 100;
            return "Sell now: ZEC (+" + roundResult(zecSellProfit) + "%)";
        }
        if(list.get(list.size()-1)==sellForDsh){
            double dshSellProfit = sellForDsh * 100 / sellForRur - 100;
            return "Sell now: DSH (+" + roundResult(dshSellProfit) + "%)";
        }

        return "Sell now: USD";
    }

    @Override
    public String getBestBuyProfit() {
        double buyInUsd = usdBuy;
        double buyInRur = Price.getRurBuyPrice(rurBuy,usdRur);
        double buyInEur = Price.getCoinBuyPrice(eurBuy,eurUsd);
        double buyInBtc = Price.getCoinBuyPrice(btcBuy,btcUsd);
        double buyInEth = Price.getCoinBuyPrice(ethBuy,ethUsd);
        double buyInLtc = Price.getCoinBuyPrice(ltcBuy,ltcUsd);
        double buyInZec = Price.getCoinBuyPrice(zecBuy,zecUsd);
        double buyInDsh = Price.getCoinBuyPrice(dshBuy,dshUsd);

        ArrayList<Double>list = new ArrayList<>();
        list.add(buyInBtc); list.add(buyInEth); list.add(buyInEur);
        list.add(buyInLtc); list.add(buyInRur); list.add(buyInUsd);
        list.add(buyInZec); list.add(buyInDsh);

        Collections.sort(list);

        if (list.get(0)==buyInBtc){
            return BTC;
        }
        if (list.get(0)==buyInEth){
            return ETH;
        }
        if (list.get(0)==buyInEur){
            return EUR;
        }
        if (list.get(0)==buyInLtc){
            return LTC;
        }
        if (list.get(0)==buyInRur){
            return RUB;
        }
        if (list.get(0)==buyInUsd){
            return USD;
        }
        if (list.get(0)==buyInZec){
            return ZEC;
        }
        if (list.get(0)==buyInDsh){
            return DSH;
        }
        return USD;
    }

    @Override
    public String getBestSellProfit() {
        double sellInUsd = usdSell;
        double sellInRub = Price.getRurSellPrice(rurSell,usdRur);
        double sellInEur = Price.getCoinSellPrice(eurSell,eurUsd);
        double sellInBtc = Price.getCoinSellPrice(btcSell,btcUsd);
        double sellInEth = Price.getCoinSellPrice(ethSell,ethUsd);
        double sellInLtc = Price.getCoinSellPrice(ltcSell,ltcUsd);
        double sellInZec = Price.getCoinSellPrice(zecSell,zecUsd);
        double sellInDsh = Price.getCoinSellPrice(dshSell,dshUsd);

        ArrayList<Double>list = new ArrayList<>();
        list.add(sellInBtc); list.add(sellInEth); list.add(sellInEur);
        list.add(sellInLtc); list.add(sellInRub); list.add(sellInUsd);
        list.add(sellInZec); list.add(sellInDsh);
        Collections.sort(list);

        if(list.get(list.size()-1)==sellInBtc){
            return BTC;
        }
        if(list.get(list.size()-1)==sellInEth){
            return ETH;
        }
        if(list.get(list.size()-1)==sellInEur){
            return EUR;
        }
        if(list.get(list.size()-1)==sellInLtc){
            return LTC;
        }
        if(list.get(list.size()-1)==sellInRub){
            return RUB;
        }
        if(list.get(list.size()-1)==sellInUsd){
            return USD;
        }
        if(list.get(list.size()-1)==sellInZec){
            return ZEC;
        }
        if(list.get(list.size()-1)==sellInDsh){
            return DSH;
        }
        return USD;
    }
}
