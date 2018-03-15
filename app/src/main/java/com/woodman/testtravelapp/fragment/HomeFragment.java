package com.woodman.testtravelapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.Ticket;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView textViewPlaneVidget;
    private TextView textViewTrainVidget;
    private TextView textViewCarVidget;

    private TicketFragment ticketFragment;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().setTitle(getString(R.string.title_home));
        textViewPlaneVidget = view.findViewById(R.id.text_view_plane_home_fragment);
        textViewTrainVidget = view.findViewById(R.id.text_view_train_home_fragment);
        textViewCarVidget = view.findViewById(R.id.text_view_car_home_fragment);
        ticketFragment = new TicketFragment();


        textViewPlaneVidget.setOnClickListener(this);
        textViewTrainVidget.setOnClickListener(this);
        textViewCarVidget.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.text_view_plane_home_fragment:
                ticketFragment = TicketFragment.newInstance(Ticket.PLAIN);
                fragmentTransaction.replace(R.id.fragment_container, ticketFragment);
                fragmentTransaction.addToBackStack("Back to home");
                fragmentTransaction.commit();
                break;
            case R.id.text_view_train_home_fragment:
              ;
                ticketFragment = TicketFragment.newInstance(Ticket.TRAIN);
                fragmentTransaction.replace(R.id.fragment_container, ticketFragment);
                fragmentTransaction.addToBackStack("Back to home");
                fragmentTransaction.commit();
                break;
            case R.id.text_view_car_home_fragment:

                ticketFragment = TicketFragment.newInstance(Ticket.CAR);
                fragmentTransaction.replace(R.id.fragment_container, ticketFragment);
                fragmentTransaction.addToBackStack("Back to home");
                fragmentTransaction.commit();
                break;
        }

    }
}
