package com.example.resh.corktouristspots;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlaceImageDataActivity extends AppCompatActivity {

    private TextView placeTextView = null;
    private Button moreInfoButton = null;
    private ViewPager viewPager = null;
    private LinearLayout dotsPanel = null;
    private ImageView[] dots;

    private Intent intent = null;

    private Place data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_image_data);

        //get data from intent
        data = (Place) getIntent().getExtras().getSerializable("data");

        //wire
        placeTextView = findViewById(R.id.placeTitle);
        moreInfoButton = findViewById(R.id.button);
        viewPager = findViewById(R.id.viewPageSlider);
        dotsPanel = findViewById(R.id.dots);

        //set the Title for the details of the place
        String placeName = data.getName();
        placeTextView.setText(placeName);

        SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(this, data.getImages());
        viewPager.setAdapter(sliderPagerAdapter);

        final int dotsCount = sliderPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i = 0; i < dotsCount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            dotsPanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PlaceImageDataActivity.this, PlaceDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);

                intent.putExtras(bundle);

                startActivity(intent);

            }
        });

    }

}


