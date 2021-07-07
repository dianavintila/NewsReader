package com.dianavintila.data.di;
import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import com.dianavintila.data.features.news.local.store.NewsDatabase;
import com.dianavintila.data.repository.NewsRepository;
import com.dianavintila.data.repository.NewsRepositoryImpl;
import com.dianavintila.data.features.news.local.NewsLocalDataStore;
import com.dianavintila.data.features.news.remote.NewsRemoteSource;
import com.dianavintila.data.remote.HttpClientFactory;
import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private final Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;

    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }

    NewsLocalDataStore provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.articlesDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context.getApplicationContext(),
                            NewsDatabase.class, "NewsDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return database;
    }

}
