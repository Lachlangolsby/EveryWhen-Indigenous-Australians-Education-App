package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> implements Filterable {

    private ArrayList<Art> mArtworks;
    private ArrayList<Art> mArtworksFiltered;
    private RecyclerViewClickListener mListener;

    public GalleryAdapter(ArrayList<Art> artworks, RecyclerViewClickListener listener){
        mArtworks = artworks;
        mArtworksFiltered = artworks;
        mListener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String id);
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_art_gallery, parent, false);
        return new GalleryViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Art art = mArtworks.get(position);
        Glide.with(holder.itemView)
                .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/" + art.getArtIdentifier() + ".640x640_640.jpg")
                .fitCenter()
                .into(holder.artCover);
        holder.artName.setText(art.getArtTitle());
        holder.artType.setText(art.getArtType());
        holder.itemView.setTag(art.getArtId());
    }

    @Override
    public int getItemCount() {
        return mArtworksFiltered.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView artCover;
        public TextView artName, artType;
        private RecyclerViewClickListener listener;

        public GalleryViewHolder(@NonNull View itemView, RecyclerViewClickListener mListener) {
            super(itemView);
            this.listener = mListener;
            itemView.setOnClickListener(this);
            artCover = itemView.findViewById(R.id.artCover);
            artName = itemView.findViewById(R.id.artName);
            artType = itemView.findViewById(R.id.artType);
        }

        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }
}
