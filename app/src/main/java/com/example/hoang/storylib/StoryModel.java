package com.example.hoang.storylib;

import java.io.Serializable;

/**
 * Created by hoang on 3/9/2018.
 */

public class StoryModel implements Serializable{

    public int id;
    public String imageURL;
    public String title;
    public String description;
    public String content;
    public String author;
    public int bookmark;

    public StoryModel(int id, String imageURL, String title, String description, String content, String author, int bookmark) {
        this.id = id;
        this.imageURL = imageURL;
        this.title = title;
        this.description = description;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "StoryModel{" +
                "id=" + id +
                ", imageURL='" + imageURL + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", bookmark='" + bookmark + '\'' +
                '}';
    }
}
