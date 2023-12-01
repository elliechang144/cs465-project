package com.example.illinialertapp;

import androidx.fragment.app.DialogFragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.slider.RangeSlider;

public class MapFilterFragment extends DialogFragment {

    private MapFragment mapFragment;

    public void setMapFragment(MapFragment fragment) {
        this.mapFragment = fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map_filter, container, false);
        RangeSlider rangeSlider = view.findViewById(R.id.rangeSlider);
        TextView selectedNumberTextView = view.findViewById(R.id.selectedRange);

        rangeSlider.setValueFrom(0);
        rangeSlider.setValueTo(100);

        TextView startLocationTextView = view.findViewById(R.id.start_location);
        String chosenLoc = mapFragment.getChosenLocation();
        if (chosenLoc != null) {
            startLocationTextView.setText("Selected Location: " + chosenLoc);
        }

        rangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            int selectedRange = (int) value;
            selectedNumberTextView.setText("Selected Range: " + selectedRange);
            if (mapFragment != null) {
                mapFragment.filterByRange(selectedRange);
            }
        });



        Button btn_Close = view.findViewById(R.id.confirmButton);
        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}