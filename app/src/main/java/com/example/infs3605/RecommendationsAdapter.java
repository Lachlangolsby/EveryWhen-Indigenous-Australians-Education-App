package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class RecommendationsAdapter extends RecyclerView.Adapter<RecommendationsAdapter.RecommendationsViewHolder> {

    private ArrayList<Art> mArtworks;
    private RecyclerViewClickListener mListener;

    public RecommendationsAdapter(ArrayList<Art> artwork, RecyclerViewClickListener listener){
        mArtworks = artwork;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String id);
    }

    @NonNull
    @Override
    public RecommendationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recommendations, parent, false);
        return new RecommendationsViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationsViewHolder holder, int position) {
        Random generator = new Random();
        position = generator.nextInt(150);
        Art art = mArtworks.get(position);
        Glide.with(holder.itemView)
                .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/" + art.getArtIdentifier() + ".640x640_640.jpg")
                .fitCenter()
                .into(holder.artCover);
        holder.itemView.setTag(art.getArtId());
    }

    @Override
    public int getItemCount() {
        int size = 6;
        return size;
    }

    public static class RecommendationsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RecyclerViewClickListener listener;
        public ImageView artCover;

        public RecommendationsViewHolder(@NonNull View itemView, RecyclerViewClickListener mListener) {
            super(itemView);
            this.listener = mListener;
            itemView.setOnClickListener(this);
            artCover = itemView.findViewById(R.id.rImage);
        }

        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }
}
