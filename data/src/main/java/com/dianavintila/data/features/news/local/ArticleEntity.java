package com.dianavintila.data.features.news.local;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public  Integer id;
    public final String title;
    public final String content;
    public final String urlImage;

    public ArticleEntity(String title, String content, String urlImage) {
        this.title = title;
        this.content = content;
        this.urlImage = urlImage;
    }

}
