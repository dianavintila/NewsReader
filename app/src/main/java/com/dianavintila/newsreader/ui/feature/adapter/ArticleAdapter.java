package com.dianavintila.newsreader.ui.feature.adapter;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dianavintila.newsreader.databinding.NewsItemBinding;
import com.dianavintila.newsreader.ui.feature.listener.ArticleHandler;
import com.dianavintila.newsreader.ui.launch.NewsItemDetailsActivity;
import com.dianavintila.newsreader.ui.feature.model.ArticleItemViewModel;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleItemViewHolder> {

    private List<ArticleItemViewModel> articleModeList;
    private ArticleHandler handler;

    public ArticleAdapter() {
        this.articleModeList = new ArrayList<>();
    }

    @NotNull
    @Override
    public ArticleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewsItemBinding binder = NewsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ArticleItemViewHolder(binder);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ArticleItemViewHolder holder, int position) {

        holder.binding.setViewModel(articleModeList.get(position));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), NewsItemDetailsActivity.class);
            NewsItemDetailsActivity.TITLE = articleModeList.get(position).Title;
            NewsItemDetailsActivity.CONTENT = articleModeList.get(position).Content;
            NewsItemDetailsActivity.URL = articleModeList.get(position).URLImage;

            if(NewsItemDetailsActivity.URL==null || NewsItemDetailsActivity.URL.equals(""))
                NewsItemDetailsActivity.URL = "https://i.pinimg.com/736x/7c/1c/a4/7c1ca448be31c489fb66214ea3ae6deb.jpg";

            holder.itemView.getContext().startActivity(intent);
        });

        holder.binding.setHandler(handler);

    }

    @Override
    public int getItemCount() {
        return articleModeList.size();
    }

    public void setItems(List<ArticleItemViewModel> items, ArticleHandler handler) {
        this.articleModeList = items;
        this.handler = handler;
        notifyDataSetChanged();
    }

    public static class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        final NewsItemBinding binding;
        public ArticleItemViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
