package com.example.vrs.collapsingtoolbardemo;

import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    static List<Grocery> groceries;

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
        adapter = new CardAdapter(getApplicationContext(), groceries);
        recyclerView.setAdapter(adapter);

        // RecyclerView Click listener
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(MainActivity.this, "Grocery " + (position + 1) + " Selected", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, Item_Selected.class);
                        intent.putExtra("position", position);

                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                // the context of the activity
                                MainActivity.this,

                                // For each shared element, add to this method a new Pair item,
                                // which contains the reference of the view we are transitioning *from*,
                                // and the value of the transitionName attribute

                                new Pair<View, String>(view.findViewById(R.id.card_view),
                                        getString(R.string.CardView))

                        );
                        ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());


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
        groceries = new ArrayList<>();
        groceries.add(new Grocery("Gandhingar", "2 hrs 30 mins", "Mobile"));
        groceries.add(new Grocery("Ahmedbad", "3 hrs 15 mins", "Basketball"));
        groceries.add(new Grocery("Surat", "1 hrs 20 mins", "Biscuits"));
        groceries.add(new Grocery("Rajkot", "3 hrs 10 mins", "Drinks"));
        groceries.add(new Grocery("Bhavnagar", "1 hrs 20 mins", "Packaged Food"));
        groceries.add(new Grocery("Mumbai", "2 hrs 30 mins", "House Hold"));
        groceries.add(new Grocery("Puna", "2 hrs 40 mins", "Dry Fruits"));
        groceries.add(new Grocery("Delhi", "4 hrs 10 mins", "Salt & Sugar"));
        groceries.add(new Grocery("Bihar", "3 hrs 14 mins", "Energy Drink"));
        groceries.add(new Grocery("Kalol", "2 hrs 30 mins", "Fruits"));
        groceries.add(new Grocery("Somnath", "3 hrs 50 mins", "Mineral Water"));
        groceries.add(new Grocery("Abu", "4 hrs 20 mins", "Tea & Coffee"));

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
