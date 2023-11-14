package com.example.illinialertapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }
}
//
//package com.example.illinialertapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptor;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import androidx.core.content.ContextCompat;
//import androidx.fragment.app.FragmentActivity;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptor;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link MapFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class MapFragment extends Fragment {
//
//    GoogleMap googleMap;
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public MapFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MapFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static MapFragment newInstance(String param1, String param2) {
//        MapFragment fragment = new MapFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_map, container, false);
//
//        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(@NonNull GoogleMap googleMap) {
//                LatLng defaultLoc = new LatLng(40.785091, -73.968285);
//                googleMap.addMarker(new MarkerOptions()
//                        .position(defaultLoc)
//                        .title("Default Location")
//                        .icon(BitmapFromVector(requireContext(),
//                                R.drawable.baseline_local_fire_department_24)));
//                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(defaultLoc, 15f));
//            }
//        });
//        return view;
//    }
//
//    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
//        // below line is use to generate a drawable.
//        Drawable vectorDrawable = ContextCompat.getDrawable(
//                context, vectorResId);
//
//        // below line is use to set bounds to our vector
//        // drawable.
//        vectorDrawable.setBounds(
//                0, 0, vectorDrawable.getIntrinsicWidth(),
//                vectorDrawable.getIntrinsicHeight());
//
//        // below line is use to create a bitmap for our
//        // drawable which we have added.
//        Bitmap bitmap = Bitmap.createBitmap(
//                vectorDrawable.getIntrinsicWidth(),
//                vectorDrawable.getIntrinsicHeight(),
//                Bitmap.Config.ARGB_8888);
//
//        // below line is use to add bitmap in our canvas.
//        Canvas canvas = new Canvas(bitmap);
//
//        // below line is use to draw our
//        // vector drawable in canvas.
//        vectorDrawable.draw(canvas);
//
//        // after generating our bitmap we are returning our
//        // bitmap.
//        return BitmapDescriptorFactory.fromBitmap(bitmap);
//    }
//}