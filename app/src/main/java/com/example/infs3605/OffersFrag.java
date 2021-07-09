package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OffersFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OffersFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OffersFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OffersFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static OffersFrag newInstance(String param1, String param2) {
        OffersFrag fragment = new OffersFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    private RecyclerView mRecyclerView;
    private OffersAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offers, container, false);
        inrecyclerview(view);
        return view;
    }


        private void inrecyclerview (View view)
        {
        mRecyclerView = view.findViewById(R.id.Offers_rv);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
mRecyclerView.setLayoutManager(layoutManager);
        //3. calling recycleviewclicklistner method from the Attractions adapter class calling the launch detail activity method to switcch pages.
        OffersAdapter.RecyclerViewClickListener listener = new OffersAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String AttractionCode) {
     //           launchDetailActivity(AttractionCode);
            }
        };


        // 4. declaring an adapter type variable which takes in array list from attractions class before assigning it to the recycler view.
        mAdapter = new OffersAdapter(Offers.getAttractions(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    //5. method used to launch detail activity populated with the correct data.
  //  private void launchDetailActivity(String message) {
    //    Intent intent = new Intent(this, OffersDetailActivity.class);
     //   intent.putExtra(OffersDetailActivity.INTENT_MESSAGE, message);
      //  startActivity(intent);


    //}
}

//    @Override
//6. altering the menu bar to have a search view option, the method then checks the query against items in the recycler view using the filer method from the adapter class.
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        SearchView SearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        SearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                mAdapter.getFilter().filter(s);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                mAdapter.getFilter().filter(s);
//                return false;
//            }
//        });
//        return true;
//    }

//7. Method uses cases to distinguish between which filter option has been selected and filters results accordingly.
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.Sort_Rating:
//                mAdapter.sort(AttractionsAdapter.SORT_METHOD_RATINGHL);
//                return true;
//            case R.id.sort_Rating2:
//                mAdapter.sort(AttractionsAdapter.SORT_METHOD_RATINGLH);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//}
