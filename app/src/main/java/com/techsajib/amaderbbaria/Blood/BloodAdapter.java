package com.techsajib.amaderbbaria.Blood;

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

public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.BloodViewHolder>{

    private List<BloodModel> bloodList;
    private Context mContext;

    public BloodAdapter(List<BloodModel> bloodList, Context mContext) {
        this.bloodList = bloodList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public BloodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blood_main_page_row, parent, false);
        BloodViewHolder bloodViewHolder = new BloodViewHolder(view);
        return bloodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BloodViewHolder holder, int position) {

        final BloodModel bloodPosition = bloodList.get(position);

        holder.emergencyText.setText(" রক্তের অবস্থা: " + bloodPosition.getEmergency());
        holder.detailsText.setText(bloodPosition.getDetails());
        holder.nameText.setText(" " + bloodPosition.getName());
        holder.numberText.setText(" " + bloodPosition.getNumber());
        holder.bloodgroupText.setText(" রক্তের গ্রুপ: " + bloodPosition.getBloodgroup());
        holder.locationText.setText(" " + bloodPosition.getLocation());

        Picasso.get().load(bloodPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return bloodList.size();
    }

    public class BloodViewHolder extends RecyclerView.ViewHolder {

        ImageView imageURL;
        TextView emergencyText, detailsText, nameText, numberText, bloodgroupText, locationText;

        public BloodViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.bloodMainPageImageID);
            emergencyText = itemView.findViewById(R.id.bloodEmergencyID);
            detailsText = itemView.findViewById(R.id.bloodDetailsID);
            nameText = itemView.findViewById(R.id.bloodNameTitleID);
            numberText = itemView.findViewById(R.id.bloodNumberID);
            bloodgroupText = itemView.findViewById(R.id.bloodGroupID);
            locationText = itemView.findViewById(R.id.bloodLocationID);

        }
    }
}
