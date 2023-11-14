package com.example.illinialertapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataFragment extends Fragment {

    private RecyclerView recyclerView;
    private IncidentsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manager, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Get the list of hardcoded incidents
        List<Incident> incidents = DataManager.getHardcodedIncidents();

        // Initialize the adapter with the incidents list
        adapter = new IncidentsAdapter(incidents);

        // Set the click listener for the adapter
        adapter.setOnItemClickListener(new IncidentsAdapter.OnItemClickListener() {
            @Override
            public void onReadMoreClick(Incident incident) {
                // Handle the "Read More" button click
                // For example, display a Toast or open a new activity with incident details
                Toast.makeText(getActivity(), "Read More about: " + incident.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        // Set the adapter on the RecyclerView
        recyclerView.setAdapter(adapter);

        return view;
    }
}
