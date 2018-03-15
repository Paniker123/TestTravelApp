package com.woodman.testtravelapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.Ticket;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketPriceFragment extends Fragment implements View.OnClickListener{


    private static final String ARG_PARAM1 = "param1";
    private Ticket ticket;
    private SearchTravelFragment searchTravelFragment;

    private Button btnFindNow;

    public TicketPriceFragment() {
        // Required empty public constructor
    }

    public static TicketPriceFragment newInstance(Ticket ticket) {
        TicketPriceFragment fragment = new TicketPriceFragment();
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
        View view = inflater.inflate(R.layout.fragment_ticket_price, container, false);
        setActivityTitle();
        searchTravelFragment=new SearchTravelFragment();
        btnFindNow=view.findViewById(R.id.btn_find_now_fragment_ticket_price);



        btnFindNow.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btn_find_now_fragment_ticket_price:
                searchTravelFragment = SearchTravelFragment.newInstance(ticket);
                fragmentTransaction.replace(R.id.fragment_container, searchTravelFragment);
                fragmentTransaction.addToBackStack("Back to home");
                fragmentTransaction.commit();

                break;
        }
    }
}
