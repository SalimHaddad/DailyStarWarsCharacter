package com.salimdustries.dailystarwarscharacter.models;

/**
 * Created by Salim on 3/17/2018.
 */
import android.support.v7.widget.RecyclerView ;
import android.view.LayoutInflater;
import android.view.View ;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salimdustries.dailystarwarscharacter.R;

import java.util.ArrayList;
import java.util.List ;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Films> films = new ArrayList<Films>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView film_name;

        public MyViewHolder(View view) {
            super(view);
            film_name = (TextView) view.findViewById(R.id.film_title);
        }
    }

    public Adapter(List<Films> films) {
        this.films = films;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Films f = films.get(position);
        holder.film_name.setText(f.getTitle());
    }


    public int getItemCount()
    {
        return films.size() ;
    }
    



}
