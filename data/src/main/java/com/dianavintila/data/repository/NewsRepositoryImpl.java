package com.dianavintila.data.repository;
import com.dianavintila.data.features.news.local.NewsLocalDataStore;
import com.dianavintila.data.features.news.model.Article;
import com.dianavintila.data.features.news.remote.NewsRemoteSource;
import java.util.List;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

public class NewsRepositoryImpl implements NewsRepository {
    private final NewsRemoteSource remoteSource;
    private final NewsLocalDataStore localSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalDataStore localSource) {
        this.remoteSource = remoteSource;
        this.localSource = localSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles()
                .doOnSuccess(localSource::saveArticles)
                .onErrorResumeNext(localSource.fetchData());
    }
}
