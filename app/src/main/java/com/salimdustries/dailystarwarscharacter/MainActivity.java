package com.salimdustries.dailystarwarscharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.*;
import com.android.volley.*;
import com.google.gson.Gson;

import es.dmoral.toasty.Toasty;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

import com.salimdustries.dailystarwarscharacter.api.character.CharacterApiManager;
import com.salimdustries.dailystarwarscharacter.api.character.FilmApiManager;
import com.salimdustries.dailystarwarscharacter.models.Adapter;
import com.salimdustries.dailystarwarscharacter.models.Films;
import com.salimdustries.dailystarwarscharacter.models.HeroInfo;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.* ;


public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";


    private Gson gson = new Gson();
    CharacterApiManager characterApiManager = new CharacterApiManager();
    FilmApiManager fam = new FilmApiManager();
    private TextView hero;
    private TextView year;
    private ImageView hero_pic;
    Calendar cal = Calendar.getInstance();
    private int day = cal.get(Calendar.DAY_OF_MONTH);
    private RecyclerView recyclerView;
    private Adapter mAdapter;
    // private RecyclerView recyclerView ;
    //  private MyAdapter adapter ;
    //  private RecyclerView.LayoutManager layoutManager ;
    //  private List<ListItem> list = new ArrayList<ListItem>();
    private RequestQueue rq;
    private String url = "https://swapi.co/api/people/" + day;
    private String sthero;
    private String stplanet;
    private String path = "R.drawable.img13";
    private List<HeroInfo> list;
    private List<Films> films = new ArrayList<Films>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year = (TextView) findViewById(R.id.birth_year);
        hero = (TextView) findViewById(R.id.hero_name);

//        recyclerView = (RecyclerView) findViewById(R.id.films_list);
//        mAdapter = new Adapter(films);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();

//for (int i=1; i<8;i++) //episode 8 isn't added in the api
//{
//
//    fam.getFilmAtEpisode(i).enqueue(new retrofit2.Callback<Films>() {
//
//        @Override
//        public void onResponse(retrofit2.Call<Films> call, retrofit2.Response<Films> response) {
//            if(response.isSuccessful()){
//                Films film = response.body();
//                films.add(film);
//
//
//            }
//        }
//
//        @Override
//        public void onFailure(retrofit2.Call<Films> call, Throwable t) {
//
//        }
//
//
//    });
//
//
//
//}
        characterApiManager.getHeroAtDay(day).enqueue(new retrofit2.Callback<HeroInfo>() {
            @Override
            public void onResponse(retrofit2.Call<HeroInfo> call, retrofit2.Response<HeroInfo> response) {
                if (response.isSuccessful()) {
                    HeroInfo heroInfo = response.body();
                    hero.setText(heroInfo.getName());
                    year.setText(heroInfo.getBirthYear());

                }
            }

            @Override
            public void onFailure(retrofit2.Call<HeroInfo> call, Throwable t) {

            }
        });

//        rq = Volley.newRequestQueue(this);

//
//
//

        hero_pic = (ImageView) findViewById(R.id.hero_icon);
//        Picasso.with(this).load("R.drawable.img"+day).into(hero_pic);
        int id = getResources().getIdentifier("img" + day, "drawable", getPackageName());
        if (id != 0) {
            hero_pic.setImageResource(id);
//         Picasso.with(this).load(id);
       }
//
//        Toasty.info(this, "Happy "+sthero+" day!", Toast.LENGTH_LONG, true).show();
//
//        if ( sthero != null) {
//            Log.d("evazan", sthero + " " + stplanet + " " + day);
//        }
//        sendHeroJsonRequest();
//
//    }
//
//    public void sendHeroJsonRequest(){
//        JsonObjectRequest jor = new JsonObjectRequest( com.android.volley.Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    sthero = response.getString("name");
//                    stplanet = response.getString("birth_year");
//
//                    hero.setText(sthero);
//                    year.setText(stplanet);
//                }
//
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new com.android.volley.Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//
//            }
//        }) ;
//
//
//        rq.add(jor);

        }
    }

