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

    public interface OnItemClickListener {
        void onReadMoreClick(Incident incident);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incident, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Incident incident = incidentList.get(position);
        holder.titleTextView.setText(incident.getTitle());
        holder.descriptionTextView.setText(incident.getDescription());
        holder.textViewDate.setText(incident.getDate());
        holder.smallDescriptionTextView.setText(incident.getSmallDescription());
    }

    @Override
    public int getItemCount() {
        return incidentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView smallDescriptionTextView;

        TextView textViewDate;
        Button readMoreButton;

        public ViewHolder(View itemView)
        {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            smallDescriptionTextView = itemView.findViewById(R.id.textViewSmallDescription);
            readMoreButton = itemView.findViewById(R.id.readMoreButton);
            readMoreButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (smallDescriptionTextView.getVisibility() == View.GONE) {
                        smallDescriptionTextView.setVisibility(View.VISIBLE);
                        readMoreButton.setText("Read Less");
                    } else {
                        smallDescriptionTextView.setVisibility(View.GONE);
                        readMoreButton.setText("Read More");
                    }
                }
            });
 }
}
}