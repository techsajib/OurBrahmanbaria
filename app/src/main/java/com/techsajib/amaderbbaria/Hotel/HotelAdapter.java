package com.techsajib.amaderbbaria.Hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.techsajib.amaderbbaria.R;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder>{

    private List<HotelModel> hotelList;
    private Context mContext;

    public HotelAdapter(List<HotelModel> hotelList, Context mContext) {
        this.hotelList = hotelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_main_page_row, parent, false);
        HotelViewHolder hotelViewHolder = new HotelViewHolder(view);
        return hotelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {

        final HotelModel hotelPosition = hotelList.get(position);

        holder.nameText.setText(" " + hotelPosition.getName());
        holder.typeText.setText(" ধরন: " + hotelPosition.getType());
        holder.directorText.setText(" পরিচালক: " + hotelPosition.getDirector());
        holder.numberText.setText(" " + hotelPosition.getNumber());
        holder.addressText.setText(" " + hotelPosition.getAddress());
        holder.serviceText.setText(" " + hotelPosition.getService());

        Picasso.get().load(hotelPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder {

        ImageView imageURL;
        TextView nameText, typeText, directorText, numberText, addressText, serviceText;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.hotelMainPageImageID);
            nameText = itemView.findViewById(R.id.hotelNameTitleID);
            typeText = itemView.findViewById(R.id.hotelTypeID);
            directorText = itemView.findViewById(R.id.hotelDirectorID);
            numberText = itemView.findViewById(R.id.hotelNumberID);
            addressText = itemView.findViewById(R.id.hotelAddressID);
            serviceText = itemView.findViewById(R.id.hotelServiceID);
        }
    }
}
