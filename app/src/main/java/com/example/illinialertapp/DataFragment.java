package com.example.illinialertapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataFragment extends Fragment {

    private RecyclerView recyclerView;
    private IncidentsAdapter adapter;
    private List<Incident> incidents;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        incidents = DataManager.getHardcodedIncidents();
        adapter = new IncidentsAdapter(incidents);

        adapter.setOnItemClickListener(new IncidentsAdapter.OnItemClickListener()
        {
            @Override
            public void onReadMoreClick(Incident incident)
            {
                Toast.makeText(getActivity(), "Read More about: " + incident.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);

        Button btnSortAsc = view.findViewById(R.id.btnSortAsc);
        Button btnSortDesc = view.findViewById(R.id.btnSortDesc);

        btnSortAsc.setOnClickListener(v -> sortIncidentsByDate(true));
        btnSortDesc.setOnClickListener(v -> sortIncidentsByDate(false));


        Button btnDataVisualization = view.findViewById(R.id.btnDataVisualization);
        btnDataVisualization.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DataAnalysis.class);
            startActivity(intent);
        });

        return view;
    }

    private void sortIncidentsByDate(boolean ascending)
    {
        if (incidents != null)
        {
            Collections.sort(incidents, new Comparator<Incident>()
            {
                @Override
                public int compare(Incident i1, Incident i2)
                {
                    return ascending ? i1.getDate().compareTo(i2.getDate()) : i2.getDate().compareTo(i1.getDate());
                }
            });
            adapter.notifyDataSetChanged();
        }
    }
}