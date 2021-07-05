package com.dianavintila.data.features.news.local;
import com.dianavintila.data.features.news.local.mapper.ArticleEntityToListMapper;
import com.dianavintila.data.features.news.local.mapper.ArticleListToEntityMapper;
import com.dianavintila.data.features.news.model.Article;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalDataStore {
    private final ArticlesDAO dao;
    public NewsLocalDataStore(ArticlesDAO dao) {
        this.dao = dao;
    }
    public Single<List<ArticleEntity>> getArticlesList() {
        return dao.queryArticles();
    }
    public Completable insert(ArticleEntity article) {
        return dao.insertArticle(article);
    }

    public Single<List<Article>> fetchData() {
        return getArticlesList().map(new ArticleEntityToListMapper());
    }


    public void saveArticles(List<Article> articles) {

        dao.deleteAllArticles()
                .andThen(
                        Single.just(articles)
                                .map(new ArticleListToEntityMapper())
                                .flatMapCompletable(dao::insertArticles)
                ).subscribeOn(Schedulers.io())
                .subscribe();
    }
}