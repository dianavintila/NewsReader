package com.dianavintila.newsreader.ui.feature.model;
import androidx.annotation.Nullable;


public class ArticleItemViewModel {
    @Nullable
    public Integer id;
    public String Title;
    public String Content;
    public String URLImage;

    public ArticleItemViewModel(String title, String content, String imageURL) {
        this.Title = title;
        this.Content = content;
        this.URLImage = imageURL;
    }
}
