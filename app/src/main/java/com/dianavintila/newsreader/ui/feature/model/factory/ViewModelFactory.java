package com.dianavintila.newsreader.ui.feature.model.factory;
import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.dianavintila.data.repository.NewsRepository;
import com.dianavintila.newsreader.ui.launch.NewsReaderApplication;
import com.dianavintila.newsreader.ui.feature.model.NewsListViewModel;
import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final Application application;
    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @NotNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {

        if (modelClass.isAssignableFrom(NewsListViewModel.class)) {
            NewsRepository repo = NewsReaderApplication.getRepoProvider().provideNewsRepository();
            return (T) new NewsListViewModel(application, repo);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
