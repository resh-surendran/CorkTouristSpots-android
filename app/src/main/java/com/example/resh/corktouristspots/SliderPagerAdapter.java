package com.example.resh.corktouristspots;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class SliderPagerAdapter extends PagerAdapter {
    String [] imageList;
    Activity activity;
    LayoutInflater layoutInflater;

    public SliderPagerAdapter(Activity activity, String [] imageList) {
        this.activity = activity;
        this.imageList = imageList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.image_slider_layout, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        String imageName = imageList[position];
        imageName = imageName.substring(0, imageName.indexOf("."));
        int imageResId = activity.getResources().getIdentifier(imageName, "drawable", activity.getPackageName());
        imageView.setImageResource(imageResId);

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return imageList.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}

