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

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private ArrayList<Art> artName;
    private RecyclerViewClickListener mListener;

    public GalleryAdapter(ArrayList<Art> name, RecyclerViewClickListener listener){
        artName = name;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String artName);
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_gallery_layout, parent, false);
        return new GalleryViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Art art = artName.get(position);
        Glide.with(holder.itemView)
                .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/59/985/" + art.getArtId().toLowerCase() + ".640x640_640.jpg")
                .fitCenter()
                .into(holder.artCover);
        holder.artName.setText(art.getArtTitle());
        holder.artType.setText(String.valueOf(art.getArtAdditionalType()));
    }

    @Override
    public int getItemCount() {
        return artName.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView artName, artType;
        public ImageView artCover;
        private RecyclerViewClickListener listener;

        public GalleryViewHolder(@NonNull View itemView, RecyclerViewClickListener mListener) {
            super(itemView);
            this.listener = mListener;
            itemView.setOnClickListener(this);
            artName = itemView.findViewById(R.id.artName);
        }

        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }

    public void setData(ArrayList<Art> data) {
        artName.addAll(data);
        notifyDataSetChanged();
    }
}
