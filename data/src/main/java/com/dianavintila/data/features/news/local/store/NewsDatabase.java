package com.dianavintila.data.features.news.local.store;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.dianavintila.data.features.news.local.ArticleEntity;
import com.dianavintila.data.features.news.local.ArticlesDAO;


@Database(entities = {ArticleEntity.class}, version = 2)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract ArticlesDAO articlesDao();
}
