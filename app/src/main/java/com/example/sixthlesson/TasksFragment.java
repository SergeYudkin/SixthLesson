package com.example.sixthlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TasksFragment extends Fragment {

    public static TasksFragment newInstance(){
        return new TasksFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tasks_fragment,container,false);
        return view;
    }
}
