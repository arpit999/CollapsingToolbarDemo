package com.example.vrs.collapsingtoolbardemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton floatingActionButton;
    int mutedColor = R.attr.colorPrimary;
    RecyclerView recyclerView;

    CardAdapter adapter;
    static List<Flower> flowers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        toolbar.setTitle("Hello");
        collapsingToolbarLayout.setTitle("Demo");

        setSupportActionBar(toolbar);

        //recyclerview
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        adapter = new CardAdapter(getApplicationContext(), flowers);
        recyclerView.setAdapter(adapter);

        // RecyclerView Click listener
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Toast.makeText(MainActivity.this, "Flower "+(position+1)+" Selected", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,Item_Selected.class);
                        intent.putExtra("position",position);

                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                // the context of the activity
                                MainActivity.this,

                                // For each shared element, add to this method a new Pair item,
                                // which contains the reference of the view we are transitioning *from*,
                                // and the value of the transitionName attribute
                                new Pair<View, String>(view.findViewById(R.id.cardimage),
                                        getString(R.string.transition_name_circle)),
                                new Pair<View, String>(view.findViewById(R.id.cardtitle),
                                        getString(R.string.transition_name_name))

                        );
                        ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());

//                        startActivity(intent);

                    }
                })
        );

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "You clicked on the fab", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    private void initializeData() {
        flowers = new ArrayList<>();
        flowers.add(new Flower("Flower 1", R.drawable.image2));
        flowers.add(new Flower("Flower 2", R.drawable.images3));
        flowers.add(new Flower("Flower 3", R.drawable.images4));
        flowers.add(new Flower("Flower 4", R.drawable.images6));
        flowers.add(new Flower("Flower 5", R.drawable.images7));
        flowers.add(new Flower("Flower 6", R.drawable.images10));
        flowers.add(new Flower("Flower 7", R.drawable.images11));
        flowers.add(new Flower("Flower 8", R.drawable.images12));
        flowers.add(new Flower("Flower 9", R.drawable.images14));
        flowers.add(new Flower("Flower 10", R.drawable.images17));
        flowers.add(new Flower("Flower 11", R.drawable.images18));
        flowers.add(new Flower("Flower 12", R.drawable.index));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
