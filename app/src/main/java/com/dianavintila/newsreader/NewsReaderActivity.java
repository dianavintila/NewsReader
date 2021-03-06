package com.dianavintila.newsreader;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dianavintila.newsreader.ui.feature.fragment.NewsListFragment;

public class NewsReaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}