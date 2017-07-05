package com.whiteshadow.studentlife;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.whiteshadow.studentlife.domain.Article;

import java.util.List;

/**
 * Created by Incau Ionut on 05-Jul-17.
 * Contact: ionut.incau@gmail.com
 */

public class ArticleAdapter extends ArrayAdapter {
    private static final String TAG = "ArticleAdapter";
    private Activity activity;
    private static Bitmap article_image;

    public static class ViewHolder {
        public final ImageView header_image;
        public final TextView title;

        public ViewHolder(View view) {
            header_image = (ImageView) view.findViewById(R.id.header_image);
            title = (TextView) view.findViewById(R.id.article_title);
        }
    }

    public ArticleAdapter(Context context, int resource, List<Article> articleList) {
        super(context, resource, articleList);
        this.activity = (Activity) context;
        Log.e("Main fragment", "constructor");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = (Article) getItem(position);
        View view = convertView;
        ArticleAdapter.ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.article_item, parent, false);
            holder = new ArticleAdapter.ViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (ArticleAdapter.ViewHolder) view.getTag();
        }

        loadArticleImage(activity, article.getUri(), holder.header_image);
        holder.title.setText(article.getTitle());

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
