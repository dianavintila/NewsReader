package com.dianavintila.data.features.news.local.mapper;
import com.dianavintila.data.features.news.local.ArticleEntity;
import com.dianavintila.data.features.news.model.Article;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.functions.Function;


public class ArticleListToEntityMapper implements Function<List<Article>, List<ArticleEntity>> {

    private final static String DEFAULT_TITLE = "Default title";
    private final static String DEFAULT_CONTENT = "Default content";
    private final static String DEFAULT_URL = "https://i.pinimg.com/736x/7c/1c/a4/7c1ca448be31c489fb66214ea3ae6deb.jpg";

    @Override
    public List<ArticleEntity> apply(List<Article> articles) {
        List<ArticleEntity> articleEntities = new ArrayList<>();
        for (Article currentArticle : articles) {
            String title = !currentArticle.title.equals("") ? currentArticle.title : DEFAULT_TITLE;
            String content = !currentArticle.content.equals("") ? currentArticle.content : DEFAULT_CONTENT;
            String urlImage = !currentArticle.imageUrl.equals("")? currentArticle.title : DEFAULT_URL;
            ArticleEntity entity = new ArticleEntity(title,content,urlImage);
            articleEntities.add(entity);
        }

        return articleEntities;
    }
}
