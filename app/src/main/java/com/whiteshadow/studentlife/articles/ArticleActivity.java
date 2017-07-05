package com.whiteshadow.studentlife.articles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.Article;

/**
 * Created by Incau Ionut on 05-Jul-17.
 * Contact: ionut.incau@gmail.com
 */

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Article article = getIntent().getParcelableExtra("article");
        this.setTitle(article.getTitle());

        setContentView(R.layout.activity_article);
        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_article, new ArticleFragment())
                    .commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
