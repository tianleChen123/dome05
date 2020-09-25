package com.example.dome05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecentFragment extends Fragment {


    private Button set;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recent, container, false);

        //  set = (Button) view.findViewById(R.id.)
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ReallyActivty reallyActivty = (ReallyActivty) getActivity();
        reallyActivty.init2();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ReallyActivty reallyActivty = (ReallyActivty) getActivity();
        reallyActivty.unregister();
    }


}
