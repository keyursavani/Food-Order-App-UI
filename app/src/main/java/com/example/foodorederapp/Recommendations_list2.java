package com.example.foodorederapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Recommendations_list2 extends AppCompatActivity {
ImageView imageview1;
TextView textview1,textview3;
CardView cardview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations_list2);
        getSupportActionBar().hide();

        imageview1 = findViewById(R.id.imageview1);
        textview1 = findViewById(R.id.textview1);
        textview3 = findViewById(R.id.textview3);
        cardview2 = findViewById(R.id.cardview2);

        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");


        imageview1.setImageResource(Integer.parseInt(image));
        textview1.setText(name);
        textview3.setText(price);

        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recommendations_list2.this,Order_Status_done.class);
                startActivity(intent);
            }
        });

    }
}