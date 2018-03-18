package com.salimdustries.dailystarwarscharacter.api.character;

/**
 * Created by Salim on 3/14/2018.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salimdustries.dailystarwarscharacter.models.HeroInfo;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharacterApiManager {

    private OkHttpClient okHttpClient ;

    private CharacterApi characterApi ;


    private final String STAR_WARS_API = "https://swapi.co/api/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(STAR_WARS_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Call<HeroInfo> getHeroAtDay(int day){
        CharacterApi api = retrofit.create(CharacterApi.class);
        return api.getHeroAtDay(day);
    }




}
