package com.example.leyan_hw2_fragmentproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        EditText et = v.findViewById(R.id.etMessage);
        Button btn  = v.findViewById(R.id.btnSend);

        btn.setOnClickListener(view -> {
            String txt = et.getText().toString().trim();
            if (txt.isEmpty()) {
                Toast.makeText(requireContext(), "Massage for TAB-2ً", Toast.LENGTH_SHORT).show();
                return;
            }

            Bundle result = new Bundle();
            result.putString("msg", txt);
            getParentFragmentManager().setFragmentResult("fromFirst", result);


            ViewPager2 vp = requireActivity().findViewById(R.id.viewPager);
            vp.setCurrentItem(1, true);
        });
    }
}
