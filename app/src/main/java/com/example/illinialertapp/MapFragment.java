package com.example.illinialertapp;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.Button;

import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    GoogleMap gMap;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String chosenLocation;

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap map) {
                gMap = map;
                addMarkersAndZoom(gMap);
            }

        });

        SearchView sView = view.findViewById(R.id.searchView);
        sView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = sView.getQuery().toString();

                if (location != null && !location.equals("")) {

                    if (getContext() != null && gMap != null) {
                        Geocoder geocoder = new Geocoder(getContext());

                        try {
                            List<Address> addressList = geocoder.getFromLocationName(location, 1);
                            if (addressList != null && addressList.size() > 0) {
                                Address address = addressList.get(0);
                                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                                gMap.addMarker(new MarkerOptions().position(latLng).title(location));
                                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    chosenLocation = location;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        Button filterButton = view.findViewById(R.id.filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapFilterFragment filterFragment = new MapFilterFragment();
                filterFragment.setMapFragment(MapFragment.this);
                filterFragment.show(getChildFragmentManager(), "MapFilterFragment");
            }
        });

        return view;

    }

    private void addMarkersAndZoom(GoogleMap googleMap) {
        LatLng tempStabbingLoc = new LatLng(40.110291, -88.230474);
        googleMap.addMarker(new MarkerOptions()
                .position(tempStabbingLoc)
                .title("Stabbing")
                .icon(BitmapFromVector(getContext(), R.drawable.knife_32)));

        LatLng tempShootingLoc1 = new LatLng(40.11025, -88.2354);
        googleMap.addMarker(new MarkerOptions()
                .position(tempShootingLoc1)
                .title("Shooting")
                .icon(BitmapFromVector(getContext(), R.drawable.gun_32)));

        LatLng tempShootingLoc2 = new LatLng(40.11024, -88.23706);
        googleMap.addMarker(new MarkerOptions()
                .position(tempShootingLoc2)
                .title("Shooting")
                .icon(BitmapFromVector(getContext(), R.drawable.gun_32)));

        LatLng tempFireLoc1 = new LatLng(40.10766, -88.23376);
        googleMap.addMarker(new MarkerOptions()
                .position(tempFireLoc1)
                .title("Fire")
                .icon(BitmapFromVector(getContext(), R.drawable.fire_32)));

        LatLng tempFireLoc2 = new LatLng(40.11246, -88.20746);
        googleMap.addMarker(new MarkerOptions()
                .position(tempFireLoc2)
                .title("Fire")
                .icon(BitmapFromVector(getContext(), R.drawable.fire_32)));

        LatLng tempFireLoc3 = new LatLng(40.11643, -88.23853);
        googleMap.addMarker(new MarkerOptions()
                .position(tempFireLoc3)
                .title("Fire")
                .icon(BitmapFromVector(getContext(), R.drawable.fire_32)));

        LatLng tempRobberyLoc1 = new LatLng(40.11643, -88.23212);
        googleMap.addMarker(new MarkerOptions()
                .position(tempRobberyLoc1)
                .title("Robbery")
                .icon(BitmapFromVector(getContext(), R.drawable.money_32)));

        LatLng tempRobberyLoc2 = new LatLng(40.12262, -88.23047);
        googleMap.addMarker(new MarkerOptions()
                .position(tempRobberyLoc2)
                .title("Robbery")
                .icon(BitmapFromVector(getContext(), R.drawable.money_32)));

        LatLng tempHazardLoc = new LatLng(40.1125, -88.22313);
        googleMap.addMarker(new MarkerOptions()
                .position(tempHazardLoc)
                .title("Hazard")
                .icon(BitmapFromVector(getContext(), R.drawable.hazard_32)));

        LatLng tempGasLoc = new LatLng(40.10585, -88.23243);
        googleMap.addMarker(new MarkerOptions()
                .position(tempGasLoc)
                .title("Gas Leak")
                .icon(BitmapFromVector(getContext(), R.drawable.hazard_32)));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(tempStabbingLoc);
        builder.include(tempShootingLoc1);
        builder.include(tempShootingLoc2);
        builder.include(tempFireLoc1);
        builder.include(tempFireLoc2);
        builder.include(tempFireLoc3);
        builder.include(tempRobberyLoc1);
        builder.include(tempRobberyLoc2);
        builder.include(tempHazardLoc);
        builder.include(tempGasLoc);

        LatLngBounds bounds = builder.build();
        int padding = 100;

        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
    }

    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(
                context, vectorResId);
        vectorDrawable.setBounds(
                0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(
                vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public void filterByRange(int selectedRadius) {
        double startLatitude = 40.10766;
        double startLongitude = -88.23376;
        LatLng startPos = new LatLng(startLatitude, startLongitude);
        Geocoder geocoder = new Geocoder(getContext());

        if (chosenLocation != null) {
            try {
                List<Address> addressList = geocoder.getFromLocationName(chosenLocation, 1);
                if (addressList != null && addressList.size() > 0) {
                    Address address = addressList.get(0);
                    startPos = new LatLng(address.getLatitude(), address.getLongitude());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Incident> incidents = DataManager.getHardcodedIncidents();
        List<Incident> filteredIncidents = filterAddressesByDistance(startLatitude, startLongitude, incidents, selectedRadius);
        for (Incident incident : filteredIncidents) {
            markIncident(incident, gMap);
        }

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(startPos);

        LatLngBounds bounds = builder.build();
        int padding = 500;

        gMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));

    }

    public void markIncident(Incident incident, GoogleMap googleMap) {
        LatLng incidentLatlng = new LatLng(incident.getLatitude(), incident.getLongitude());
        googleMap.addMarker(new MarkerOptions()
                .position(incidentLatlng)
                .title("Fire")
                .icon(BitmapFromVector(getContext(), R.drawable.baseline_local_fire_department_24)));
    }

    public List<Incident> filterAddressesByDistance(double startLatitude, double startLongitude, List<Incident> incidents, double radiusInMiles) {
        List<Incident> filteredIncidents = new ArrayList<>();

        for (Incident incident : incidents) {
            double endLatitude = incident.getLatitude();
            double endLongitude = incident.getLongitude();
            double distance = calculateDistance(startLatitude, startLongitude, endLatitude, endLongitude);
            if (distance <= radiusInMiles) {
                filteredIncidents.add(incident);
            }
        }

        return filteredIncidents;
    }
    public double calculateDistance(double startLat, double startLng, double endLat, double endLng) {
        final int R = 6371;

        double latDistance = Math.toRadians(endLat - startLat);
        double lngDistance = Math.toRadians(endLng - startLng);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(startLat)) * Math.cos(Math.toRadians(endLat))
                * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c * 0.621371;
    }

    public String getChosenLocation() {
        return chosenLocation;
    }

}