package com.example.foodorederapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        img1 = findViewById(R.id.img1);
        getSupportActionBar().hide();
        //String text = "<b>"+"No Worry"+"</b>"+"handel,"+"</br></br>"+"Your Hunger"+"<b>"+"With"+"</b>"+"</br></br>"+"<b>"+"Eattak!"+"</b>";
        tv1.setText(Html.fromHtml("<b>" + "No Worry," + "</b>" + " Handel" + "<br>" + " Your Hunger" + "<b>" + " With" + "</b>" + "<br>" + "<b>" + " Eattak!" + "</b>"));
        tv2.setText(Html.fromHtml("Eattak come to help you hunger problem "+ " <br>"+ "with easy find any restaurant "));
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Home_Active_Order.class);
                startActivity(intent);
            }
        });
    }
}