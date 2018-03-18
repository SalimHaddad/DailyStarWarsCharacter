package com.salimdustries.dailystarwarscharacter.api.character;

import com.salimdustries.dailystarwarscharacter.models.Films;
import com.salimdustries.dailystarwarscharacter.models.HeroInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Salim on 3/18/2018.
 */

public interface FilmApi {



    @GET("films/{episode}")
    Call<Films> getFilmAtEpisode(@Path("episode") int episode);
}
