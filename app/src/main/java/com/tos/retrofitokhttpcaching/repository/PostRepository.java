package com.tos.retrofitokhttpcaching.repository;

import com.tos.retrofitokhttpcaching.model.post.PostData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private WebInterface webInterface;

    public PostRepository() {
    }

    public MutableLiveData<List<PostData>> getPosts() {
        MutableLiveData<List<PostData>> listMutableLiveData = new MutableLiveData<>();
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL);
        webInterface.getPostData()
                .enqueue(new Callback<List<PostData>>() {
                    @Override
                    public void onResponse(@NotNull Call<List<PostData>> call, @NotNull Response<List<PostData>> response) {
                        if (response.code() == 200) {
                            listMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<PostData>> call, Throwable t) {

                    }
                });
        return listMutableLiveData;
    }
}
