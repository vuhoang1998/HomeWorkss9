package com.example.hoang.storylib;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.hoang.storylib.R.*;

/**
 * Created by hoang on 3/10/2018.
 */

public class StoryListView extends BaseAdapter {
    List<StoryModel> storyModelList;

    public StoryListView(List<StoryModel> storyModelList) {
        this.storyModelList = storyModelList;
    }

    @Override
    public int getCount() {
        return storyModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return storyModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return storyModelList.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        convertView = layoutInflater.inflate(layout.item_list_story, parent,false);
        StoryModel  storyModel = (StoryModel) getItem(position);
        TextView tvTitle = convertView.findViewById(id.tv_title);
        TextView tvAuthor = convertView.findViewById(id.tv_author);
        ImageView ivBookMark = convertView.findViewById(id.iv_check);
        ImageView ivPic = convertView.findViewById(id.iv_pic);
        Picasso.get().load(storyModel.imageURL).fit().into(ivPic);
        if (storyModel.bookmark == 1) ivBookMark.setColorFilter(Color.parseColor("#FFEB3B"));
        Log.d(TAG, "getView: " + storyModel.imageURL);

        tvTitle.setText(storyModel.title);
        tvAuthor.setText(storyModel.author);
        return convertView;
    }
}
