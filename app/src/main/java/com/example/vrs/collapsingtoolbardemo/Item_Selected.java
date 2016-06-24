package com.example.vrs.collapsingtoolbardemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Item_Selected extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__selected);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Item Select");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                onBackPressed();
            }
        });

        TextView store_name = (TextView) findViewById(R.id.store_name);
        TextView delivery_time = (TextView) findViewById(R.id.delivery_time);
        TextView product_name = (TextView) findViewById(R.id.product_name);


        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");

        Grocery fl = MainActivity.groceries.get(position);

        store_name.setText("Grocery Mart - "+fl.getStore());
        delivery_time.setText("Deliver in "+fl.getDeliveryTime());
        product_name.setText("Product : "+fl.getProduct());

        Log.d("", "onCreate: Grocery "+position);
//        imageView.setBackgroundResource();
    }
}
