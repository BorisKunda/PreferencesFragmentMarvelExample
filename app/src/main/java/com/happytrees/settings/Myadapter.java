package com.happytrees.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Boris on 3/2/2018.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    ArrayList<Superhumans> superhumans;
    Context context;


    //constructor
    public Myadapter(ArrayList<Superhumans> superhumans, Context context) {
        this.superhumans = superhumans;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // generate view and viewHolder
        View v = LayoutInflater.from(context).inflate(R.layout.single_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //bind data to view holder
        Superhumans current = superhumans.get(position);
        holder.bindDataFromArrayToView(current);
    }

    @Override
    public int getItemCount() {
        return  superhumans.size();
    }

    //Inner class
    public class MyViewHolder extends RecyclerView.ViewHolder {

        View myView;


        //override default constructor
        public MyViewHolder(View itemView) {
            super(itemView);
            myView= itemView;
        }

        // create public  method that binds the data
        public void bindDataFromArrayToView(final Superhumans mySuper) {

            TextView textView= myView.findViewById(R.id.heroTV);
            textView.setText(mySuper.name);

            ImageView imageView= (ImageView) myView.findViewById(R.id.marvelIV);
            imageView.setImageResource(mySuper.picId);

            CheckBox myCheckBox= (CheckBox) itemView.findViewById(R.id.heroCB);

            //Current settings taken from  SHARED PREFERENCES
            SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(context);
            boolean showCB= preferences.getBoolean("showIfHero", true);

            myCheckBox.setChecked(mySuper.isHero);

            if (showCB) {//means if value related to this specific checkbox is true(true if this character is hero and not villain)
            myCheckBox.setVisibility(View.VISIBLE);//makes checkbox checked
            }else{
            myCheckBox.setVisibility(View.INVISIBLE);//makes checkbox checked
            }


        }
    }
}
