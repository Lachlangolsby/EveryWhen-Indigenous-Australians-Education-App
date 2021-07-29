package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StoriesMain extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private StoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_main);
        setTitle("Stories");

        mRecyclerView = findViewById(R.id.stories_rv);
        mRecyclerView.setHasFixedSize(true);
        StoriesAdapter.RecyclerViewClickListener listener = new StoriesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String id) {
                launchStoriesDetailActivity(id);
            }
        };
        mAdapter = new StoriesAdapter(Stories.getStories(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void launchStoriesDetailActivity(String message) {
        Intent intent = new Intent(this, StoriesDetailActivity.class);
        intent.putExtra(StoriesDetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                mAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                mAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.sort_rating:
//                mAdapter.sort(MovieAdapter.SORT_METHOD_RATING);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}