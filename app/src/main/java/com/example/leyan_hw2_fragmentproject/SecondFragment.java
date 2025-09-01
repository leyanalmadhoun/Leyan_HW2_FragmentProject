package com.example.leyan_hw2_fragmentproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        TextView tv = v.findViewById(R.id.tvResult);

        getParentFragmentManager().setFragmentResultListener(
                "fromFirst",
                getViewLifecycleOwner(),
                (key, bundle) -> {
                    String msg = bundle.getString("msg", "");
                    tv.setText("Data received: " + msg);
                }
        );
    }
}
