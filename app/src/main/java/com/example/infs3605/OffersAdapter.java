package com.example.infs3605;



import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> implements Filterable {
    // 1. Declaring public variables to be accessed throughout application and private for adapter class
    public static final int SORT_METHOD_RATINGHL = 1;
    public static final int SORT_METHOD_RATINGLH = 2;
    private ArrayList<Offers> mOffers;
    private ArrayList<Offers> mOffersFiltered;
    private RecyclerViewClickListener mListener;


    // 2. Creating constructor for adapter class.
    public OffersAdapter(ArrayList<Offers> Offers, RecyclerViewClickListener listener) {
        mOffers = Offers;
        mOffersFiltered = Offers;
        mListener = listener;


    }

    // 3. creating filter search method
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                //4. creating charString variable to assess search has been entered
                String charString = charSequence.toString();
                //5. using if statements to adjust ArrayList before returning filtered results
                if (charString.isEmpty()) {
                    mOffersFiltered = mOffers;
                } else {
                    ArrayList<Offers> filteredList = new ArrayList<>();
                    for (Offers offers : mOffers) {
                        if (offers.getOffer().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(offers);
                        }
                    }

                    mOffersFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mOffersFiltered;
                return filterResults;
            }

            //6. publish results of filter() and changing data set
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mOffersFiltered = (ArrayList<Offers>) filterResults.values;
                notifyDataSetChanged();


            }
        };
    }

    //7. View holder required for recycler view, uses list row layout.
    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_offers_tile, parent, false);
        return new OffersViewHolder(v, mListener);
    }


    @SuppressLint("SetTextI18n")
    //8. on bind view holder method retrieves data from attractions class and holds the correct data in each list row using attractions get methods.
    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder holder, int position) {
        Offers offers = mOffersFiltered.get(position);
        DecimalFormat df = new DecimalFormat("#,###,###,###");
        holder.offer.setText(offers.getOffer());
        holder.type.setText(offers.getType());
        holder.location.setText(offers.getLocation());
        holder.description.setText(offers.getDescription());
        Picasso.with(holder.context).load(offers.getImageUrl()).resize(122, 195).into(holder.image); // Using Picasso API to retrieve images from the web.
        holder.itemView.setTag(offers.getAttractionCode());
    }

    // 9. setting row count to number of items within the ArrayList
    @Override
    public int getItemCount() {
        return mOffersFiltered.size();
    }

    // 10. Filtering method created
//    public void sort(final int sortMethod) {
//        // 11. if a filtering option is selected . size will be > 0 then the comparator and if statements will filter results accordingly. before changing the data set shown on the UI.
//        if (mOffersFiltered.size() > 0) {
//            Collections.sort(mOffersFiltered, new Comparator<Offers>() {
//                @Override
//                public int compare(Offers t0, Offers t1) {
//                    if (sortMethod == SORT_METHOD_RATINGHL) {
//                        return Double.toString(t1.getRating()).compareTo(Double.toString(t0.getRating()));
//                    } else if (sortMethod == SORT_METHOD_RATINGLH) {
//                        return Double.toString(t0.getRating()).compareTo(Double.toString(t1.getRating()));
//                    }
//                    return Double.toString(t1.getRating()).compareTo(Double.toString(t0.getRating()));
//                }
//            });
//        }
//        notifyDataSetChanged();
//    }

    // 12. creating interface RecyclerViewOnClickListener, which uses the on click method to take in a view and country code
    public interface RecyclerViewClickListener {
        void onClick(View view, String AttractionCode);
    }

    //13. assigning variables to UI XML elements used in the onBindViewHolder
    public static class OffersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView offer, location, type, description;
        public ImageView image;
        public Context context;
        private OffersAdapter.RecyclerViewClickListener listener;


        public OffersViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            offer = itemView.findViewById(R.id.tvTitle);
            description = itemView.findViewById(R.id.tvDescription);
            image = itemView.findViewById(R.id.ivSight);
            context = itemView.getContext();
            type = itemView.findViewById(R.id.tvType);
            location = itemView.findViewById(R.id.tvLocation);

        }

        // 14. on click method to be used by recycler view in order to take in correct information.
        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }
}
