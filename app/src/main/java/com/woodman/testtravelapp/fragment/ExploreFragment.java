package com.woodman.testtravelapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.woodman.testtravelapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnLeftPopularTours;
    private ImageButton btnRightPopularTours;
    private ImageButton btnLeftNewOffersTours;
    private ImageButton btnRightNewOffersTours;
    private ImageButton btnLeftBestDestinations;
    private ImageButton btnRightBestDestinations;


    public ExploreFragment() {
        // Required empty public constructor
    }

    public static ExploreFragment newInstance() {
        ExploreFragment exploreFragment = new ExploreFragment();
        Bundle args = new Bundle();
        exploreFragment.setArguments(args);
        return exploreFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        getActivity().setTitle(getString(R.string.fragment_title_explore));
        btnLeftPopularTours = view.findViewById(R.id.explore_fragment_image_btn_left_popular_tours);
        btnRightPopularTours = view.findViewById(R.id.explore_fragment_image_btn_right_popular_tours);
        btnLeftNewOffersTours = view.findViewById(R.id.explore_fragment_image_btn_left_new_offers_tours);
        btnRightNewOffersTours = view.findViewById(R.id.explore_fragment_image_btn_right_new_offers_tours);
        btnLeftBestDestinations = view.findViewById(R.id.explore_fragment_image_btn_left_best_destinations);
        btnRightBestDestinations = view.findViewById(R.id.explore_fragment_image_btn_right_best_destinations);

        btnLeftPopularTours.setOnClickListener(this);
        btnRightPopularTours.setOnClickListener(this);
        btnLeftNewOffersTours.setOnClickListener(this);
        btnRightNewOffersTours.setOnClickListener(this);
        btnLeftBestDestinations.setOnClickListener(this);
        btnRightBestDestinations.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
