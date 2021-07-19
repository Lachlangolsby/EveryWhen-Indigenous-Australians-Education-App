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
import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder> implements Filterable {
    private Listener eventListener;
    private ArrayList<Event> eventsList;
    private List<Event> filteredEventList;

    public EventsAdapter(ArrayList<Event> events, Listener listener) {
        eventsList = events;
        filteredEventList = events;
        eventListener = listener;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();

                if(charString.isEmpty()) {
                    filteredEventList = eventsList;
                }else{
                    List<Event> eventFilterList = new ArrayList<>();

                    for (Event event : filteredEventList){
                        if(event.getEventName().toLowerCase().contains(charString.toLowerCase())){
                            eventFilterList.add(event);
                        }
                    }

                    filteredEventList = eventFilterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredEventList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredEventList = (List<Event>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface Listener {
        void onClick(View view, String eventName);
    }

    @NonNull
    @Override
    public EventsAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view, eventListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.EventViewHolder holder, int position) {
        Event event = filteredEventList.get(position);
        holder.eventName.setText(event.getEventName());
        holder.eventMonthDate.setText(event.getEventMonthDate());
        holder.eventSuburb.setText(event.getEventSuburb());
        holder.eventLocation.setText(event.getEventLocation());
        holder.eventDate.setText(event.getEventDate());
        holder.eventImage.setImageResource(event.getEventImageId());
        holder.itemView.setTag(event.getEventName());
    }

    @Override
    public int getItemCount() {
        return filteredEventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView eventName, eventDate, eventLocation, eventSuburb, eventMonthDate;
        public ImageView eventImage;
        private Listener listener;

        public EventViewHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            eventName = itemView.findViewById(R.id.tvEventName);
            eventDate = itemView.findViewById(R.id.tvEventDate);
            eventLocation = itemView.findViewById(R.id.tvEventLocation);
            eventSuburb = itemView.findViewById(R.id.tvEventSuburb);
            eventMonthDate = itemView.findViewById(R.id.tvEventMonthDate);
            eventImage = itemView.findViewById(R.id.ivEventImage);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }
}
