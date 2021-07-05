package com.dianavintila.data.features.news.local;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;
    public String title;
    public String content;
    public String urlImage;

    @org.jetbrains.annotations.Nullable
    public Integer getId() {
        return id;
    }
    public void setId(@Nullable Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
