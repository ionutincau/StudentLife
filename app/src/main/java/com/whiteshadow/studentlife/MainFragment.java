package com.whiteshadow.studentlife;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.whiteshadow.studentlife.articles.ArticleAdapter;
import com.whiteshadow.studentlife.articles.ArticleProvider;
import com.whiteshadow.studentlife.domain.Article;

import java.util.List;

/**
 * Created by Incau Ionut on 12-Apr-17.
 * Contact: ionut.incau@gmail.com
 */

public class MainFragment extends Fragment {
    private ListView articleListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        articleListView = (ListView) view.findViewById(R.id.listview_article);
        List<Article> list = ArticleProvider.getInstance().getArticles(getActivity());
        ArticleAdapter articleAdapter = new ArticleAdapter(getActivity(), R.layout.article_item, list);
        articleListView.setAdapter(articleAdapter);

        return view;
    }
}
