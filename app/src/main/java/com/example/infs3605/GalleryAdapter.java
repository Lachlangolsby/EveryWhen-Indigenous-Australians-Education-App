package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private ArrayList<String> artName;
    private RecyclerViewClickListener mListener;

    public GalleryAdapter(ArrayList<String> name, RecyclerViewClickListener listener){
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
        holder.artName.setText(artName.get(position));
    }

    @Override
    public int getItemCount() {
        return artName.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView artName;
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
}
