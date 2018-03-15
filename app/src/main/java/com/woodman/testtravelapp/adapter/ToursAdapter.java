package com.woodman.testtravelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.model.Hotel;

import java.util.List;

/**
 * Created by Zver on 15.03.2018.
 */

public class ToursAdapter extends RecyclerView.Adapter<ToursAdapter.ViewHolder> {

    private List<Hotel> tourList;

    public ToursAdapter(List<Hotel> tourList) {
        this.tourList = tourList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hotel hotel=tourList.get(position);
        holder.textViewHotelName.setText(hotel.getName());
        holder.textViewHotelLocation.setText(hotel.getPlace());
        holder.textViewHotelPrice.setText(String.valueOf(hotel.getPrice())+" $");

    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewHotelPhoto;
        ImageView imageViewFavoriteIndicator;
        TextView textViewHotelName;
        TextView textViewHotelLocation;
        TextView textViewHotelPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewHotelPhoto=itemView.findViewById(R.id.image_view_hotel_photo);
            imageViewFavoriteIndicator=itemView.findViewById(R.id.image_view_favorite_indicator);
            textViewHotelName=itemView.findViewById(R.id.text_view_hotel_name);
            textViewHotelLocation=itemView.findViewById(R.id.text_view_hotel_location);
            textViewHotelPrice=itemView.findViewById(R.id.text_view_hotel_price);
        }
    }
}
