package com.tos.retrofitokhttpcaching.repository;

import com.tos.retrofitokhttpcaching.model.photo.PhotoData;
import com.tos.retrofitokhttpcaching.network.APIService;
import com.tos.retrofitokhttpcaching.network.RootUrl;
import com.tos.retrofitokhttpcaching.network.WebInterface;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {
    private WebInterface webInterface;

    public PhotoRepository() {
    }

    public MutableLiveData<List<PhotoData>> getPhotos() {
        MutableLiveData<List<PhotoData>> listMutableLiveData = new MutableLiveData<>();
        webInterface = APIService.createService(WebInterface.class, RootUrl.BASE_URL_PHOTO);
        webInterface.getPhotoData()
                .enqueue(new Callback<List<PhotoData>>() {
                    @Override
                    public void onResponse(@NotNull Call<List<PhotoData>> call, @NotNull Response<List<PhotoData>> response) {
                        if (response.code() == 200) {
                            listMutableLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<List<PhotoData>> call, @NotNull Throwable t) {

                    }
                });
        return listMutableLiveData;
    }
}
