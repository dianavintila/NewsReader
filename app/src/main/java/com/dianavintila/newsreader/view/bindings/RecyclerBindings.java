package com.dianavintila.newsreader.view.bindings;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dianavintila.newsreader.ui.feature.adapter.ArticleAdapter;
import com.dianavintila.newsreader.ui.feature.listener.ArticleHandler;
import com.dianavintila.newsreader.ui.feature.model.ArticleItemViewModel;
import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"newsList","articleHandler"})
    public static void refresh(RecyclerView recyclerView, List<ArticleItemViewModel> newsList, ArticleHandler handler) {
        ArticleAdapter adapter = (ArticleAdapter) recyclerView.getAdapter();

        if (adapter == null) {
            adapter = new ArticleAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(adapter);
        }

        adapter.setItems(newsList, handler);
    }
}
