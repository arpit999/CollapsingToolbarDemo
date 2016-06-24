package com.example.vrs.collapsingtoolbardemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context mContext;
    List<Grocery> list = new ArrayList<>();

    public CardAdapter(Context mContext, List<Grocery> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.Grocery = getItem(position);
        holder.storeName.setText("Grocery Mart - " + list.get(position).Store);
        holder.deliveryTime.setText("Deliver in " + list.get(position).deliveryTime);
        holder.product.setText("Product : " + list.get(position).product);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Grocery getItem(int i) {
        return list.get(i);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView storeName;
        TextView deliveryTime;
        TextView product;
        Grocery Grocery;

        public ViewHolder(View itemView) {
            super(itemView);

            storeName = (TextView) itemView.findViewById(R.id.store_name);
            deliveryTime = (TextView) itemView.findViewById(R.id.delivery_time);
            product = (TextView) itemView.findViewById(R.id.product_name);
        }
    }

}

