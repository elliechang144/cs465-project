package com.example.illinialertapp;

import androidx.fragment.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;

public class MapFilterFragment extends DialogFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map_filter, container, false);
//        RangeSlider rangeSlider = view.findViewById(R.id.rangeSlider);
//        TextView selectedNumberTextView = view.findViewById(R.id.selectedRange);
//
//        rangeSlider.setValueFrom(0);
//        rangeSlider.setValueTo(100);
//
//        rangeSlider.addOnChangeListener((slider, value, fromUser) -> {
//            selectedNumberTextView.setText("Selected Range: " + (int) value);
//        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}