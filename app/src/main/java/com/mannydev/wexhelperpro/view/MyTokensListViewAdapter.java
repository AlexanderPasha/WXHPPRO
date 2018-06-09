package com.mannydev.wexhelperpro.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mannydev.wexhelperpro.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.mannydev.wexhelperpro.model.Token;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import static  com.mannydev.wexhelperpro.MainActivity.wex;



public class MyTokensListViewAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    TextView txtTokenName, txtTokenBalance, txtUsd, txtProfit;
    ArrayList<Token>list;
    Map<String,String>coinsLogos;

    public MyTokensListViewAdapter(ArrayList<Token>list) {
        this.list = list;
        coinsLogos = new HashMap<String, String>();
        coinsLogos.put("BTC","https://s2.coinmarketcap.com/static/img/coins/32x32/1.png");
        coinsLogos.put("LTC","https://s2.coinmarketcap.com/static/img/coins/32x32/2.png");
        coinsLogos.put("ETH","https://s2.coinmarketcap.com/static/img/coins/32x32/1027.png");
        coinsLogos.put("ZEC","https://s2.coinmarketcap.com/static/img/coins/32x32/1437.png");
        coinsLogos.put("DASH","https://s2.coinmarketcap.com/static/img/coins/32x32/131.png");
        coinsLogos.put("BCH","https://s2.coinmarketcap.com/static/img/coins/32x32/1831.png");
        coinsLogos.put("NMC","https://s2.coinmarketcap.com/static/img/coins/32x32/3.png");
        coinsLogos.put("NVC","https://s2.coinmarketcap.com/static/img/coins/32x32/6.png");
        coinsLogos.put("PPC","https://s2.coinmarketcap.com/static/img/coins/32x32/5.png");



    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;

        lInflater = (LayoutInflater) parent.getContext()
                .getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = lInflater.inflate(R.layout.coin_bag_view1, parent, false);
        }




        txtTokenName = view.findViewById(R.id.txtTokenName);
        txtTokenBalance = view.findViewById(R.id.txtTokenBalance);
        txtUsd = view.findViewById(R.id.txtTokenUsdBalance);
        txtProfit = view.findViewById(R.id.txtTokenProfit);

        txtTokenName.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));
        txtTokenBalance.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));
        txtUsd.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));
        txtProfit.setTextColor(view.getContext().getResources().getColor(R.color.colorTextDark));

        Token token = (Token) getItem(i);

        Picasso.with(view.getContext())
                .load(coinsLogos.get(token.getName()))
                .resize(32,32)
                .transform(new CropCircleTransformation())
                .centerCrop()
                .into((ImageView) view.findViewById(R.id.ivTokenLogo));

        txtTokenName.setText(token.getName());
        if(String.valueOf(token.getBallance()).length()>7){
            txtTokenBalance.setText(roundResult1(token.getBallance()));
        }else txtTokenBalance.setText(String.valueOf(token.getBallance()));

        double usd = 0.0;

        if(token.getName().equals("BTC")){
            usd = wex.getBtcUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getBtcUsd().getAvg(),token.getPrice()));
        }
        if(token.getName().equals("LTC")){
            usd = wex.getLtcUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getLtcUsd().getAvg(),token.getPrice()));
        }
        if(token.getName().equals("ETH")){
            usd = wex.getEthUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getEthUsd().getAvg(),token.getPrice()));
        }

        if(token.getName().equals("DSH")){
            usd = wex.getDshUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getDshUsd().getAvg(),token.getPrice()));
        }

        if(token.getName().equals("BCH")){
            usd = wex.getBchUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getBchUsd().getAvg(),token.getPrice()));
        }

        if(token.getName().equals("ZEC")){
            usd = wex.getZecUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getZecUsd().getAvg(),token.getPrice()));
        }
        if(token.getName().equals("NMC")){
            usd = wex.getNmcUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getNmcUsd().getAvg(),token.getPrice()));
        }
        if(token.getName().equals("NVC")){
            usd = wex.getNvcUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getNvcUsd().getAvg(),token.getPrice()));
        }
        if(token.getName().equals("PPC")){
            usd = wex.getPpcUsd().getAvg()*token.getBallance();
            txtProfit.setText(calcProfit(wex.getPpcUsd().getAvg(),token.getPrice()));
        }

        txtUsd.setText(roundResult(usd));
        return view;
    }



    private String calcProfit(double buyNew, double myBuy) {
        double profit;
        if (buyNew>myBuy){
            profit = buyNew*100/myBuy-100;
            return "+"+roundResult(profit)+"%";
        }
        if (buyNew<myBuy){
            profit = buyNew*100/myBuy-100;
            return roundResult(profit)+"%";
        }
        return "0%";
    }

    String roundResult(double d) {
        return String.format("%.2f", d);
    }
    String roundResult1(double d) {
        return String.format("%.4f", d);
    }
}
