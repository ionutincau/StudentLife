package com.whiteshadow.studentlife.articles;

import android.app.Activity;

import com.whiteshadow.studentlife.App;
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
        String a1 = "Datorită succesului ediţiilor anterioare şi a feedback-ului pozitiv primit, Facultatea de Matematică şi Informatică organizează sâmbătă, 08.07.2016, începând cu ora 10, în holul FSEGA, etaj 1, cea de a 3-a ediţie a Graduation Day. În cadrul acestui eveniment puteţi asista la prezentările celor mai bune lucrări de licenţă şi dizertaţie ale absolvenţilor promoţiei 2017. Cele mai bune lucrări vor fi premiate de către firmele partenere ale facultăţii.";
        String a2 = "Ce este ECSC?\n" +
                "\n" +
                "Destinat tinerilor cu abilități în domeniul IT, concursul este o inițiativă a Agenției Uniunii Europene pentru Securitatea Rețelelor și a Informațiilor (ENISA).\n" +
                "\n" +
                "Competiția urmărește:\n" +
                "\n" +
                "creșterea conștientizării privind nevoia de securitate cibernetică și de cunoaștere a amenințărilor din mediul online;\n" +
                "atragerea tinerilor către sectorul IT și securitate cibernetică;\n" +
                "conștientizarea tinerilor cu aptitudini în domeniu cu privire la potențialul și responsabilitățile lor sociale.\n" +
                "De ce merită să te înscrii?\n" +
                "\n" +
                "Concurenții selecționați în echipa României vor beneficia de:\n" +
                "\n" +
                "Recunoaștere națională și promovare în media;\n" +
                "Două stagii specializate de pregătire;\n" +
                "Mentorat cu specialiști din domeniu;\n" +
                "Oportunități de angajare în domeniu;\n" +
                "Toate costurile asigurate de sponsori;\n" +
                "Premii oferite de parteneri;\n" +
                "Participare la competiții internaționale.\n" +
                "Mai multe informații pe www.cybersecuritychallenge.ro\n" +
                "\n" +
                "Cum poți participa?\n" +
                "\n" +
                "Vom selecționa 10 participanți – 5 cu varsta 16-20 ani şi 5 cu varsta 21-25 ani\n" +
                "\n" +
                "30 iunie 2017 data limită de înscriere;\n" +
                "30 iunie – 02 iulie 2017, selecţia online;\n" +
                "Ulterior, selecția on-site, cu exerciții din domeniul securității aplicațiilor web, atacului și apărării cibernetice, criptografiei, analizei traficului de rețea, reverse engineering și al prezentării publice.\n" +
                "\n" +
                "Înscriere pe ctf.cybersecuritychallenge.ro\n" +
                "\n" +
                "Unde se desfășoară ECSC 2017?\n" +
                "\n" +
                "Ediția de anul acesta va avea loc la Málaga, în Spania, în perioada 30 octombrie – 03 noiembrie a.c.\n" +
                "\n" +
                "Te așteptăm în echipa României!";
        String a3 = "Editia 2017 va avea loc la Facultatea de Automatica si Calculatoare, Str. Baritiu Nr. 28, salile D11 si D12. \n" +
                "\n" +
                "Studentii sunt invitati sa trimita lucrari originale care vor fi evaluate si selectionate in vederea prezentarii lor publice si a publicarii ulterioare. Pentru a va inscrie la aceasta manifestare stiintifica va rugam sa trimiteti:\n" +
                "\n" +
                ". o lucrare in format word IEEE, 6-8 pagini, scrisa in limba engleza\n" +
                ". un formular de inscriere\n" +
                "\n" +
                "pana cel tarziu la data de 9 iunie 2016, la adresa de mail dadi@cs.ubbcluj.ro (lect. dr. Adrian Sergiu DARABANT, pentru studentii Universitatii Babes-Bolyai), respectiv paulina.mitrea@cs.utcluj.ro (conf. dr. Paulina Mitrea, pentru studentii Universitatii Tehnice). \n" +
                "\n" +
                "CALENDAR DESFASURARE:\n" +
                "\n" +
                "9 iunie 2017- Data limita de predare a articolelor si de inscriere la conferinta\n" +
                "16 iunie 2017- Data la care se va anunta lista articolelor acceptate\n" +
                "24 iunie 2017- Data limita de predare a articolelor in forma finala\n" +
                "26 iunie 2017- Sustinerea publica a articolelor\n" +
                "\n" +
                "\n" +
                "PROGRAMUL CONFERINTEI\n" +
                "\n" +
                "Persoane de contact:\n" +
                "\n" +
                "Lect. Dr. Adrian Sergiu DARABANT, Universitatea Babes-Bolyai (dadi@cs.ubbcluj.ro)\n" +
                "Conf. Dr. Paulina Mitrea, Universitatea Tehnica (paulina.mitrea@cs.utcluj.ro) \n";
        String a4 = "Data: 26 iunie 2017, orele 16, Aula Magna, UBB\n" +
                "\n" +
                "Universitatea Babeş-Bolyai din Cluj-Napoca, în parteneriat cu Spherik Accelerator, vă invită la un eveniment dialog despre drumul de la stadiul de idee sau rezultat al cercetării către a crea un produs şi a deveni antreprenor şi despre oportunităţile oferite de un accelerator antreprenorilor care doresc să îşi dezvolte într-un timp scurt o afacere în zona Tech.\n" +
                "\n" +
                "Invitaţia se adresează tuturor cadrelor didactice/cercetătorilor şi studenţilor UBB interesaţi.\n" +
                "\n" +
                "Agenda\n" +
                "\n" +
                "Cuvânt de deschidere: Prof. univ. dr. Daniel David, Prorectorul UBB pentru cercetare, competitivitate-excelenţă şi publicaţii ştiinţifice.\n" +
                "Inovarea la UBB – Gabriela Crişan, Şeful Oficiului de Management şi Transfer Tehnologic şi Cognitiv din UBB (OMTTC-UBB).\n" +
                "Spherik şi oportunităţile oferite de un accelerator antreprenorilor care doresc să işi dezvolte o afacere în zona Tech – Roxana Rugină, coordonator Spherik Accelerator.\n" +
                "Cum să gândeşti ca antreprenor – Cezar Grigore, mentor Spherik Accelerator, YCombinator alumnus, entrepreneur.\n" +
                "Discuţii – Chestionar.\n" +
                "Context\n" +
                "\n" +
                "UBB valorizează toate cele trei componente ale cunoaşterii: (1) cercetarea (generarea de cunoaştere); (2) predarea/învăţarea (diseminarea cunoaşterii) şi (3) serviciile către mediul socio-economic/comunitate (utilizarea cunoaşterii). Într-un model humboldtian, cercetarea fundamentează însă toate componentele academice ale unei universităţi. Astfel, predarea/învăţarea nu diseminează doar cunoaştere – după modelul învăţământului preuniversitar -, ci diseminează cunoașterea împreună cu modalitatea ei de generare (învăţare prin cercetare; predare/învăţare activă) echipând astfel studenții nu doar cu cunoştinţe, ci şi cu modalităţi de a genera ei înşişi noi cunoştinţe. Serviciile către mediul socio-economic/societate nu sunt doar o replică a celor oferite de diverse companii de pe piaţă, ci sunt înalt inovative (bazate pe transfer de cunoaştere) şi/sau cu un standard de calitate maximal.\n" +
                "\n" +
                "În ceea ce priveşte relaţia cu mediul socio-economic/comunitate, UBB este membru fondator al acceleratorului Spherik, urmărind încurajarea cadrelor didactice/de cercetare şi studenţii UBB să-şi transfere expertiza academică şi ideile inovative în servicii către mediul socio-economic-comunitate, prin dezvoltarea de afaceri (ex. prin Start-upuri, Spin-offuri, etc.).\n" +
                "\n" +
                "Prof. univ. dr. Daniel David, Prorectorul UBB pentru cercetare, competitivitate-excelenţă şi publicaţii ştiinţifice";
        String a5 = "Repartizarea locurilor în tabere pentru mare/munte se va face joi, 22.06.2017, de la ora 09:00, în sala 7/I din Clădirea Centrală. Sunt eligibili studenţii aflați pe prima listă de repartizare a locurilor. Fiecare student trebuie să prezinte cartea de identitate (original şi copie) și carnetul de student vizat la zi (original şi copie). În caz de forță majoră un student poate fi reprezentat de o altă persoană doar prin împuternicire.";

        addArticle(articleDao, "A 3-a ediţie a Graduation Day", "http://www.cs.ubbcluj.ro/wp-content/uploads/Graduation-Day-2015-01.jpg", a1);
        addArticle(articleDao, "Campionatul European de Securitate Cibernetică, ediţia 2017", "http://www.cs.ubbcluj.ro/wp-content/uploads/ECSC-2017-300x300.jpg", a2);
        addArticle(articleDao, "Programul de desfăşurare al Sesiunii de Comunicări Ştiinţifice ale Studenţilor – Informatică, ediţia 2017", "http://www.cs.ubbcluj.ro/wp-content/uploads/SCSS-2015-150x150.jpg", a3);
        addArticle(articleDao, "Startup your idea! From knowledge to business: how to build products from research", "http://www.cs.ubbcluj.ro/wp-content/uploads/Startup-your-Idea-prezentare-UBB-2017.jpg", a4);
        addArticle(articleDao, "Repartizarea locurilor în taberele studențești 2017", "http://www.cs.ubbcluj.ro/wp-content/uploads/tabara-vara-2013-150x150.jpg", a5);
    }

    public void addArticle(ArticleDao scheduleDao, String title, String image_location, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setImage_location(image_location);
        article.setContent(content);
        scheduleDao.insert(article);
    }
}
