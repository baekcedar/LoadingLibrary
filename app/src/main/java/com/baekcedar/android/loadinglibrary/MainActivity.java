package com.baekcedar.android.loadinglibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar) findViewById(R.id.progressBar);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url ="http://cfile7.uf.tistory.com/image/250D44415488D11D315948";
                bar.setVisibility(View.VISIBLE);
//                Glide.with(MainActivity.this).load(url).listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//
//                        bar.setVisibility(View.GONE);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        bar.setVisibility(View.GONE);
//                        return false;
//                    }
//                })
//                .into(imageView);

                Picasso.with(MainActivity.this).load(url).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        bar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
            }
        });
    }
}
