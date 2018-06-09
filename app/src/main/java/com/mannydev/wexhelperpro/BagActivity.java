package com.mannydev.wexhelperpro;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;

import com.mannydev.wexhelperpro.model.Token;

import com.baoyz.swipemenulistview.SwipeMenuListView;

import com.mannydev.wexhelperpro.model.Wex;
import com.mannydev.wexhelperpro.view.MyTokensListViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BagActivity extends AppCompatActivity {
    private static final String APP_CACHE = "cache";
    private static final String PRICE = "_PRICE";
    private Dialog dialog;
    private MyTokensListViewAdapter lvAdapter;
    private SharedPreferences appCache;
    private ArrayList<Token> tokens;
    public static Wex wex;
    double usdBalance;
    double usdInvest;

    //Views
    @BindView(R.id.txtUsdProfit)
    TextView txtUsdProfit;
    @BindView(R.id.txtUsdProfitPercent)
    TextView txtUsdProfitPercent;
    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.lvTokens)
    SwipeMenuListView lvTokens;

    @BindView(R.id.txtTotalBtcBalance)
    TextView txtTotalBtcBalance;
    @BindView(R.id.txtTotalUsdBalance)
    TextView txtTotalUsdBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        appCache = getSharedPreferences(APP_CACHE, MODE_PRIVATE);
        wex = wex.getInstanse();
        tokens = new ArrayList<>();

        tokens = new ArrayList<>();
        bagRefresh();
        addSwipes();
    }



    //swipes
    private void addSwipes() {
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(150);
                // set item title
                openItem.setTitle("Edit");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(150);
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_delete_white_24dp);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        lvTokens.setMenuCreator(creator);

        lvTokens.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                Token token = (Token) lvTokens.getItemAtPosition(position);
                switch (index) {
                    case 0:

                        dialog = new Dialog(BagActivity.this);
                        dialog.setContentView(R.layout.dialog_edit_coin_view);
                        initDialogEditView(token);
                        dialog.show();
                        break;
                    case 1:
                        SharedPreferences.Editor editor = appCache.edit();
                        editor.putString(token.getName(), "0.0");
                        editor.apply();
                        bagRefresh();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });

    }

    private void initDialogAddView() {
        final Spinner spinner = dialog.findViewById(R.id.spinner);
        final EditText etBallance = dialog.findViewById(R.id.etBallance);
        final EditText etPrice = dialog.findViewById(R.id.etPrice);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etBallance.getText().toString().length()<1||etPrice.getText().toString().length()<1 || etBallance.getText().toString().equals(".") || etPrice.getText().toString().equals(".")){
                    Toast.makeText(BagActivity.this,"You have an empty fields!",Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences.Editor editor = appCache.edit();
                    editor.putString(spinner.getSelectedItem().toString(), etBallance.getText().toString());
                    editor.putString(spinner.getSelectedItem().toString() + PRICE, etPrice.getText().toString());
                    editor.apply();
                    bagRefresh();
                    dialog.cancel();
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void initDialogEditView(final Token token) {
        final TextView txtEditCoinName = dialog.findViewById(R.id.txtEditCoinName);
        txtEditCoinName.setText(token.getName());
        final EditText etBallance = dialog.findViewById(R.id.etBallance);
        final EditText etPrice = dialog.findViewById(R.id.etPrice);
        etBallance.setText(String.valueOf(token.getBallance()));
        etPrice.setText(String.valueOf(token.getPrice()));
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etBallance.getText().toString().length()<1||etPrice.getText().toString().length()<1 || etBallance.getText().toString().equals(".") || etPrice.getText().toString().equals(".")){
                    Toast.makeText(BagActivity.this,"You have an empty fields!",Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences.Editor editor = appCache.edit();
                    editor.putString(token.getName(), etBallance.getText().toString());
                    editor.putString(token.getName() + PRICE, etPrice.getText().toString());
                    editor.apply();
                    bagRefresh();
                    dialog.cancel();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    @OnClick({R.id.btnBack, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.fab:
                dialog = new Dialog(BagActivity.this);
                dialog.setContentView(R.layout.dialog_add_coin_view);
                initDialogAddView();
                dialog.show();
                break;
        }
    }


    private void bagRefresh() {
        tokens = new ArrayList<>();
        usdBalance = 0;
        usdInvest = 0;
        txtTotalUsdBalance.setText("0");
        String[] names = getApplicationContext().getResources().getStringArray(R.array.coins);
        for (String name : names) {
            if (appCache.contains(name)) {
                if (Double.parseDouble(appCache.getString(name, null)) > 0) {
                    Token token = new Token(name, Double.parseDouble(appCache.getString(name, null)), Double.parseDouble(appCache.getString(name + PRICE, null)));
                    addUsdToBalance(token);
                    tokens.add(token);
                }
            }
        }
        double usdProfitPercent;
        double usdProfit = usdBalance - usdInvest;
        if(usdProfit<0){
            txtUsdProfit.setText(roundResult1(usdProfit)+"$");
        }else txtUsdProfit.setText("+"+roundResult1(usdProfit)+"$");
        if (usdBalance > usdInvest) {
            usdProfitPercent = usdBalance * 100 / usdInvest - 100;
            txtUsdProfitPercent.setText("+"+roundResult1(usdProfitPercent)+"%");
        }
        if (usdBalance < usdInvest) {
            usdProfitPercent = usdBalance * 100 / usdInvest - 100;
            txtUsdProfitPercent.setText(roundResult1(usdProfitPercent)+"%");
        }


        txtTotalUsdBalance.setText(String.valueOf(Math.round(usdBalance)));
        txtTotalBtcBalance.setText(roundResult(usdBalance / wex.getBtcUsd().getAvg()));
        lvAdapter = new MyTokensListViewAdapter(tokens);
        lvTokens.setAdapter(lvAdapter);

    }

    private void addUsdToBalance(Token token) {
        double usd = 0;

        if (token.getName().equals("BTC")) {
            usd = wex.getBtcUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("LTC")) {
            usd = wex.getLtcUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("ETH")) {
            usd = wex.getEthUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("DSH")) {
            usd = wex.getDshUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("BCH")) {
            usd = wex.getBchUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("ZEC")) {
            usd = wex.getZecUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("NMC")) {
            usd = wex.getNmcUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("NVC")) {
            usd = wex.getNvcUsd().getAvg() * token.getBallance();
        }
        if (token.getName().equals("PPC")) {
            usd = wex.getPpcUsd().getAvg() * token.getBallance();
        }


        usdInvest = usdInvest + token.getBallance() * token.getPrice();
        usdBalance = usdBalance + usd;
    }

    String roundResult(double d) {
        return String.format("%.4f", d);
    }
    String roundResult1(double d) {
        return String.format("%.2f", d);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bagRefresh();
    }


}
