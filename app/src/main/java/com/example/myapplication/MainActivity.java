package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<Model> list= new ArrayList<>();
        list.add(new Model(Model.TEXT_TYPE,"Hello. This is the Text-only View Type. Nice to meet you",0));
        list.add(new Model(Model.IMAGE_TYPE,"Hi. I display a cool image too besides the omnipresent TextView.",R.drawable.wtc));
        list.add(new Model(Model.AUDIO_TYPE,"Hey. Pressing the FAB button will playback an audio file on loop.",R.raw.sound));
        list.add(new Model(Model.IMAGE_TYPE,"Hi again. Another cool image here. Which one is better?",R.drawable.snow));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

    }

}
