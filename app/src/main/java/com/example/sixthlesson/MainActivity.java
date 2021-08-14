package com.example.sixthlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.listFrag,ListFragment.newInstance())
                .commit();

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.tasksFrag,TasksFragment.newInstance(new Description("")))
                    .commit();
        }
    }
}