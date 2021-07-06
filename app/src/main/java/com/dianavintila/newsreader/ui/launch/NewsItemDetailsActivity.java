package com.dianavintila.newsreader.ui.launch;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.dianavintila.newsreader.R;
import com.dianavintila.newsreader.databinding.NewsDetailsBinding;
import com.squareup.picasso.Picasso;

public class NewsItemDetailsActivity extends AppCompatActivity {
    public static  String TITLE = "TITLE";
    public static  String CONTENT = "CONTENT";
    public static  String URL = "https://i.pinimg.com/736x/7c/1c/a4/7c1ca448be31c489fb66214ea3ae6deb.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);
        NewsDetailsBinding detailsBinding =  DataBindingUtil.setContentView(this, R.layout.news_details);
        Intent intent = getIntent();

        detailsBinding.detailsTitle.setText(NewsItemDetailsActivity.TITLE);
        detailsBinding.detailsContent.setText(NewsItemDetailsActivity.CONTENT);

        Picasso.with(this) // using library Picasso to load image
                .load(NewsItemDetailsActivity.URL)
                .into(detailsBinding.imageDetails);


    }
}