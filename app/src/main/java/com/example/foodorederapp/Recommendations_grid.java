package com.example.foodorederapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Recommendations_grid extends AppCompatActivity {
    TextView tv1,tv2;
    ImageView imageview;
    TabLayout tablayout;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations_grid);
        getSupportActionBar().hide();

        tv2 = findViewById(R.id.tv2);
        imageview = findViewById(R.id.imageview);
        tv2.setText(Html.fromHtml("We think you might enjoy these "+"<br>"+"specially selected dishes"));

        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);

        tablayout.setupWithViewPager(viewpager);

        VpAdapter vpadapter = new VpAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpadapter.addFragment(new Eat_fragment(),"Eat");
        vpadapter.addFragment(new Drink_fragment(),"Drink");
        vpadapter.addFragment(new Dessert_fragment(),"Dessert");

        viewpager.setAdapter(vpadapter);

        imageview.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(Recommendations_grid.this,Recommendations_list.class);
                 startActivity(intent);
                 finish();
             }
         });
    }
}