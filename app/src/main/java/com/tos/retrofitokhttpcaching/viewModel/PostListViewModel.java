package com.tos.retrofitokhttpcaching.viewModel;

import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.repository.PostListRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PostListViewModel extends ViewModel {

    private MutableLiveData<List<PostData>> data;
    private PostListRepository repository;

    public PostListViewModel() {
        repository = new PostListRepository();
    }

    public void init() {
        if (this.data != null) {
            return;
        }
        this.data = repository.getPosts();
    }

    public MutableLiveData<List<PostData>> getPosts() {
        return this.data;
    }

}
