package com.example.sixthlesson;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import static com.example.sixthlesson.R.array.date_arr;

public class ListFragment extends Fragment {

    Description currentDescription;
    boolean isLandScape;


    public static ListFragment newInstance(){
        return new ListFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container,false);
        LinearLayout linearLayout = (LinearLayout) view;
        String[] tasks = getResources().getStringArray(R.array.tasks_arr);


        for (int i = 0; i < tasks.length; i++ ){
            String name = tasks[i];
            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(50);
            linearLayout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentDescription = new Description(finalI,
                            (getResources().getStringArray(R.array.description_arr)[finalI]));
                    isLandScape = getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE;
                    showTasks();
                }

                private void showTasks() {
                    if (isLandScape){
                        showTasksLand();
                    }else {
                        requireActivity()
                                .getSupportFragmentManager()
                                .beginTransaction().replace(R.id.listFrag,TasksFragment.newInstance(currentDescription))
                                .addToBackStack("")
                                .commit();
                    }
                }

                private void showTasksLand() {
                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction().replace(R.id.tasksFrag,TasksFragment.newInstance(currentDescription))

                            .commit();
                }
            });
        }


        return view;
    }
}
