package com.mannydev.wexhelperpro.model;

import com.mannydev.wexhelperpro.model.coins.Bitcoin;
import com.mannydev.wexhelperpro.model.coins.BitcoinCash;
import com.mannydev.wexhelperpro.model.coins.Dashcoin;
import com.mannydev.wexhelperpro.model.coins.Etherium;
import com.mannydev.wexhelperpro.model.coins.Litecoin;
import com.mannydev.wexhelperpro.model.coins.Namecoin;
import com.mannydev.wexhelperpro.model.coins.Novacoin;
import com.mannydev.wexhelperpro.model.coins.Peercoin;
import com.mannydev.wexhelperpro.model.coins.ZecCoin;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import lombok.Getter;




public class Controller implements Observer {
    Observable observable;
    @Getter ArrayList<Coin>coins;

    private Coin btc, ltc, nmc, nvc, ppc, dsh, eth, bch, zec;

    public Controller(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
        this.coins = new ArrayList<>();
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Wex) {
            Wex wex = (Wex) observable;
            updateCoins(wex);
        }else{
        }
    }

    private void updateCoins(Wex wex) {
        this.btc = new Bitcoin(wex.getBtcEur(),wex.getBtcRur(),wex.getBtcUsd(),wex.getEurUsd(),wex.getUsdRur());
        this.ltc = new Litecoin(wex.getLtcBtc(),wex.getLtcEur(),wex.getLtcRur(),wex.getLtcUsd(),wex.getBtcUsd(),wex.getEurUsd(),wex.getUsdRur());
        this.nmc = new Namecoin(wex.getNmcBtc(),wex.getNmcUsd(),wex.getBtcUsd());
        this.nvc = new Novacoin(wex.getNvcBtc(),wex.getNvcUsd(),wex.getBtcUsd());
        this.ppc = new Peercoin(wex.getPpcBtc(),wex.getPpcUsd(),wex.getBtcUsd());
        this.dsh = new Dashcoin(wex.getDshBtc(),wex.getDshEth(),wex.getDshEur(),wex.getDshLtc(),wex.getDshRur(),wex.getDshUsd(),wex.getDshZec(),wex.getBtcUsd(),wex.getEthUsd(),wex.getEurUsd(),wex.getLtcUsd(),wex.getUsdRur(),wex.getZecUsd());
        this.eth = new Etherium(wex.getEthBtc(),wex.getEthEur(),wex.getEthLtc(),wex.getEthRur(),wex.getEthUsd(),wex.getEthZec(),wex.getBtcUsd(),wex.getEurUsd(),wex.getLtcUsd(),wex.getUsdRur(),wex.getZecUsd());
        this.bch = new BitcoinCash(wex.getBchBtc(),wex.getBchDsh(),wex.getBchEth(),wex.getBchEur(),wex.getBchLtc(),wex.getBchRur(),wex.getBchUsd(),wex.getBchZec(),wex.getBtcUsd(),wex.getDshUsd(),wex.getEthUsd(),wex.getEurUsd(),wex.getLtcUsd(),wex.getUsdRur(),wex.getZecUsd());
        this.zec = new ZecCoin(wex.getZecBtc(),wex.getZecLtc(),wex.getZecUsd(),wex.getBtcUsd(),wex.getLtcUsd());

        addCoinsToList();

    }

    private void addCoinsToList() {
        coins = new ArrayList<>();
        coins.add(btc);
        coins.add(ltc);
        coins.add(eth);
        coins.add(dsh);
        coins.add(bch);
        coins.add(nmc);
        coins.add(nvc);
        coins.add(ppc);
        coins.add(zec);
    }
}
