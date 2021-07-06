package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TopSearchAdapter extends RecyclerView.Adapter<TopSearchAdapter.TopSearchViewHolder> {

    private ArrayList<String> mName;
    private RecyclerViewClickListener mListener;

    public TopSearchAdapter(ArrayList<String> name, RecyclerViewClickListener listener){
        mName = name;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String locationName);
    }

    @NonNull
    @Override
    public TopSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_top_search, parent, false);
        return new TopSearchViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSearchViewHolder holder, int position) {
        holder.name.setText(mName.get(position));
    }

    @Override
    public int getItemCount() {
        return mName.size();
    }

    public static class TopSearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        private RecyclerViewClickListener listener;

        public TopSearchViewHolder(@NonNull View itemView, RecyclerViewClickListener mListener) {
            super(itemView);
            this.listener = mListener;
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
        }

        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }
}
