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

class MainAdapter2  extends RecyclerView.Adapter<MainAdapter2.ViewHolder> {
    ArrayList<MainModel2> mainModels2;
    Context context;

    public MainAdapter2(Context context, ArrayList<MainModel2> mainModels2){
        this.context=context;
        this.mainModels2=mainModels2;
    }
    @NonNull
    @Override
    public MainAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2,parent,false);
        return new MainAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter2.ViewHolder holder, int position) {
        holder.img1.setImageResource(mainModels2.get(position).getImage());
        holder.tv1.setText(mainModels2.get(position).getImagename());
        holder.tv2.setText(mainModels2.get(position).getImageprice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Recommendations_list2.class);
                intent.putExtra("image",""+mainModels2.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("name",""+mainModels2.get(holder.getAdapterPosition()).getImagename());
                intent.putExtra("price",""+mainModels2.get(holder.getAdapterPosition()).getImageprice());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModels2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView tv1,tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }
}
