package com.woodman.testtravelapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.woodman.testtravelapp.DataBase.HotelDataBase;
import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.Ticket;
import com.woodman.testtravelapp.adapter.ToursAdapter;
import com.woodman.testtravelapp.model.Hotel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchTravelFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private Ticket ticket;
    private Button btnEditSearch;
    private ToursAdapter adapter;
    private RecyclerView recyclerViewTours;

    private HotelDataBase hotelDataBase;
    private List<Hotel> hotels;

    private TicketFragment ticketFragment;


    public SearchTravelFragment() {
        // Required empty public constructor
    }

    public static SearchTravelFragment newInstance(Ticket ticket) {
        SearchTravelFragment fragment = new SearchTravelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, ticket.name());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ticket = Ticket.valueOf(getArguments().getString(ARG_PARAM1));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_travel, container, false);
        setActivityTitle();
        hotelDataBase = new HotelDataBase();
        hotels = hotelDataBase.getAllHotels();
        btnEditSearch = view.findViewById(R.id.btn_edit_search);
        recyclerViewTours = view.findViewById(R.id.recyclerView_tours);
        adapter = new ToursAdapter(hotels);
        ticketFragment=new TicketFragment();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerViewTours.setLayoutManager(linearLayoutManager);
        recyclerViewTours.setAdapter(adapter);
        btnEditSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                ticketFragment = TicketFragment.newInstance(ticket);
                fragmentTransaction.replace(R.id.fragment_container, ticketFragment);
                fragmentTransaction.addToBackStack("Back to home");
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void setActivityTitle() {
        if (ticket == Ticket.TRAIN) {
            getActivity().setTitle(getString(R.string.title_train_result_fragment));
        }
        if (ticket == Ticket.PLAIN) {
            getActivity().setTitle(getString(R.string.title_plane_result_fragment));
        }
        if (ticket == Ticket.CAR) {
            getActivity().setTitle(getString(R.string.title_car_result_fragment));
        }

    }

}
