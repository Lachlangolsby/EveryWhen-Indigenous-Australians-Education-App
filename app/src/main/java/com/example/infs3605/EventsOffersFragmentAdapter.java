package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class EventsOffersFragmentAdapter extends FragmentStateAdapter {
    public EventsOffersFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1 :
                return new OffersFrag();
        }

        return new EventsFragment();

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
