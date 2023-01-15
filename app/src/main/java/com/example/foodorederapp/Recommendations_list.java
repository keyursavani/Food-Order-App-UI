package com.example.foodorederapp;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recommendations_list extends AppCompatActivity {
    TextView tv2;
    RecyclerView recyclerview;
    ArrayList<MainModel2> mainmodels2;
    MainAdapter2 mainAdapter2;
  //  CardView cardview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations_list);
        getSupportActionBar().hide();
        tv2 = findViewById(R.id.tv2);
//        cardview = findViewById(R.id.cardview);
        tv2.setText(Html.fromHtml("We think you might enjoy these "+"<br>"+" specially selected dishes"));
//         cardview.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 Intent intent = new Intent(Recommendations_list.this,Recommendations_list2.class);
//                 startActivity(intent);
//             }
//         });

        recyclerview = findViewById(R.id.recycleview);
        Integer[] image ={R.drawable.image1,R.drawable.image2,R.drawable.image3,
                R.drawable.image4,R.drawable.image5,R.drawable.image6};



        String[] imagename = {"Egg Toast","Power Bowl","Vegetable Salad","Chicken Salad",
                "Mix Salad with beans","Avocado and Egg Mixture"};

        String[] imageprice = {"$10.40","$14.10","$11.30","$12.40",
                "$10.40",  "$15.40"};


        mainmodels2 = new ArrayList<>();
        for (int i = 0 ; i<image.length ; i++){
            MainModel2 model2 = new MainModel2(image[i],imagename[i],imageprice[i]);
            mainmodels2.add(model2);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Recommendations_list.this,LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(new GridLayoutManager(Recommendations_list.this, 2));
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        mainAdapter2 = new MainAdapter2(Recommendations_list.this,mainmodels2);
        recyclerview.setAdapter(mainAdapter2);
    }
}