package com.example.mvvmpractice.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmpractice.viewModels.PostViewModel;
import com.example.mvvmpractice.R;
import com.example.mvvmpractice.model.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel = new PostViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel.getPostData().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                for (int i=0; i<postModels.size(); i++) {
                    Log.d("PostData", "onChangedTitle: "+postModels.get(i).getTitle());
                    Log.d("PostData", "onChangedBody: "+postModels.get(i).getBody());
                }
            }
        });
    }
}