package com.dianavintila.data.features.news.remote;
import com.dianavintila.data.features.news.model.Article;
import com.dianavintila.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.dianavintila.data.remote.NewsApi;
import java.util.List;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

public class NewsRemoteSource {
    private static final String API_KEY = "890dcbbd35ca4c01be68d0aa1b5a0f92";
    private static final String EN_LANGUAGE_FILTER = "en";

    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                .subscribeOn(Schedulers.io())
                .map(new NewsDtoToNewsMapper());
    }
}
