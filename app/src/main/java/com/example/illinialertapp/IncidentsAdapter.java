package com.example.illinialertapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IncidentsAdapter extends RecyclerView.Adapter<IncidentsAdapter.ViewHolder> {

    private List<Incident> incidentList;
    private OnItemClickListener listener;

    // Constructor
    public IncidentsAdapter(List<Incident> incidentList) {
        this.incidentList = incidentList;
    }

    // Interface for click listener
    public interface OnItemClickListener {
        void onReadMoreClick(Incident incident);
    }

    // Method to set the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Incident incident = incidentList.get(position);
        holder.titleTextView.setText(incident.getTitle());
        holder.descriptionTextView.setText(incident.getDescription());
    }

    @Override
    public int getItemCount() {
        return incidentList.size();
    }

    // ViewHolder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        Button readMoreButton;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
            readMoreButton = itemView.findViewById(R.id.readMoreButton);

            // Set the click listener for the "Read More" button
            readMoreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onReadMoreClick(incidentList.get(position));
                    }
                }
            });
        }
    }
}