package com.example.mvvmpractice;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmpractice.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepo {
    public MutableLiveData<List<PostModel>> getPostData() {
        final MutableLiveData<List<PostModel>> postModel = new MutableLiveData<>();

        ApiInterface apiService =
                RetrofitCliet.getRetrofitInstance().create(ApiInterface.class);

        apiService.getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                Log.e("response", "getCurrencyList response="+response );

                if (response.isSuccessful() && response.body()!=null ) {
                    Log.e("response", "response.size="+response.body().size() );
                    postModel.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.e("response", "getProdList onFailure" + call.toString());
            }
        });

        return postModel;
    }
}
