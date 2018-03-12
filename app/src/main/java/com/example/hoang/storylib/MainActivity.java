package com.example.hoang.storylib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvStory;
    StoryListView storyListView;
    public List<StoryModel> storyModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyModelList = DatabaseManager.getInstance(this).getStoryTopic();

        lvStory = findViewById(R.id.elv_story);
        storyListView = new StoryListView(storyModelList);
        lvStory.setAdapter(storyListView);
        lvStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StoryModel storyModel = storyModelList.get(position);
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("title",storyModel);
                startActivity(intent);
            }
        });


    }
    
}
