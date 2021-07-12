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
import java.util.Collections;
import java.util.Comparator;

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ArtViewHolder> implements Filterable {
    private ArrayList<Art> mArtworks;
    private ArrayList<Art> mArtworksFiltered;
    private RecyclerViewClickListener mListener;

    public ArtAdapter(ArrayList<Art> artworks, RecyclerViewClickListener listener) {
        mArtworks = artworks;
        mArtworksFiltered = artworks;
        mListener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    mArtworksFiltered = mArtworks;
                } else {
                    ArrayList<Art> filteredList = new ArrayList<>();
                    for(Art art : mArtworks) {
                        if(art.getArtTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(art);
                        }
                    }
                    mArtworksFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mArtworksFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mArtworksFiltered = (ArrayList<Art>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String id);
    }

    @NonNull
    @Override
    public ArtAdapter.ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_gallery_layout, parent, false);
        return new ArtViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtAdapter.ArtViewHolder holder, int position) {
        Art art = mArtworksFiltered.get(position);
        Glide.with(holder.itemView)
                .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/59/985/" + art.getArtId().toLowerCase() + ".640x640_640.jpg")
                .fitCenter()
                .into(holder.image);
        holder.title.setText(art.getArtTitle());
        holder.type.setText(String.valueOf(art.getArtAdditionalType()));
    }

    @Override
    public int getItemCount() {
        return mArtworksFiltered.size();
    }

    public class ArtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView image;
        public TextView title, type;
        private RecyclerViewClickListener listener;

        public ArtViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            image = itemView.findViewById(R.id.artCover);
            title = itemView.findViewById(R.id.artName);
            type = itemView.findViewById(R.id.artType);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }

    }

    public void setData(ArrayList<Art> data) {
        mArtworksFiltered.clear();
        mArtworksFiltered.addAll(data);
        notifyDataSetChanged();
    }
}
