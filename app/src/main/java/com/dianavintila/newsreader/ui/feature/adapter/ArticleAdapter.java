package com.dianavintila.newsreader.ui.feature.adapter;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dianavintila.newsreader.ui.launch.NewsItemDetailsActivity;
import com.dianavintila.newsreader.databinding.NewsItemBinding;
import com.dianavintila.newsreader.ui.feature.model.ArticleItemViewModel;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleItemViewHolder> {

    private List<ArticleItemViewModel> articleModeList;

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
            intent.putExtra(NewsItemDetailsActivity.TITLE, articleModeList.get(position).Title);
            intent.putExtra(NewsItemDetailsActivity.CONTENT, articleModeList.get(position).Content);
            intent.putExtra(NewsItemDetailsActivity.URL, articleModeList.get(position).URLImage);
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return articleModeList.size();
    }

    public void setItems(List<ArticleItemViewModel> items) {
        this.articleModeList = items;
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
