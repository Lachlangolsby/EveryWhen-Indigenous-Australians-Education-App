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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder> implements Filterable {

    public static final int SORT_METHOD_ALPHABETICAL = 1;
    private ArrayList<Stories> mStories;
    private ArrayList<Stories> mStoriesFiltered;
    private RecyclerViewClickListener mListener;

    public StoriesAdapter(ArrayList<Stories> stories, RecyclerViewClickListener listener) {
        mStories = stories;
        mStoriesFiltered = stories;
        mListener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint)  {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    mStoriesFiltered = mStories;
                } else {
                    ArrayList<Stories> filteredList = new ArrayList<>();
                    for (Stories story: mStories) {
                        if(story.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(story);
                        }
                    }
                    mStoriesFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mStoriesFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mStoriesFiltered = (ArrayList<Stories>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String id);
    }

    @NonNull
    @Override
    public StoriesAdapter.StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stories, parent, false);
        return new StoriesViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesAdapter.StoriesViewHolder holder, int position) {
        Stories story = mStoriesFiltered.get(position);
        holder.title.setText(story.getTitle());
        holder.img.setImageResource(story.getImg());
        holder.itemView.setTag(story.getId());
    }

    @Override
    public int getItemCount() {
        return mStoriesFiltered.size();
    }

    public class StoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public ImageView img;
        private RecyclerViewClickListener listener;

        public StoriesViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.mStoriesTitle);
            img = itemView.findViewById(R.id.mStoriesImg);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }

    }

    public void sort (final int sort) {

        if(mStoriesFiltered.size() > 0) {
            Collections.sort(mStoriesFiltered, new Comparator<Stories>() {
                @Override
                public int compare(Stories o1, Stories o2) {

                    if (sort == SORT_METHOD_ALPHABETICAL) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                    return o2.getTitle().compareTo(o1.getTitle());
                }
            });
        }
        notifyDataSetChanged();
    }
}