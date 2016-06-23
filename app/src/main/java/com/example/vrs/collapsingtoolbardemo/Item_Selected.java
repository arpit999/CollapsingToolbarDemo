package com.example.vrs.collapsingtoolbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Item_Selected extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__selected);

        ImageView imageView = (ImageView) findViewById(R.id.Image);
        TextView textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        String flower = String.valueOf(MainActivity.flowers.get(position));
        Log.d("", "onCreate: Flower "+flower);
//        imageView.setBackgroundResource();
    }
}
