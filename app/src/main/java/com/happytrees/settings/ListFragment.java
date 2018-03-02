package com.happytrees.settings;


import android.app.Fragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListFragment extends Fragment {


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list,container,false);


        //set array
        ArrayList<Superhumans>superhumans = new ArrayList<>();


        //create objects and add to array
        superhumans.add(new Superhumans("captain america",R.drawable.captainamerica,true));
        superhumans.add(new Superhumans("carnage",R.drawable.carnage,false));
        superhumans.add(new Superhumans("galactus",R.drawable.galactus,false));
        superhumans.add(new Superhumans("hulk",R.drawable.hulk,true));
        superhumans.add(new Superhumans("magneto",R.drawable.magneto,false));
        superhumans.add(new Superhumans("mystique",R.drawable.mystique,false));
        superhumans.add(new Superhumans("redskull",R.drawable.redskull,false));
        superhumans.add(new Superhumans("thor",R.drawable.thor,true));
        superhumans.add(new Superhumans("venom",R.drawable.venom,false ));


        //set Recycler View
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.superhumansRV);

        //set Shared Preferences (there you save settings values )
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        //get value from SharedPrefs
        String showInList = sharedPreferences.getString("list_preference", "list");//list_preference is key(id) of preference item in preferences.xml

        if(showInList.equals("List")) {//means user chose List radio button option in ListDisplayPrefs
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));//makes recycler view list
        }
        else//means user chose "Grid"
        {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        }

        Myadapter myadapter = new Myadapter(superhumans,getActivity());

        recyclerView.setAdapter(myadapter);
        

        //add both vertical and horizontal lines
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));



        //get message from sharedPrefes and show in dialog

        String message= sharedPreferences.getString("message" ,"");//message is key(id) of preference item
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("This is a message")
                .setMessage(message)
                .setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();


        return  v ;
    }
        }
