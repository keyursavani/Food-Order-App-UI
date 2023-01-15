package com.example.foodorederapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home_Active_Order extends AppCompatActivity {
 TextView tv1,tv2,tv3,tv4;
 ImageView imageview3;
 RecyclerView recycleview,recycleview2;
 ArrayList<MainModel> mainmodels;
 MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_active_order);
        getSupportActionBar().hide();
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        recycleview = findViewById(R.id.recycleview);
        recycleview2 = findViewById(R.id.recycleview2);
        imageview3 = findViewById(R.id.imageview3);

        tv2.setText(Html.fromHtml("Hope you enjoy the time at  "+"<br>"+" Gram Bistro"));
        tv3.setText(Html.fromHtml("Discover other dishes"));
        tv4.setText(Html.fromHtml("We recommended"));
        Integer[] image ={R.drawable.image1,R.drawable.image2,R.drawable.image3,
                R.drawable.image4,R.drawable.image5,R.drawable.image6};

        String[] imagename = {"Egg Toast","Power Bowl","Vegetable Salad","Chicken Salad"
                ,"Mix Salad with beans","Avocado and Egg Mixture"};
        String[] imageprice = {"$ 10.40","$ 14.10","$ 11.30","$ 12.40",
                "$ 10.40","$ 15.40",};

        mainmodels = new ArrayList<>();
        for (int i = 0 ; i<image.length ; i++){
            MainModel model = new MainModel(image[i],imagename[i],imageprice[i]);
            mainmodels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Home_Active_Order.this,LinearLayoutManager.HORIZONTAL,false);
        recycleview.setLayoutManager(layoutManager);
        recycleview.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(Home_Active_Order.this,mainmodels);
        recycleview.setAdapter(mainAdapter);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(
                Home_Active_Order.this,LinearLayoutManager.HORIZONTAL,false);
        recycleview2.setLayoutManager(layoutManager1);
        recycleview2.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(Home_Active_Order.this,mainmodels);
        recycleview2.setAdapter(mainAdapter);

        imageview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Active_Order.this,Recommendations_grid.class);
                startActivity(intent);

            }
        });
    }
}