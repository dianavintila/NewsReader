package com.dianavintila.data.repository;
import androidx.annotation.NonNull;
import com.dianavintila.data.features.news.model.Article;
import java.util.List;
import io.reactivex.Single;

public interface NewsRepository {
    @NonNull
    Single<List<Article>> getNewsArticles();
}
