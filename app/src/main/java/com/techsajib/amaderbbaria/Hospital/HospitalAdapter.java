package com.techsajib.amaderbbaria.Hospital;

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

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>{

    private List<HospitalModel> hospitalList;
    private Context mContext;

    public HospitalAdapter(List<HospitalModel> hospitalList, Context mContext) {
        this.hospitalList = hospitalList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_main_page_row, parent, false);
        HospitalViewHolder hospitalViewHolder = new HospitalViewHolder(view);

        return hospitalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {

        final HospitalModel hospitalPosition = hospitalList.get(position);

        holder.nameText.setText(" " + hospitalPosition.getName());
        holder.typeText.setText(" ধরন: " + hospitalPosition.getType());
        holder.directorText.setText(" " + hospitalPosition.getDirector());
        holder.seatText.setText(" " + hospitalPosition.getSeat());
        holder.doctorText.setText(" " + hospitalPosition.getDoctor());
        holder.numberText.setText(" " + hospitalPosition.getNumber());
        holder.emailText.setText(" " + hospitalPosition.getEmail());
        holder.addressText.setText(" " + hospitalPosition.getAddress());
        holder.detailsText.setText(hospitalPosition.getDetails());

        Picasso.get().load(hospitalPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public class HospitalViewHolder extends RecyclerView.ViewHolder{

        ImageView imageURL;
        TextView nameText, typeText, directorText, seatText, doctorText,  numberText, emailText, addressText, detailsText;

        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.hospitalMainPageImageID);
            nameText = itemView.findViewById(R.id.hospitalNameTitleID);
            typeText = itemView.findViewById(R.id.hospitalTypeID);
            directorText = itemView.findViewById(R.id.hospitalDirectorID);
            seatText = itemView.findViewById(R.id.hospitalSeatID);
            doctorText = itemView.findViewById(R.id.hospitalDoctorListID);
            numberText = itemView.findViewById(R.id.hospitalNumberID);
            emailText = itemView.findViewById(R.id.hospitalEmailID);
            addressText = itemView.findViewById(R.id.hospitalAddressID);
            detailsText = itemView.findViewById(R.id.hospitalDescriptionID);
        }
    }
}
