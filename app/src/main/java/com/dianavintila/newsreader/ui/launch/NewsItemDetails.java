package com.dianavintila.newsreader.ui.launch;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.dianavintila.newsreader.R;
import com.dianavintila.newsreader.databinding.NewsDetailsBinding;
import com.dianavintila.newsreader.ui.feature.adapter.ArticleAdapter;
import com.squareup.picasso.Picasso;

public class NewsItemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);
        NewsDetailsBinding detailsBinding =  DataBindingUtil.setContentView(this, R.layout.news_details);
        Intent intent = getIntent();
        String title = intent.getStringExtra(ArticleAdapter.TITLE);
        String content = intent.getStringExtra(ArticleAdapter.CONTENT);
        String url = intent.getStringExtra(ArticleAdapter.URL);

        detailsBinding.detailsTitle.setText(title);
        detailsBinding.detailsContent.setText(content);

        if (url.isEmpty()) {
            detailsBinding.imageDetails.setImageResource(R.drawable.news); // set default image
        } else{
            Picasso.with(this) // using library Picasso to load image
                    .load(url)
                    .into(detailsBinding.imageDetails);
        }




    }
}