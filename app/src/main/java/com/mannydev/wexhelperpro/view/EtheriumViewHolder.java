package com.mannydev.wexhelperpro.view;

import android.view.View;
import android.widget.TextView;

import com.mannydev.wexhelperpro.R;
import com.mannydev.wexhelperpro.model.Coin;


public class EtheriumViewHolder extends MyViewHolder {
    TextView txtCoinName,txtUsdBuy,txtUsdSell,txtRubBuy,
            txtRubSell,txtUsdSpread,txtRubSpread,txtBrn,txtSrn,
            txtEurBuy,txtEurSell,txtEurSprd, txtBtcBuy,txtBtcSell,txtBtcSprd,
            txtLtcBuy,txtLtcSell, txtLtcSprd,
            txtZecBuy, txtZecSell, txtZecSprd;

    public EtheriumViewHolder(View itemView) {
        super(itemView);
        txtCoinName = itemView.findViewById(R.id.txtCoinName);
        txtUsdBuy = itemView.findViewById(R.id.txtUsdBuy);
        txtUsdSell = itemView.findViewById(R.id.txtUsdSell);
        txtRubBuy = itemView.findViewById(R.id.txtRubBuy);

        txtRubSell = itemView.findViewById(R.id.txtRubSell);
        txtUsdSpread = itemView.findViewById(R.id.txtUsdSpread);
        txtRubSpread = itemView.findViewById(R.id.txtRubSpread);

        txtEurBuy = itemView.findViewById(R.id.txtEurBuy);
        txtEurSell = itemView.findViewById(R.id.txtEurSell);
        txtEurSprd = itemView.findViewById(R.id.txtEurSprd);

        txtBtcBuy = itemView.findViewById(R.id.txtBtcBuy);
        txtBtcSell = itemView.findViewById(R.id.txtBtcSell);
        txtBtcSprd = itemView.findViewById(R.id.txtBtcSprd);

        txtLtcBuy = itemView.findViewById(R.id.txtLtcBuy);
        txtLtcSell = itemView.findViewById(R.id.txtLtcSell);
        txtLtcSprd = itemView.findViewById(R.id.txtLtcSprd);

        txtZecBuy = itemView.findViewById(R.id.txtZecBuy);
        txtZecSell = itemView.findViewById(R.id.txtZecSell);
        txtZecSprd = itemView.findViewById(R.id.txtZecSprd);

        txtBrn = itemView.findViewById(R.id.txtBrn);
        txtSrn = itemView.findViewById(R.id.txtSrn);

    }

    public void onBindCoinHolder(Coin coin){

        txtCoinName.setText(coin.getName());
        txtUsdBuy.setText(String.valueOf(coin.getUsdBuy()));
        txtUsdSell.setText(String.valueOf(coin.getUsdSell()));
        txtRubBuy.setText(String.valueOf(coin.getRurBuy()));
        txtRubSell.setText(String.valueOf(coin.getRurSell()));
        txtUsdSpread.setText(coin.getUsdSprd());
        txtRubSpread.setText(coin.getRurSprd());
        txtBrn.setText(coin.getRightNowBuyUsdProfit());
        txtSrn.setText(coin.getRightNowSellUsdProfit());

        txtBtcBuy.setText(String.valueOf(coin.getBtcBuy()));
        txtBtcSell.setText(String.valueOf(coin.getBtcSell()));
        txtBtcSprd.setText(String.valueOf(coin.getBtcSprd()));


        txtEurBuy.setText(String.valueOf(coin.getEurBuy()));
        txtEurSell.setText(String.valueOf(coin.getEurSell()));
        txtEurSprd.setText(String.valueOf(coin.getEurSprd()));

        txtLtcBuy.setText(String.valueOf(coin.getLtcBuy()));
        txtLtcSell.setText(String.valueOf(coin.getLtcSell()));
        txtLtcSprd.setText(String.valueOf(coin.getLtcSprd()));

        txtZecBuy.setText(String.valueOf(coin.getZecBuy()));
        txtZecSell.setText(String.valueOf(coin.getZecSell()));
        txtZecSprd.setText(String.valueOf(coin.getZecSprd()));


        if(coin.getBestBuyProfit().equals("USD")){
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if(coin.getBestBuyProfit().equals("RUB")){
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("EUR")){
            txtEurBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("BTC")) {
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("LTC")) {
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestBuyProfit().equals("ZEC")) {
            txtZecBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcBuy.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

        if(coin.getBestSellProfit().equals("USD")){
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("RUB")){
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("EUR")){
            txtEurSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("BTC")){
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("LTC")){
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtZecSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }else if (coin.getBestSellProfit().equals("ZEC")){
            txtZecSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorGreen));
            txtUsdSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtRubSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtEurSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtLtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
            txtBtcSell.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.colorTextWhite));
        }

    }

}
