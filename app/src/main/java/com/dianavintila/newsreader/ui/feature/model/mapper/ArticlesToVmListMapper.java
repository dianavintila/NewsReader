package com.dianavintila.newsreader.ui.feature.model.mapper;
import com.dianavintila.data.features.news.model.Article;
import com.dianavintila.newsreader.ui.feature.model.ArticleItemViewModel;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.functions.Function;

public class ArticlesToVmListMapper implements Function<List<Article>, List<ArticleItemViewModel>> {

    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {
        List<ArticleItemViewModel> vmItems = new ArrayList<>();
        for (Article article : articles) {
            ArticleItemViewModel viewModelItem = new ArticleItemViewModel(article.title, article.content, article.imageUrl);
            vmItems.add(viewModelItem);
        }
        return vmItems;
    }
}
