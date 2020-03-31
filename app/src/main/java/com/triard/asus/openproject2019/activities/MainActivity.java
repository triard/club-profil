package com.triard.asus.openproject2019.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.triard.asus.openproject2019.model.Model;
import com.triard.asus.openproject2019.adapter.MyAdapter;
import com.triard.asus.openproject2019.R;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements MyAdapter.Onclick {
    public static final String EXTRA_URL = "imageUrl";

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        preferences = this.getSharedPreferences ( "MY_DATA", MODE_PRIVATE );

        recyclerView = findViewById(R.id.recycler_view);

        getPlayers ();
    }

//    add models to arraylist
    private void getPlayers(){
        ArrayList<Model> models = new ArrayList<>();
        Model p = new Model("Manchester United", "Liga Utama Inggris","Ole Gunnar Solskjaer","Old Trafford","Manchester United Football Club adalah sebuah klub sepak bola profesional Inggris yang berbasis di Old Trafford, Manchester Raya, yang bermain di Liga Inggris. Didirikan sebagai Newton Heath LYR Football Club pada tahun 1878, klub ini berganti nama menjadi Manchester United pada 1902 dan pindah ke Old Trafford pada tahun 1910.", "https://upload.wikimedia.org/wikipedia/hif/f/ff/Manchester_United_FC_crest.png");
        models.add(p);
        p = new Model("FC Barcelona","La Liga Spanyol","Quique Setién","Camp Nou","Fútbol Club Barcelona, juga dikenal sebagai Barcelona atau Barça, adalah klub sepak bola profesional yang berbasis di Barcelona, Catalunya, Spanyol.\n" +
                "\n" +
                "Didirikan pada tahun 1899 oleh sekelompok pemain Swiss, Inggris dan Catalan yang dipimpin oleh Joan Gamper, klub telah menjadi simbol budaya Catalan dan Catalanisme, yang mempunyai motto \"Més que un club\" (Lebih dari sebuah klub). Tidak seperti banyak klub sepak bola lainnya, para pendukung memiliki dan mengoperasikan Barcelona. Ia adalah klub sepak bola kedua terkaya di dunia dalam hal pendapatan, dengan omset tahunan sebesar €560,8 juta dan kedua yang paling berharga, senilai $3,56 miliar.Lagu kebangsaan resmi Barcelona adalah \"Cant del Barça\", yang ditulis oleh Jaume Picas dan Josep Maria Espinas.","https://upload.wikimedia.org/wikipedia/id/thumb/4/47/FC_Barcelona_%28crest%29.svg/225px-FC_Barcelona_%28crest%29.svg.png");
        models.add(p);

        p = new Model("FC Bayern München","Bundesliga","Hans-Dieter Flick","Allianz Arena","FC Bayern didirikan pada tahun 1900 oleh sebelas pemain sepak bola yang dipimpin oleh Franz John. Meskipun Bayern memenangkan kejuaraan nasional pertamanya pada tahun 1932, klub tersebut tidak dipilih untuk Bundesliga pada awal tahun 1963. Klub memiliki periode yang sukses terbesar di tengah tahun 1970-an, di bawah kapten dari Franz Beckenbauer, memenangkan Piala Eropa tiga kali berturut-turut (1974-1976). Secara keseluruhan, Bayern telah mencapai sepuluh final Piala Eropa/Liga Champions, yang terakhir memenangkan gelar kelima mereka pada tahun 2013 sebagai bagian dari treble benua. Bayern juga telah memenangkan satu Piala UEFA, satu Piala Winners UEFA, satu Piala Super UEFA, dua Piala Interkontinental dan satu Piala Dunia Antarklub FIFA, membuatnya menjadi salah satu klub Eropa yang paling sukses di dunia.","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Logo_FC_Bayern_M%C3%BCnchen_%282002%E2%80%932017%29.svg/220px-Logo_FC_Bayern_M%C3%BCnchen_%282002%E2%80%932017%29.svg.png");
        models.add(p);
        p = new Model("Juventus FC","Serie A","Maurizio Sarri","Stadion Allianz","Juventus Football Club S.p.A. (BIT: JUVE) (dari bahasa Latin: iuventus: masa muda [juˈvɛntus]), biasa disebut sebagai Juventus dan populer dengan nama Juve (pengucapan [ˈjuːve]), adalah klub sepak bola profesional asal Italia yang berbasis di Turin, Piemonte. Klub ini didirikan pada tahun 1897 dengan nama Sport Club Juventus oleh sekelompok pelajar muda di kota Turin, yang dipimpin oleh Eugenio Canfari dan saudaranya Enrico.Mereka mengenakan kaos berwarna hitam putih sebagai seragam kandang sejak tahun 1903, dan menggunakan beberapa stadion berbeda di sekitar kota Turin untuk memainkan partai kandang. Juventus adalah klub tertua kedua di Italia, setelah Genoa yang mendirikan klub sepak bola pada tahun 1893. Mereka tampil untuk pertama kalinya di liga divisi teratas Italia sejak tahun 1900, setelah berganti nama menjadi Football Club Juventus. Mereka terus berada di kompetisi tertinggi tersebut (yang menggunakan nama Serie A sejak tahun 1929), kecuali pada musim 2006–07.","https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Juventus_FC_2017_logo.svg/100px-Juventus_FC_2017_logo.svg.png");
        models.add(p);
        p = new Model("Olympique Lyonnais","Ligue 1","Sylvinho","Stadion Groupama","Olympique Lyonnais adalah sebuah klub sepak bola Prancis yang bermarkas di Lyon, Prancis. Klub ini bermain di Ligue 1. Didirikan pada tahun 1899 di kota Chauses yang masuk kedalam wilayah Lyon, departemen Rhone. Olympique Lyonnais saat ini berkedudukan di kota Lyon, Prancis selatan. Olympique Lyonnais merupakan salah satu klub tertua dan tersukses di Prancis.","https://upload.wikimedia.org/wikipedia/id/thumb/c/c6/Olympique_Lyonnais.svg/170px-Olympique_Lyonnais.svg.png");
        models.add(p);
        p = new Model("Liverpool FC","Liga Utama Inggris","Jürgen Klopp","Anfield","Liverpool Football Club /ˈlɪvərpuːl/ (dikenal pula sebagai Liverpool atau The Reds) adalah sebuah klub sepak bola asal Inggris yang berbasis di Kota Liverpool. Saat ini Liverpool adalah peserta Liga Utama Inggris. Liverpool juga merupakan juara bertahan Liga Champions UEFA musim 2018-2019\n" +
                "\n" +
                "Liverpool telah memenangkan 6 trofi Liga Champions UEFA (dulu Piala Champions) dan merupakan klub dengan pemegang gelar juara Liga Champions UEFA terbanyak di Inggris dan ketiga di Eropa setelah Real Madrid dan AC Milan. Selain itu Liverpool juga pemegang 3 gelar juara Liga Eropa UEFA dan 4 gelar Piala Super UEFA.\n" +
                "\n" +
                "Di kompetisi domestik, Liverpool adalah klub dengan 18 gelar juara Liga Inggris, 7 Piala FA, serta 7 kali juara Piala Liga.\n","https://upload.wikimedia.org/wikipedia/id/thumb/0/0c/Liverpool_FC.svg/180px-Liverpool_FC.svg.png");
        models.add(p);
        p = new Model("Real Madrid FC","Laliga"," Zinedine Zidane","Santiago Bernabéu","Real Madrid Club de Fútbol (pengucapan bahasa Spanyol: [reˈal maˈðɾið ˈkluβ ðe ˈfutβol]; Royal Madrid Football Club), umumnya dikenal sebagai Real Madrid, adalah klub sepak bola profesional yang berbasis di Madrid, Spanyol.\n" +
                "\n" +
                "Didirikan pada tahun 1902 sebagai Madrid Football Club, secara tradisional mengenakan kostum kandang putih. Kata Real (\"dari kerajaan\") Spanyol dan dianugerahkan ke klub oleh Raja Alfonso XIII pada tahun 1920 bersama-sama dengan mahkota kerajaan di lambang klub. Klub ini telah memainkan pertandingan kandang di Stadion Santiago Bernabéu dengan kapasitas 85.454 di pusat kota Madrid sejak tahun 1947.","https://upload.wikimedia.org/wikipedia/id/thumb/8/8b/Real_Madrid_Club_de_F%C3%BAtbol.png/175px-Real_Madrid_Club_de_F%C3%BAtbol.png");
        models.add(p);
        p = new Model("Borussia Dortmund","Bundesliga","Lucien Favre","Signal Iduna Park","Ballspielverein Borussia 09 e.V. Dortmund umumnya dikenal sebagai Borussia Dortmund [boˈʁʊsi̯aː ˈdɔɐ̯tmʊnt], atau BVB, adalah klub olahraga Jerman yang berbasis di Dortmund, Rhine-Westphalia Utara. Didirikan pada tahun 1909 oleh delapan belas pemain sepak bola dari Dortmund, tim sepak bola bagian dari sebuah klub olahraga berbasis keanggotaan besar dengan lebih dari 145.000 anggota, membuat BVB klub olahraga dengan keanggotaan terbesar kedua di Jerman. Dortmund bermain di Bundesliga, tingkat teratas sistem liga sepakbola Jerman.","https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Borussia_Dortmund_logo.svg/180px-Borussia_Dortmund_logo.svg.png");
        models.add(p);
        p = new Model("Sport Lisboa e Benfica","Portuguese Sagres Liga","Jorge Jesus","Stadion da Luz","SL Benfica atau biasa dikenal dengan nama Benfica adalah klub sepak bola Portugal. klub yang didirikan pada tanggal 28 Februari 1904 ini memainkan partai kandangnya di kota Lisbon. Benfica bermarkas di stadion da Luz ini adalah salah satu klub ternama di Portugal dengan segudang prestasi yang telah ditorehkan.","https://upload.wikimedia.org/wikipedia/en/thumb/a/a2/SL_Benfica_logo.svg/190px-SL_Benfica_logo.svg.png");
        models.add(p);
        p = new Model("AC Milan","Seria A","Stefano Pioli","San Siro","Associazione Calcio Milan (pengucapan bahasa Italia: [assotʃatˈtsjoːne ˈkaltʃo ˈmiːlan]), sering disebut sebagai A.C. Milan atau hanya Milan, adalah sebuah klub sepak bola Italia yang berbasis di Milan, Lombardia, yang bermain di Serie A. Mereka bermain dengan seragam bergaris merah-hitam dan celana putih (kadang-kadang hitam), sehingga dijuluki rossoneri (\"merah-hitam\"). Milan adalah tim tersukses kedua dalam sejarah persepak bolaan Italia, menjuarai Serie A 18 kali dan Piala Italia 5 kali.","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Logo_of_AC_Milan.svg/120px-Logo_of_AC_Milan.svg.png");
        models.add(p);
        p = new Model("Arsenal FC","Liga Utama Inggris","Mikel Arteta","Emirates Stadium","Arsenal Football Club (dikenal pula sebagai Arsenal atau The Gunners) adalah klub sepak bola profesional Inggris yang berbasis di daerah Holloway, London. didirikan pada 1886 dengan nama Dial Square. Klub ini bermain di Liga Utama Inggris yang termasuk salah satu klub tersukses di sepak bola Inggris, yang telah memenangkan 13 gelar kasta utama Liga Inggris (10 pada era Divisi Pertama dan 3 pada era Premier League) dan 13 gelar di Piala FA (Gelar paling banyak). Arsenal memegang rekor untuk periode terpanjang berada di kasta puncak Liga Inggris tanpa pernah terdegradasi sejak musim 1919 dan menjadi tim pada peringkat pertama dalam klasemen Liga Inggris sepanjang abad ke-20. Arsenal menjadi tim kedua di Inggris yang menyelesaikan semusim liga tanpa kalah (musim 2003–04) dan tim pertama yang melakukannya pada era di mana satu musim berlangsung 38 pertandingan.","https://upload.wikimedia.org/wikipedia/id/thumb/5/53/Arsenal_FC.svg/170px-Arsenal_FC.svg.png");
        models.add(p);
        p = new Model("Internazionale Milano","Seri A","Antonio Conte","San Siro","Football Club Internazionale Milano,[9] atau yang dikenal dengan nama Internazionale (/ˌinternattsjoˈnaːle/) ataupun juga Inter, dan bahasa sehari-hari dikenal sebagai Inter Milan di luar Italia,[10] adalah sebuah klub sepak bola profesional asal Italia yang saat ini bermain di Serie A Liga Italia. Inter Milan mempunyai julukan sebagai il Nerazzurri (si biru hitam), il Biscone (si ular besar), dan juga La Beneamata (yang tersayang). Klub bermain di Serie A (divisi pertama) sejak tahun 1908, dan pendukung Internazionale disebut Interisti.","https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/FC_Internazionale_Milano_2014.svg/200px-FC_Internazionale_Milano_2014.svg.png");
        models.add(p);
        p = new Model("Ajax Amsterdam","Eredivisie","Erik Ten Hag","Johan Cruyff Arena","Amsterdamsche Football Club Ajax (pengucapan Belanda: [ˈaːjɑks]) (Euronext: AJAX; juga dikenal dengan nama Ajax Amsterdam, AFC Ajax, atau hanya Ajax (dibaca A-yaks)) adalah sebuah klub sepak bola dari Amsterdam, Belanda. Klub ini adalah salah satu klub terkuat di Belanda dan juga di Eropa. Secara historis, Ajax (dinamai sesuai pahlawan Yunani legendaris) telah menjadi klub paling sukses di Belanda, dengan 34 gelar Eredivisie dan 19 Piala KNVB. Ajax terus bermain di Eredivisie, sejak awal liga pada tahun 1956 dan, bersama dengan Feyenoord dan PSV Eindhoven, itu adalah salah satu klub \"tiga besar\" yang mendominasi kompetisi itu.","https://upload.wikimedia.org/wikipedia/id/thumb/b/b7/AFC_Ajax.svg/180px-AFC_Ajax.svg.png");
        models.add(p);


        String mShortSetting = preferences.getString ( "Sort", "Ascending" );
        if(mShortSetting.equals ( "Ascending" )){
            Collections.sort ( models, Model.BY_TITTLE_ASCENDING );
        }else if(mShortSetting.equals ( "Descending" )){
            Collections.sort ( models, Model.BY_TITTLE_DESCENDING );
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        myAdapter = new MyAdapter(this, models, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void clickItem(Model model) {
        Intent intent = new Intent(MainActivity.this, activityDetail.class);
        intent.putExtra("nama", model.getNama());
        intent.putExtra("asal", model.getAsal());
        intent.putExtra("coach", model.getCoach());
        intent.putExtra("stadion", model.getStadion());
        intent.putExtra("desc", model.getDesc());
        intent.putExtra(EXTRA_URL, model.getImg());
        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String s) {
                myAdapter.getFilter().filter(s);
                if(fileList()!=null){
                    Toast.makeText(MainActivity.this,"No Records Found!",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"Records Found!",Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_sort){
            Toast.makeText(this, "Sort", Toast.LENGTH_SHORT).show();
            ShowSortDialog();
            return true;
        }else if(id==R.id.miProfile){
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void ShowSortDialog() {
        String [] option = {"Ascending","Descending"};
        AlertDialog.Builder builder = new AlertDialog.Builder ( this );
        builder.setTitle ("Sort by");
        builder.setIcon ( R.drawable.ic_action_sort );
        builder.setItems ( option, new DialogInterface.OnClickListener ( ) {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    SharedPreferences.Editor editor = preferences.edit ();
                    editor.putString ( "Sort", "Ascending" );
                    editor.apply ();
                    getPlayers ();
                }
                if(which == 1){
                    SharedPreferences.Editor editor = preferences.edit ();
                    editor.putString ( "Sort", "Descending" );
                    editor.apply ();
                    getPlayers ();
                }
            }
        } );
        builder.create ().show ();
    }
    //    action bar

}
