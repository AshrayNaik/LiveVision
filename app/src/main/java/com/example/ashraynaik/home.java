package com.example.ashraynaik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class home extends AppCompatActivity {


    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    Button backbtn, nextbtn , skipbtn;

    TextView[] dots;
    viewPageAdapter viewPageAdapter;

    //ashray


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        backbtn =findViewById(R.id.backbtn);
        nextbtn =findViewById(R.id.nextbtn);
        skipbtn =findViewById(R.id.skipbutton);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getitem(0)> 0){
                    mSlideViewPager.setCurrentItem(getitem(-1),true);
                }

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getitem(0) < 3){
                    mSlideViewPager.setCurrentItem(getitem(1),true);
                }
                else {
                    Intent i = new Intent(home.this,Mainscreen.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(home.this,Mainscreen.class);
                startActivity(i);
                finish();

            }
        });

        mSlideViewPager = (ViewPager) findViewById(R.id.slidviwerpager);
        mDotLayout =(LinearLayout) findViewById(R.id.indicatorlayout);

        viewPageAdapter = new viewPageAdapter(this);

        mSlideViewPager.setAdapter(viewPageAdapter);

        setUpindicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);


    }

    public void setUpindicator(int position){

        dots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }


        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpindicator(position);

            if (position > 0){
                backbtn.setVisibility(View.VISIBLE);
            }else {
                backbtn.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i ){
        return mSlideViewPager.getCurrentItem() + i;
    }


}