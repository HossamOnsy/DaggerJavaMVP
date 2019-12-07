package com.sam.daggerjavamvp.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sam.daggerjavamvp.R;
import com.sam.daggerjavamvp.model.Cat;

import java.util.ArrayList;
import java.util.List;


public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.ViewHolder> {
    private List<Cat> catList;

    public CatsAdapter() {
        catList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(catList.get(position).getUrl())
                .into(holder.ivCat);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivCat ;

        ViewHolder(View itemView) {
            super(itemView);

            ivCat = itemView.findViewById(R.id.ivCat);
        }
    }

    public void updateCatList(List<Cat> catList) {
        this.catList = catList;
        notifyDataSetChanged();
    }
}