package com.example.vrs.collapsingtoolbardemo;

import android.content.Intent;
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

        ImageView imageView = (ImageView) findViewById(R.id.Image);
        TextView textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");

        Flower fl = MainActivity.flowers.get(position);

        String name = fl.getName();
        int image = fl.getId();
        imageView.setImageResource(image);
        textView.setText(name);

        Log.d("", "onCreate: Flower "+position);
//        imageView.setBackgroundResource();
    }
}
