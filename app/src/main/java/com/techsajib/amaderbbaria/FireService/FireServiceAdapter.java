package com.techsajib.amaderbbaria.FireService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsajib.amaderbbaria.R;

import java.util.List;

public class FireServiceAdapter extends RecyclerView.Adapter<FireServiceAdapter.FireserviceViewHolder>{

    //list initialization
    private List<FireServiceModel> fireServiceList;
    //context initialization
    private Context mContext;

    public FireServiceAdapter(List<FireServiceModel> fireServiceList, Context mContext) {
        this.fireServiceList = fireServiceList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FireserviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fireservice_main_page_row, parent, false);
        FireserviceViewHolder fireserviceViewHolder = new FireserviceViewHolder(view);

        return fireserviceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FireserviceViewHolder holder, int position) {

        final FireServiceModel fireServicePosition = fireServiceList.get(position);

        holder.nameText.setText(" " + fireServicePosition.getName());
        holder.numberText.setText(" " + fireServicePosition.getNumber());
        holder.timeText.setText(" " + fireServicePosition.getTime());
        holder.webText.setText(" " + fireServicePosition.getWeb());
        holder.addressText.setText(" " + fireServicePosition.getAddress());
        holder.serviceText.setText(" " + fireServicePosition.getService());
    }

    @Override
    public int getItemCount() {
        return fireServiceList.size();
    }

    public class FireserviceViewHolder extends RecyclerView.ViewHolder{

        TextView nameText, numberText, timeText, webText, addressText, serviceText;

        public FireserviceViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.fireserviceNameID);
            numberText = itemView.findViewById(R.id.fireServiceNumberID);
            timeText = itemView.findViewById(R.id.fireServiceTimeID);
            webText = itemView.findViewById(R.id.fireServiceWebID);
            addressText = itemView.findViewById(R.id.fireServiceAddressID);
            serviceText = itemView.findViewById(R.id.fireServiceServiceID);
        }
    }
}
