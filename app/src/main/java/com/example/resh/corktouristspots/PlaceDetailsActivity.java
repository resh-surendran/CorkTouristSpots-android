package com.example.resh.corktouristspots;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceDetailsActivity extends AppCompatActivity {

    private LinearLayout linearLayout = null;
    private TextView nameTextView = null;
    private TextView descriptionTextView = null;
    private TextView addressTextView = null;
    private TextView distanceTextView = null;
    private TextView urlTextView = null;

    private Button webInfoButton = null;

    private Place data;
    Drawable backgroundImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        //get data from intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        data = (Place) bundle.getSerializable("data");

        //wire and populate the fields with data.getters
        linearLayout = findViewById(R.id.linearLayout);
        nameTextView = findViewById(R.id.placeName);
        descriptionTextView = findViewById(R.id.description);
        addressTextView = findViewById(R.id.addressDetails);
        distanceTextView = findViewById(R.id.distance);
        urlTextView = findViewById(R.id.url);

        String imageName = data.getBackgroundImage();
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageResId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        backgroundImage = getResources().getDrawable(imageResId);
        backgroundImage.setAlpha(80);
        linearLayout.setBackground(backgroundImage);
        nameTextView.setText(data.getName());
        descriptionTextView.setText(data.getDescription());
        addressTextView.setText(data.getAddress());
        distanceTextView.setText(data.getDistance());
        urlTextView.setText(data.getUrl());

        //deal with button
        webInfoButton = findViewById(R.id.webInfoButton);

        webInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(PlaceDetailsActivity.this, WebContentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", data.getUrl());

                intent1.putExtras(bundle);

                startActivity(intent1);

            }
        });
    }

}


