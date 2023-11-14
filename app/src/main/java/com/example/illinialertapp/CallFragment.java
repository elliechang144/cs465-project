package com.example.illinialertapp;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallFragment extends Fragment {
    public CallFragment() {
        // Required empty public constructor
    }

    Button button_911;
    Button button_campus_safety;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_call, container, false);

        View view = inflater.inflate(R.layout.fragment_call, container, false);

        button_911 = view.findViewById(R.id.button_911);
        button_campus_safety = view.findViewById(R.id.button_campus_safety);

        button_911.setOnClickListener(arg -> {
            Intent phone_intent_911 = new Intent(Intent.ACTION_CALL);
            phone_intent_911.setData(Uri.parse("tel:911"));
            startActivity(phone_intent_911);
        });

        button_campus_safety.setOnClickListener(arg -> {
            Intent phone_intent_campus_safety = new Intent(Intent.ACTION_CALL);
            phone_intent_campus_safety.setData(Uri.parse("tel:2173338911"));
            startActivity(phone_intent_campus_safety);
        });
        return view;
    }
}