package com.mannydev.wexhelperpro.view;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mannydev.wexhelperpro.R;
import com.mannydev.wexhelperpro.model.Coin;

import java.util.ArrayList;

/**
 * Created by manny on 16.01.18.
 */

public class CoinViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private static final int BITCOIN = 0;
    private static final int LITECOIN = 1;
    private static final int NAMECOIN = 2;
    private static final int NOVACOIN = 3;
    private static final int PEERCOIN = 4;
    private static final int ETHERIUM = 6;
    private static final int DASHCOIN = 5;
    private static final int BITCOINCASH = 7;
    private static final int ZECCOIN = 8;

    ArrayList<Coin>list;


    public CoinViewAdapter() {

    }

    public void setData(ArrayList<Coin> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case BITCOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.bitcoin_view, parent, false);
                return new BitcoinViewHolder(v);
            case LITECOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.litecoin_view, parent, false);
                return new LitecoinViewHolder(v);
            case NAMECOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.namecoin_view, parent, false);
                return new NamecoinViewHolder(v);
            case NOVACOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.namecoin_view, parent, false);
                return new NovacoinViewHolder(v);
            case PEERCOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.namecoin_view, parent, false);
                return new PeercoinViewHolder(v);
            case DASHCOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.dashcoin_view, parent, false);
                return new DashcoinViewHolder(v);
            case ETHERIUM:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.etherium_view, parent, false);
                return new EtheriumViewHolder(v);
            case BITCOINCASH:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.bitcoincash_view, parent, false);
                return new BitcoinCashViewHolder(v);
            case ZECCOIN:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.zeccoin_view, parent, false);
                return new ZecViewHolder(v);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Coin coin = list.get(position);
        holder.onBindCoinHolder(coin);
    }

    @Override
    public int getItemViewType(int position) {
        Coin coin = list.get(position);
        if(coin.getName().equals("BTC")){
            return BITCOIN;
        }else if (coin.getName().equals("LTC")){
            return LITECOIN;
        }else if (coin.getName().equals("NMC")) {
            return NAMECOIN;
        }else if (coin.getName().equals("NVC")) {
            return NOVACOIN;
        }else if (coin.getName().equals("PPC")) {
            return PEERCOIN;
        }else if (coin.getName().equals("DSH")) {
            return DASHCOIN;
        }else if (coin.getName().equals("ETH")) {
            return ETHERIUM;
        }else if (coin.getName().equals("BCH")) {
            return BITCOINCASH;
        }else if (coin.getName().equals("ZEC")) {
            return ZECCOIN;
        }

        return BITCOIN;
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }
}