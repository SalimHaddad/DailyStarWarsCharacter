package com.salimdustries.dailystarwarscharacter.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Salim on 3/17/2018.
 */

public class Films {

    @SerializedName("title")
    private String title ;



    public Films (String title)
    {
        this.title = title ;
    }

    public String getTitle()
    {
        return title ;
    }
}
