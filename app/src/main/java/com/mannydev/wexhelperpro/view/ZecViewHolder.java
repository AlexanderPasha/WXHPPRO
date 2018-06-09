package com.mannydev.wexhelperpro.view;

import android.view.View;
import android.widget.TextView;

import com.mannydev.wexhelperpro.R;
import com.mannydev.wexhelperpro.model.Coin;

public class ZecViewHolder extends MyViewHolder {
    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtUsdSpread,txtBrn,txtSrn,
            txtBtcBuy,txtBtcSell,txtBtcSprd,
            txtLtcBuy,txtLtcSell, txtLtcSprd;

    public ZecViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);

        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtBtcSprd = itemView.findViewById(R.id.txtBtcSprd);

        txtLtcBuy = itemView.findViewById(R.id.txtLtcBuy);
        txtLtcSell = itemView.findViewById(R.id.txtLtcSell);
        txtLtcSprd = itemView.findViewById(R.id.txtLtcSprd);

        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);

    }

    public void onBindCoinHolder(Coin coin){

        txtCoinName.setText(coin.getName());
        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtUsdSpread.setText(coin.getUsdSprd());

        txtBrn.setText(coin.getRightNowBuyUsdProfit());
        txtSrn.setText(coin.getRightNowSellUsdProfit());

        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));
        txtBtcSprd.setText(String.valueOf(coin.getBtcSprd()));

        txtLtcBuy.setText(String.valueOf(coin.getLtcBuy()));
        txtLtcSell.setText(String.valueOf(coin.getLtcSell()));
        txtLtcSprd.setText(String.valueOf(coin.getLtcSprd()));


        if(coin.getBestBuyProfit().equals("USD")){
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("BTC")) {
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("LTC")) {
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

        if(coin.getBestSellProfit().equals("USD")){
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("BTC")){
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("LTC")){
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

    }

}
