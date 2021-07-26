package com.example.infs3605;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        ImageButton fvrt_btn;
        DatabaseReference favouriteref;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        private RecyclerViewClickListener listener;

        public GalleryViewHolder(@NonNull View itemView, RecyclerViewClickListener mListener) {
            super(itemView);
            this.listener = mListener;
            itemView.setOnClickListener(this);
            artCover = itemView.findViewById(R.id.artCover);
            artName = itemView.findViewById(R.id.rel_art_name);
            artType = itemView.findViewById(R.id.rel_art_type);
        }

        public void favouriteChecker(final String postkey) {
            fvrt_btn = itemView.findViewById(R.id.fvrt_f2_item);


            favouriteref = database.getReference("favourites");
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            final String uid = user.getUid();

            favouriteref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.child(postkey).hasChild(uid)) {
                        fvrt_btn.setImageResource(R.drawable.ic_baseline_star_24);
                    } else {
                        fvrt_btn.setImageResource(R.drawable.ic_baseline_star_border_24);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        public void setitemRelated(Application activity, String name, String type){

            TextView nametv = itemView.findViewById(R.id.rel_art_name);
            TextView typetv = itemView.findViewById(R.id.rel_art_type);

            nametv.setText(name);
            typetv.setText(type);

        }

        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }
}
