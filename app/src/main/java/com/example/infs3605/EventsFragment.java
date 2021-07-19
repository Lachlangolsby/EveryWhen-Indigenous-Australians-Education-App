package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SearchView eventSv;
    private EventsAdapter mEventAdapter;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        View rootEventView = inflater.inflate(R.layout.fragment_events, container, false);
        RecyclerView eventRecyclerView = rootEventView.findViewById(R.id.rvEventsList);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment

        EventsAdapter.Listener listener = new EventsAdapter.Listener() {
            @Override
            public void onClick(View view, String eventName) {
                launchDetailEventsActivity(eventName);
            }
        };

        mEventAdapter = new EventsAdapter(Event.getEvents(), listener);
        eventRecyclerView.setAdapter(mEventAdapter);
        setHasOptionsMenu(true);
        return rootEventView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.events_menu, menu);
        eventSv = (SearchView) menu.findItem(R.id.events_search).getActionView();
        eventSv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mEventAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mEventAdapter.getFilter().filter(query);
                return false;
            }
        });
    }

    private void launchDetailEventsActivity(String message) {
        Intent intent = new Intent(this.getContext(), EventsDetailActivity.class);
        intent.putExtra(EventsDetailActivity.EVENT_MESSAGE, message);
        startActivity(intent);
    }
}