package com.dianavintila.newsreader.ui.feature.fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.dianavintila.newsreader.databinding.NewsListBinding;
import com.dianavintila.newsreader.ui.feature.model.NewsListViewModel;
import com.dianavintila.newsreader.ui.feature.model.factory.ViewModelFactory;
import com.dianavintila.newsreader.ui.feature.navigator.AlertNavigator;

public class NewsListFragment extends Fragment {
    private AlertNavigator alertNavigator;
    private NewsListViewModel viewModel;
    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertNavigator = new AlertNavigator(requireContext());
        viewModel = new ViewModelProvider(this, new ViewModelFactory(requireActivity().getApplication())).get(NewsListViewModel.class);
        viewModel.openLink.observe(this, this::openLink);
        viewModel.error.observe(this, throwable -> alertNavigator.showErrorFor(throwable));
        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsListBinding binding = NewsListBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    private void openLink(@NonNull String link) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }

}