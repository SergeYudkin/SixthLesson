package com.example.sixthlesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

public class TasksFragment extends Fragment {

    public static String ARG_LIST = "list";
    private Description description;

    public static TasksFragment newInstance(Description description) {
        TasksFragment fragment = new TasksFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_LIST,description);
        fragment.setArguments(bundle);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            this.description = getArguments().getParcelable(ARG_LIST);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tasks_fragment,container,false);
        TextView textView = view.findViewById(R.id.textViewFragDescription);
        TextView textView1 = view.findViewById(R.id.textViewFragList);
        textView1.setText(this.description.getCont());


        return view;
    }
}
