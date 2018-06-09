
package com.mannydev.wexhelperpro.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Observable;

import lombok.Getter;
import lombok.Setter;

public class Wex extends Observable {

    private static Wex wex;

    @SerializedName("btc_usd")
    @Expose
    @Getter
    @Setter
    private Pair btcUsd;
    @SerializedName("btc_rur")
    @Expose
    @Getter
    @Setter
    private Pair btcRur;
    @SerializedName("btc_eur")
    @Expose
    @Getter
    @Setter
    private Pair btcEur;
    @SerializedName("ltc_btc")
    @Expose
    @Getter
    @Setter
    private Pair ltcBtc;
    @SerializedName("ltc_usd")
    @Expose
    @Getter
    @Setter
    private Pair ltcUsd;
    @SerializedName("ltc_rur")
    @Expose
    @Getter
    @Setter
    private Pair ltcRur;
    @SerializedName("ltc_eur")
    @Expose
    @Getter
    @Setter
    private Pair ltcEur;
    @SerializedName("nmc_btc")
    @Expose
    @Getter
    @Setter
    private Pair nmcBtc;
    @SerializedName("nmc_usd")
    @Expose
    @Getter
    @Setter
    private Pair nmcUsd;
    @SerializedName("nvc_btc")
    @Expose
    @Getter
    @Setter
    private Pair nvcBtc;
    @SerializedName("nvc_usd")
    @Expose
    @Getter
    @Setter
    private Pair nvcUsd;
    @SerializedName("usd_rur")
    @Expose
    @Getter
    @Setter
    private Pair usdRur;
    @SerializedName("eur_usd")
    @Expose
    @Getter
    @Setter
    private Pair eurUsd;
    @SerializedName("eur_rur")
    @Expose
    @Getter
    @Setter
    private Pair eurRur;
    @SerializedName("ppc_btc")
    @Expose
    @Getter
    @Setter
    private Pair ppcBtc;
    @SerializedName("ppc_usd")
    @Expose
    @Getter
    @Setter
    private Pair ppcUsd;
    @SerializedName("dsh_btc")
    @Expose
    @Getter
    @Setter
    private Pair dshBtc;
    @SerializedName("dsh_usd")
    @Expose
    @Getter
    @Setter
    private Pair dshUsd;
    @SerializedName("dsh_rur")
    @Expose
    @Getter
    @Setter
    private Pair dshRur;
    @SerializedName("dsh_eur")
    @Expose
    @Getter
    @Setter
    private Pair dshEur;
    @SerializedName("dsh_ltc")
    @Expose
    @Getter
    @Setter
    private Pair dshLtc;
    @SerializedName("dsh_eth")
    @Expose
    @Getter
    @Setter
    private Pair dshEth;
    @SerializedName("dsh_zec")
    @Expose
    @Getter
    @Setter
    private Pair dshZec;
    @SerializedName("eth_btc")
    @Expose
    @Getter
    @Setter
    private Pair ethBtc;
    @SerializedName("eth_usd")
    @Expose
    @Getter
    @Setter
    private Pair ethUsd;
    @SerializedName("eth_eur")
    @Expose
    @Getter
    @Setter
    private Pair ethEur;
    @SerializedName("eth_ltc")
    @Expose
    @Getter
    @Setter
    private Pair ethLtc;
    @SerializedName("eth_rur")
    @Expose
    @Getter
    @Setter
    private Pair ethRur;
    @SerializedName("eth_zec")
    @Expose
    @Getter
    @Setter
    private Pair ethZec;
    @SerializedName("bch_usd")
    @Expose
    @Getter
    @Setter
    private Pair bchUsd;
    @SerializedName("bch_btc")
    @Expose
    @Getter
    @Setter
    private Pair bchBtc;
    @SerializedName("bch_rur")
    @Expose
    @Getter
    @Setter
    private Pair bchRur;
    @SerializedName("bch_eur")
    @Expose
    @Getter
    @Setter
    private Pair bchEur;
    @SerializedName("bch_ltc")
    @Expose
    @Getter
    @Setter
    private Pair bchLtc;
    @SerializedName("bch_eth")
    @Expose
    @Getter
    @Setter
    private Pair bchEth;
    @SerializedName("bch_dsh")
    @Expose
    @Getter
    @Setter
    private Pair bchDsh;
    @SerializedName("bch_zec")
    @Expose
    @Getter
    @Setter
    private Pair bchZec;
    @SerializedName("zec_btc")
    @Expose
    @Getter
    @Setter
    private Pair zecBtc;
    @SerializedName("zec_usd")
    @Expose
    @Getter
    @Setter
    private Pair zecUsd;
    @SerializedName("zec_ltc")
    @Expose
    @Getter
    @Setter
    private Pair zecLtc;
    @SerializedName("usdt_usd")
    @Expose
    @Getter
    @Setter
    private Pair usdtUsd;

    private Wex() {}


    public static Wex getInstanse(){
        if (wex==null){
            wex = new Wex();
            return wex;
        }else{
            return wex;
        }
    }

    private void ratesChanged() {
        setChanged();
        notifyObservers();
    }

    public void refresh(String rates) {
        if(rates!=null){
            wex = new GsonBuilder().create().fromJson(rates, Wex.class);
            this.btcUsd = wex.getBtcUsd();
            this.btcRur = wex.getBtcRur();
            this.btcEur = wex.getBtcEur();
            this.ltcBtc = wex.getLtcBtc();
            this.ltcUsd = wex.getLtcUsd();
            this.ltcRur = wex.getLtcRur();
            this.ltcEur = wex.getLtcEur();
            this.nmcBtc = wex.getNmcBtc();
            this.nmcUsd = wex.getNmcUsd();
            this.nvcBtc = wex.getNvcBtc();
            this.nvcUsd = wex.getNvcUsd();
            this.usdRur = wex.getUsdRur();
            this.eurUsd = wex.getEurUsd();
            this.eurRur = wex.getEurRur();
            this.ppcBtc = wex.getPpcBtc();
            this.ppcUsd = wex.getPpcUsd();
            this.dshBtc = wex.getDshBtc();
            this.dshUsd = wex.getDshUsd();
            this.dshRur = wex.getDshRur();
            this.dshEur = wex.getDshEur();
            this.dshLtc = wex.getDshLtc();
            this.dshEth = wex.getDshEth();
            this.dshZec = wex.getDshZec();
            this.ethBtc = wex.getEthBtc();
            this.ethUsd = wex.getEthUsd();
            this.ethEur = wex.getEthEur();
            this.ethLtc = wex.getEthLtc();
            this.ethRur = wex.getEthRur();
            this.ethZec = wex.getEthZec();
            this.bchUsd = wex.getBchUsd();
            this.bchBtc = wex.getBchBtc();
            this.bchRur = wex.getBchRur();
            this.bchEur = wex.getBchEur();
            this.bchLtc = wex.getBchLtc();
            this.bchEth = wex.getBchEth();
            this.bchDsh = wex.getBchDsh();
            this.bchZec = wex.getBchZec();
            this.zecBtc = wex.getZecBtc();
            this.zecUsd = wex.getZecUsd();
            this.zecLtc = wex.getZecLtc();
            this.usdtUsd = wex.getUsdtUsd();
            ratesChanged();
        }

    }

}
