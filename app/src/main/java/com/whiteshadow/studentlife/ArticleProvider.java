package com.whiteshadow.studentlife;

import android.app.Activity;

import com.whiteshadow.studentlife.domain.Article;
import com.whiteshadow.studentlife.domain.ArticleDao;
import com.whiteshadow.studentlife.domain.DaoSession;

import java.util.List;

/**
 * Created by Incau Ionut on 05-Jul-17.
 * Contact: ionut.incau@gmail.com
 */

public class ArticleProvider {
    private static ArticleProvider instance;

    private ArticleProvider() {

    }

    public static ArticleProvider getInstance() {
        if (instance == null) {
            instance = new ArticleProvider();
        }
        return instance;
    }

    public List<Article> getArticles(Activity activity) {
        DaoSession daoSession = ((App) activity.getApplication()).getDaoSession();
        ArticleDao articleDao = daoSession.getArticleDao();
        List<Article> list = articleDao.queryBuilder().list();
        return list;
    }

    public void addDummyData(ArticleDao articleDao) {
        addArticle(articleDao, "A 3-a ediţie a Graduation Day", "http://www.cs.ubbcluj.ro/wp-content/uploads/Graduation-Day-2015-01.jpg");
        addArticle(articleDao, "Campionatul European de Securitate Cibernetică, ediţia 2017", "http://www.cs.ubbcluj.ro/wp-content/uploads/ECSC-2017-300x300.jpg");
        addArticle(articleDao, "Programul de desfăşurare al Sesiunii de Comunicări Ştiinţifice ale Studenţilor – Informatică, ediţia 2017", "http://www.cs.ubbcluj.ro/wp-content/uploads/SCSS-2015-150x150.jpg");
        addArticle(articleDao, "Startup your idea! From knowledge to business: how to build products from research", "http://www.cs.ubbcluj.ro/wp-content/uploads/Startup-your-Idea-prezentare-UBB-2017.jpg");
        addArticle(articleDao, "Repartizarea locurilor în taberele studențești 2017", "http://www.cs.ubbcluj.ro/wp-content/uploads/tabara-vara-2013-150x150.jpg");
    }

    public void addArticle(ArticleDao scheduleDao, String title, String image_location) {
        Article schedule = new Article();
        schedule.setTitle(title);
        schedule.setImage_location(image_location);
        scheduleDao.insert(schedule);
    }
}
