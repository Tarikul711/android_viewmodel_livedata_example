package com.tos.retrofitokhttpcaching.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tos.retrofitokhttpcaching.R;
import com.tos.retrofitokhttpcaching.ui.adapter.PostAdapter;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;
import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.viewModel.PostListViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    RecyclerView recyclerView;
    Context context;
    private static final String TAG = "MainActivity";
    PostAdapter adapter;
    List<PostData> posts = new ArrayList<>();
    PostListViewModel postListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        postListViewModel = new ViewModelProvider(this).get(PostListViewModel.class);
        postListViewModel.init();
        initView();

    }

    public void initView() {
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);


        // live data
        postListViewModel.getPosts().observe(this, new Observer<List<PostData>>() {
            @Override
            public void onChanged(List<PostData> postData) {
                progressBar.setVisibility(View.GONE);
                posts = postData;
                adapter = new PostAdapter(context, posts);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

            }
        });

    }

}
