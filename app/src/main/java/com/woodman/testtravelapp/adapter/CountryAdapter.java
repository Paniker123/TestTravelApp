package com.woodman.testtravelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.woodman.testtravelapp.CountryName;
import com.woodman.testtravelapp.R;
import com.woodman.testtravelapp.model.Country;

import java.util.List;

/**
 * Created by Zver on 15.03.2018.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private List<Country> countries;


    public CountryAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.county_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.textViewCountryName.setText(country.getName());
        if (country.getCountryName() == CountryName.UK) {
            holder.imageViewCountryImg.setBackgroundResource(R.drawable.british);
        }
        if (country.getCountryName() == CountryName.FRANCE) {
            holder.imageViewCountryImg.setBackgroundResource(R.drawable.franch);
        }
        if (country.getCountryName() == CountryName.UKRAINE) {
            holder.imageViewCountryImg.setBackgroundResource(R.drawable.ukrain);
        }
        if (country.getCountryName() == CountryName.USA) {
            holder.imageViewCountryImg.setBackgroundResource(R.drawable.usa);
        }
        if (country.getCountryName() == CountryName.GERMAN) {
            holder.imageViewCountryImg.setBackgroundResource(R.drawable.german);
        }
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewCountryImg;
        private TextView textViewCountryName;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewCountryImg = itemView.findViewById(R.id.image_view_country_img);
            textViewCountryName = itemView.findViewById(R.id.text_view_country_name);
        }
    }
}
