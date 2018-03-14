package com.salimdustries.dailystarwarscharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.* ;


public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";


    private Gson gson = new Gson();

    private TextView hero ;
    private TextView year ;
    private ImageView hero_pic;
    Calendar cal = Calendar.getInstance();
    private int day = cal.get(Calendar.DAY_OF_MONTH);

   // private RecyclerView recyclerView ;
    //  private MyAdapter adapter ;
  //  private RecyclerView.LayoutManager layoutManager ;
  //  private List<ListItem> list = new ArrayList<ListItem>();
    private RequestQueue rq ;
    private String url = "https://swapi.co/api/people/"+day ;
    private String sthero ;
    private String stplanet ;
    private String path = "R.drawable.img13" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);
        hero = (TextView) findViewById(R.id.hero_name);



        year =(TextView) findViewById(R.id.birth_year);
        hero_pic = (ImageView)findViewById(R.id.hero_icon);
        Picasso.with(this).load("R.drawable.img"+day).into(hero_pic);
        int id = getResources().getIdentifier("img"+day,"drawable",getPackageName());
        if(id != 0){
            hero_pic.setImageResource(id);
//         Picasso.with(this).load(id);
        }

        Toasty.info(this, "Happy "+sthero+" day!", Toast.LENGTH_LONG, true).show();

        if ( sthero != null) {
            Log.d("evazan", sthero + " " + stplanet + " " + day);
        }
        sendHeroJsonRequest();

    }

    public void sendHeroJsonRequest(){
        JsonObjectRequest jor = new JsonObjectRequest( com.android.volley.Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    sthero = response.getString("name");
                    stplanet = response.getString("birth_year");

                    hero.setText(sthero);
                    year.setText(stplanet);
                }

                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) ;


        rq.add(jor);
    }
}
