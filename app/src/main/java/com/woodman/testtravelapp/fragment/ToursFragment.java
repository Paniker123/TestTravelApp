package com.woodman.testtravelapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.woodman.testtravelapp.DataBase.CountryDataBase;
import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.adapter.CountryAdapter;
import com.woodman.testtravelapp.model.Country;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ToursFragment extends Fragment {
    private List<Country> countries;
    private CountryAdapter countryAdapter;
    private RecyclerView recyclerViewContry;
    private EditText editTextSearch;
    private CountryDataBase countryDataBase;

    public ToursFragment() {
        // Required empty public constructor
    }

    public static ToursFragment newInstance() {
        ToursFragment toursFragment = new ToursFragment();
        Bundle args = new Bundle();
        toursFragment.setArguments(args);
        return toursFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tours, container, false);
        getActivity().setTitle(getString(R.string.fragment_title_tours));
        recyclerViewContry=view.findViewById(R.id.recyclerView_country);
        editTextSearch=view.findViewById(R.id.edit_text_search_country);
        countryDataBase=new CountryDataBase();
        countries=countryDataBase.getAllContry();
        countryAdapter=new CountryAdapter(countries);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerViewContry.setLayoutManager(linearLayoutManager);
        recyclerViewContry.setAdapter(countryAdapter);
        return view;
    }

}
