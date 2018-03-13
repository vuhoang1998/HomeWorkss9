package com.example.hoang.storylib;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoryActivity extends AppCompatActivity {

    private static final String TAG = "StoryActivity";
    @BindView(R.id.guideline)
    Guideline guideline;
    @BindView(R.id.guideline2)
    Guideline guideline2;
    @BindView(R.id.guideline3)
    Guideline guideline3;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_descrip)
    TextView tvDescrip;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_bookmark)
    ImageView ivBookmark;
    @BindView(R.id.tv_startread)
    TextView tvStartread;
    StoryModel storyModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);
        setupUI();
        loadData();
    }

    private void setupUI() {
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) getSupportActionBar().hide();

    }

    private void loadData() {
        storyModel = (StoryModel) getIntent().getSerializableExtra("title");
        tvAuthor.setText(storyModel.author);
        tvTitle.setText(storyModel.title);
        tvDescrip.setText(storyModel.description);
        if (storyModel.bookmark == 1) ivBookmark.setColorFilter(Color.parseColor("#FFEB3B"));
        Picasso.get().load(storyModel.imageURL).into(ivImage);


    }


    @OnClick({R.id.iv_back, R.id.iv_bookmark, R.id.tv_startread})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.iv_bookmark:
                if (storyModel.bookmark == 1) ivBookmark.setColorFilter(Color.parseColor("#FFFFFF"));
                else ivBookmark.setColorFilter(Color.parseColor("#FFEB3B"));
                DatabaseManager.getInstance(this).updateBookmark(storyModel);
                Log.d(TAG, "onViewClicked: "+ storyModel.title +" "+ storyModel.bookmark);
                loadData();
                break;
            case R.id.tv_startread:
                break;
        }
    }

}
