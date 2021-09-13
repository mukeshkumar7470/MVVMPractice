package com.example.mvvmpractice.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmpractice.ApiRepo;
import com.example.mvvmpractice.model.PostModel;

import java.util.List;

public class PostViewModel extends ViewModel {
    ApiRepo apiRepo;
    MutableLiveData<List<PostModel>> getPosts;

    public PostViewModel () {
        apiRepo = new ApiRepo();
    }

    public LiveData<List<PostModel>> getPostData () {
        if (getPosts == null) {
            getPosts = apiRepo.getPostData();
        }

        return getPosts;
    }
}
