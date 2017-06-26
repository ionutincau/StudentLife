package com.whiteshadow.studentlife.grades;

import android.app.Activity;

import com.whiteshadow.studentlife.App;
import com.whiteshadow.studentlife.domain.DaoSession;
import com.whiteshadow.studentlife.domain.Grade;
import com.whiteshadow.studentlife.domain.GradeDao;

import java.util.List;

/**
 * Created by Incau Ionut on 14-Jun-17.
 * Contact: ionut.incau@gmail.com
 */

public class GradeProvider {
    private static GradeProvider instance;

    private GradeProvider() {

    }

    public static GradeProvider getInstance() {
        if (instance == null) {
            instance = new GradeProvider();
        }
        return instance;
    }

    public List<Grade> getSemesterGrades(Activity activity, int semester) {
        DaoSession daoSession = ((App) activity.getApplication()).getDaoSession();
        GradeDao gradeDao = daoSession.getGradeDao();
        List<Grade> list = gradeDao.queryBuilder().where(GradeDao.Properties.Semester.eq(semester)).list();
        return list;
    }

    public void addDummyData(GradeDao gradeDao) {
        addGrade(gradeDao, 1, "Algebra 1 - Algebră liniară", 8, 6);
        addGrade(gradeDao, 1, "Analiză matematică 1 - Analiza pe R", 7, 6);
        addGrade(gradeDao, 1, "Comunicare şi dezvoltare profesională în informatică", 10, 3);
        addGrade(gradeDao, 1, "Educaţie fizică 1", 10, 0);
        addGrade(gradeDao, 1, "Fundamentele programării", 10, 6);
        addGrade(gradeDao, 1, "Geometrie 1 - Geometrie analitică", 6, 6);
        addGrade(gradeDao, 1, "Logică matematică", 6, 6);

        addGrade(gradeDao, 2, "Algebra 2 - Structuri algebrice de bază", 6, 5);
        addGrade(gradeDao, 2, "Analiză matematică 2 - Calcul diferenţial în Rn", 5, 5);
        addGrade(gradeDao, 2, "Educaţie fizică 2", 10, 0);
        addGrade(gradeDao, 2, "Geometrie 2 - Geometrie afină", 6, 5);
        addGrade(gradeDao, 2, "Programare orientată obiect", 10, 5);
        addGrade(gradeDao, 2, "Structuri de date şi algoritmi", 10, 5);
        addGrade(gradeDao, 2, "Teoria numerelor", 9, 5);

        addGrade(gradeDao, 3, "Analiză matematică 3 - Calcul integral în Rn", 6, 5);
        addGrade(gradeDao, 3, "Arhitectura sistemelor de calcul", 10, 5);
        addGrade(gradeDao, 3, "Baze de date", 9, 5);
        addGrade(gradeDao, 3, "Ecuaţii diferenţiale", 7, 5);
        addGrade(gradeDao, 3, "Geometrie 3 - Geometria diferențială a curbelor şi suprafeţelor", 9, 5);
        addGrade(gradeDao, 3, "Limba engleză 1", 7, 3);
        addGrade(gradeDao, 3, "Metode avansate de programare", 10, 5);

        addGrade(gradeDao, 4, "Analiză numerică", 9, 6);
        addGrade(gradeDao, 4, "Capitole speciale de ecuaţii diferenţiale ordinare", 8, 4);
        addGrade(gradeDao, 4, "Funcţii reale", 5, 5);
        addGrade(gradeDao, 4, "Limba engleză 2", 9, 3);
        addGrade(gradeDao, 4, "Mecanică teoretică", 5, 5);
        addGrade(gradeDao, 4, "Probabilităţi", 6, 5);
        addGrade(gradeDao, 4, "Sisteme de operare", 9, 5);

        addGrade(gradeDao, 5, "Analiză complexă", 6, 4);
        addGrade(gradeDao, 5, "Ecuaţii cu derivate parţiale", 8, 4);
        addGrade(gradeDao, 5, "Limbaje formale și tehnici de compilare", 9, 5);
        addGrade(gradeDao, 5, "Metodologia documentării şi elaborării unei lucrări ştiinţifice", 10, 4);
        addGrade(gradeDao, 5, "Practică în matematică/informatică", 10, 4);
        addGrade(gradeDao, 5, "Software matematic", 10, 4);
        addGrade(gradeDao, 5, "Statistică matematică", 7, 5);

        addGrade(gradeDao, 6, "Elaborarea lucrării de licență", 10, 2);
        addGrade(gradeDao, 6, "Ingineria sistemelor soft", 8, 6);
        addGrade(gradeDao, 6, "Inteligență artificială", 7, 6);
        addGrade(gradeDao, 6, "Istoria informatici", 10, 3);
        addGrade(gradeDao, 6, "Proiect colectiv", 10, 3);
        addGrade(gradeDao, 6, "Rețele de calculatoare", 9, 5);
        addGrade(gradeDao, 6, "Tehnici de optimizare",	5, 5);
    }

    public void addGrade(GradeDao gradeDao, int semester, String courseName, int number, int credits) {
        Grade grade = new Grade();
        grade.setSemester(semester);
        grade.setCourseName(courseName);
        grade.setNumber(number);
        grade.setCredits(credits);
        gradeDao.insert(grade);
    }
}
