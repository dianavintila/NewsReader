package com.dianavintila.newsreader.ui.feature.model;
import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.dianavintila.data.repository.NewsRepository;
import com.dianavintila.newsreader.ui.feature.model.mapper.ArticlesToVmListMapper;
import com.dianavintila.newsreader.ui.feature.reactive.SingleLiveEvent;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver {

    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;
    public final ObservableBoolean isLoading;
    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;
    public final ObservableList<ArticleItemViewModel> newsList;
    private Disposable disposable;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.isLoading = new ObservableBoolean();
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
        this.newsList = new ObservableArrayList<>();
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh() {
        isLoading.set(true);
        if (newsList.isEmpty()) {
            disposable = repo.getNewsArticles()
                    .map(new ArticlesToVmListMapper())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            this::onNewsArticlesReceived,
                            this::onNewsArticlesError);
        }
    }

    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        isLoading.set(false);
        newsList.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        isLoading.set(false);
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
        isLoading.set(false);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
