package com.salimdustries.dailystarwarscharacter.api.character;

/**
 * Created by Salim on 3/14/2018.
 */
import com.salimdustries.dailystarwarscharacter.models.HeroInfo ;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterApi {

    @GET("people/{day}")
    Call<HeroInfo> getHeroAtDay(@Path("day") int day);

}
