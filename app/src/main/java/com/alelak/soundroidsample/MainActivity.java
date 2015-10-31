package com.alelak.soundroidsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.alelak.soundroid.Soundroid;
import com.alelak.soundroid.models.Track;
import com.alelak.soundroid.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private SongAdapter songAdapter;
    private List<Track> tracks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        setupRecyclerView();
        setupSwipeRefreshLayout();
        getContent();

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupSwipeRefreshLayout() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getContent();
            }
        });
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerView.setHasFixedSize(true);
        tracks = new ArrayList<>();
        songAdapter = new SongAdapter(tracks, this);
        recyclerView.setAdapter(songAdapter);
    }


    private void getContent() {
        Call<List<Track>> call = Soundroid.getSoundcloudService().searchTracksByGenres("House", 20);
        call.enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Response<List<Track>> response, Retrofit retrofit) {
                swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccess()) {
                    tracks.clear();
                    tracks.addAll(response.body());
                    songAdapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
