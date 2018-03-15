package com.woodman.testtravelapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.Ticket;


/**
 * A simple {@link Fragment} subclass.
 */
public class TicketFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private Ticket ticket;
    private ImageView imageViewTicketHeaderIcon;
    private Button btnSearchTicket;

    private TicketPriceFragment ticketPriceFragment;


    public TicketFragment() {
        // Required empty public constructor
    }

    public static TicketFragment newInstance(Ticket ticket) {
        TicketFragment fragment = new TicketFragment();
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
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);
        ticketPriceFragment = new TicketPriceFragment();
        imageViewTicketHeaderIcon = view.findViewById(R.id.image_view_ticket_header_icon);
        btnSearchTicket = view.findViewById(R.id.btn_search_ticket_fragment);
        getCustomStyle(ticket, imageViewTicketHeaderIcon, btnSearchTicket);
        btnSearchTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                ticketPriceFragment = TicketPriceFragment.newInstance(ticket);
                fragmentTransaction.replace(R.id.fragment_container, ticketPriceFragment);
                fragmentTransaction.addToBackStack("Back to ticket fragment");
                fragmentTransaction.commit();
            }
        });
        return view;
    }

    private void getCustomStyle(Ticket ticket, ImageView imageView, Button button) {
        if (ticket == Ticket.PLAIN) {
            imageView.setImageResource(R.drawable.ic_plane);
            button.setText(getString(R.string.btn_search_flights));
            getActivity().setTitle(getString(R.string.title_plane_ticket_fragment));
            return;
        }
        if (ticket == Ticket.TRAIN) {
            getActivity().setTitle(getString(R.string.title_train_ticket_fragment));
            imageView.setImageResource(R.drawable.ic_train);
            button.setText(getString(R.string.btn_search_trains));
            return;
        }
        if (ticket == Ticket.CAR) {
            getActivity().setTitle(getString(R.string.title_car_ticket_fragment));
            imageView.setImageResource(R.drawable.ic_car);
            button.setText(getString(R.string.btn_search_cars));
            return;
        }
    }
}
