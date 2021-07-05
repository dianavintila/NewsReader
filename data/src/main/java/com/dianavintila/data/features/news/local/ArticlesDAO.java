package com.dianavintila.data.features.news.local;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ArticlesDAO {

    @Query("SELECT * FROM articles")
    Single<List<ArticleEntity>> queryArticles();

    @Query("DELETE FROM articles WHERE id= :id")
    Completable deleteArticle(int id);

    @Query("DELETE FROM articles")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);

    @Query("UPDATE articles SET title= :title, content= :content, urlImage= :urlImage WHERE id= :id")
    Completable updateFeed(String title, String content, String urlImage, int id);
}
