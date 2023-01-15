package com.example.foodorederapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;

    public MainAdapter(Context context, ArrayList<MainModel> mainModels){
         this.context=context;
         this.mainModels=mainModels;
    }
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
      holder.imageview1.setImageResource(mainModels.get(position).getImage());
      holder.textview1.setText(mainModels.get(position).getImagename());
      holder.textview2.setText(mainModels.get(position).getImageprice());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(view.getContext(),Recommendations_list2.class);
              intent.putExtra("image",""+mainModels.get(holder.getAdapterPosition()).getImage());
              intent.putExtra("name",""+mainModels.get(holder.getAdapterPosition()).getImagename());
              intent.putExtra("price",""+mainModels.get(holder.getAdapterPosition()).getImageprice());
              context.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview1;
        TextView textview1,textview2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview1 = itemView.findViewById(R.id.imageview1);
            textview1 = itemView.findViewById(R.id.textview1);
            textview2 = itemView.findViewById(R.id.textview2);
        }
    }
}
