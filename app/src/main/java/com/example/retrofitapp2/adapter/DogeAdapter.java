package com.example.retrofitapp2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapp2.R;

import java.util.List;

public class DogeAdapter extends RecyclerView.Adapter<DogeAdapter.DogeViewHolder> {
    private List<String> dogeUrls;
    private Context context;

    public DogeAdapter(List<String> dogeUrls){
        this.dogeUrls = dogeUrls;

    }
    @NonNull
    @Override
    public DogeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(
                R.layout.shibe_items,
                parent,
                false);

        return new DogeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogeViewHolder holder, int position) {
        String dogeUrl = dogeUrls.get(position);

        Glide.with(context)
                .load(dogeUrl)
                .into(holder.dogeImages);
    }

    @Override
    public int getItemCount() {
        return dogeUrls.size();
    }

    class DogeViewHolder extends RecyclerView.ViewHolder{
        ImageView dogeImages;

        public DogeViewHolder(@NonNull View itemView) {
            super(itemView);
         dogeImages = itemView.findViewById(R.id.iv_shibe_image);


        }
    }

}
