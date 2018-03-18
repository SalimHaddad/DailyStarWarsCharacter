package com.salimdustries.dailystarwarscharacter.api.character;

import com.salimdustries.dailystarwarscharacter.models.Films;
import com.salimdustries.dailystarwarscharacter.models.HeroInfo;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Salim on 3/18/2018.
 */

public class FilmApiManager {


    private OkHttpClient okHttpClient ;

    private FilmApi filmApi ;



    private final String STAR_WARS = "https://swapi.co/api/";


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(STAR_WARS)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Call<Films> getFilmAtEpisode(int episode){
        FilmApi api = retrofit.create(FilmApi.class);
        return api.getFilmAtEpisode(episode);
    }




}
