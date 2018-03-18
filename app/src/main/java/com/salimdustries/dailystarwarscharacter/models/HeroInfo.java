package com.salimdustries.dailystarwarscharacter.models ;

import java.io.Serializable;



        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class HeroInfo implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("birth_year")
    private String birthYear;

    @SerializedName("films")
    private List <Films> films ;


    public String getName() {
        return name;
    }


    public String getBirthYear() {
        return birthYear;
    }

    public List getFilms(){ return films;}


}
