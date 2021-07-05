package com.dianavintila.newsreader.ui.launch;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.dianavintila.newsreader.R;
import com.dianavintila.newsreader.databinding.NewsDetailsBinding;
import com.squareup.picasso.Picasso;

public class NewsItemDetailsActivity extends AppCompatActivity {
    public static final String TITLE = "TITLE";
    public static final String CONTENT = "CONTENT";
    public static final String URL = "http://jobportico.com/assets/front_end/images/no-image-found.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);
        NewsDetailsBinding detailsBinding =  DataBindingUtil.setContentView(this, R.layout.news_details);
        Intent intent = getIntent();

        detailsBinding.detailsTitle.setText(TITLE);
        detailsBinding.detailsContent.setText(CONTENT);

        Picasso.with(this) // using library Picasso to load image
                .load(URL)
                .into(detailsBinding.imageDetails);


    }
}