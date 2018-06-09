package com.mannydev.wexhelperpro.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mannydev.wexhelperpro.model.Coin;


public abstract class MyViewHolder extends RecyclerView.ViewHolder {
    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBindCoinHolder(Coin coin);
}
