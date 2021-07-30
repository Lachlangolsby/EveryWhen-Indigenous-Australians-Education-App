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
import java.util.Random;

public class ArtGalleryAdapter extends RecyclerView.Adapter<ArtGalleryAdapter.GalleryViewHolder> implements Filterable {

    private ArrayList<Art> mArtworks;
    private ArrayList<Art> mArtworksFiltered;
    private RecyclerViewClickListener mListener;
    public static final int SORT_AZ = 1;
    public static final int SORT_TYPE = 2;

    public ArtGalleryAdapter(ArrayList<Art> artworks, RecyclerViewClickListener listener){
        mArtworks = artworks;
        mArtworksFiltered = artworks;
        mListener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint)  {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    mArtworksFiltered = mArtworks;
                } else {
                    ArrayList<Art> filteredList = new ArrayList<>();
                    for (Art attraction: mArtworks) {
                        if(attraction.getArtTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(attraction);
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
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.art_gallery_item, parent, false);
        return new GalleryViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Art art = mArtworksFiltered.get(position);
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
            artName = itemView.findViewById(R.id.art_name);
            artType = itemView.findViewById(R.id.art_type);
        }

        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }

    public void sort (final int sort) {

        if(mArtworksFiltered.size() > 0) {
            Collections.sort(mArtworksFiltered, new Comparator<Art>() {
                @Override
                public int compare(Art o1, Art o2) {

                    if (sort == SORT_AZ) {
                        return o1.getArtTitle().compareTo(o2.getArtTitle());
                    } else if (sort == SORT_TYPE) {
                        return o1.getArtType().compareTo(o2.getArtType());
                    }
                    return o2.getArtTitle().compareTo(o1.getArtTitle());
                }
            });
        }
        notifyDataSetChanged();
    }
}
