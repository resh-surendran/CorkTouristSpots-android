package com.example.resh.corktouristspots;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlacesListActivity extends AppCompatActivity {

    private ListView listView = null;
    private ArrayAdapter<String> adapter = null;
    private XMLPlacesData placesData = null;
    Intent intent = null;
    Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.Base_Theme_AppCompat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        //wire and make the list
        listView = findViewById(R.id.listView);

        placesData = new XMLPlacesData(getApplicationContext());

        adapter = new MyItemAdapter(this, R.layout.row_layout, placesData.getNames(), placesData.getAddresses(), placesData.getImages());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // make an intent and prepare some data for it
                intent = new Intent(PlacesListActivity.this, PlaceImageDataActivity.class);

                bundle = new Bundle();
                bundle.putSerializable("data", placesData.getPlaceData(i));
                intent.putExtras(bundle);

                //start PlaceImageDataActivity
                startActivity(intent);
            }
        });
    }
}
