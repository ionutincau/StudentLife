package com.whiteshadow.studentlife.articles;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.whiteshadow.studentlife.R;
import com.whiteshadow.studentlife.domain.Article;

/**
 * Created by Incau Ionut on 05-Jul-17.
 * Contact: ionut.incau@gmail.com
 */

public class ArticleFragment extends Fragment {
    private static final String TAG = "ArticleFragment";
    private static Bitmap article_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        ImageView headerImage = (ImageView) view.findViewById(R.id.header_image);
        TextView title = (TextView) view.findViewById(R.id.article_title);
        TextView content = (TextView) view.findViewById(R.id.article_content);

        Intent intent = getActivity().getIntent();
        Article article = intent.getParcelableExtra("article");

        loadArticleImage(getActivity(), article.getUri(), headerImage);
        title.setText(article.getTitle());
        content.setText(article.getContent());
        return view;
    }

    private static void loadArticleImage(final Activity activity, final Uri image_location, final ImageView imageView) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    article_image = Glide
                            .with(activity)
                            .load(image_location)
                            .asBitmap()
                            .into(-1, -1)
                            .get();
                }
                catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void param) {
                imageView.setImageBitmap(article_image);
            }
        }.execute();
    }
}
