package com.techsajib.amaderbbaria.Transportation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsajib.amaderbbaria.R;

import java.util.List;

public class TransportationAdapter extends RecyclerView.Adapter<TransportationAdapter.TransportationViewHolder>{

    private List<TransportationModel> transportationList;
    private Context mContext;

    public TransportationAdapter(List<TransportationModel> transportationList, Context mContext) {
        this.transportationList = transportationList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TransportationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transportation_main_page_row, parent, false);
        TransportationViewHolder transportationViewHolder = new TransportationViewHolder(view);
        return transportationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransportationViewHolder holder, int position) {

        final TransportationModel transportationPosition = transportationList.get(position);

        holder.titleText.setText(transportationPosition.getTitle());
        holder.detailsText.setText(transportationPosition.getDetails());

    }

    @Override
    public int getItemCount() {
        return transportationList.size();
    }

    public class TransportationViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, detailsText;

        public TransportationViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.transportationTitleID);
            detailsText = itemView.findViewById(R.id.transportationDescriptionID);
        }
    }
}
