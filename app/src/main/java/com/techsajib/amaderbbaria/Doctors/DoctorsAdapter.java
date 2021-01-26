package com.techsajib.amaderbbaria.Doctors;

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

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.DoctorsViewHolder>{

    //list initialization
    private List<DoctorsModel> doctorsList;
    //context initialization
    private Context mContext;

    public DoctorsAdapter(List<DoctorsModel> doctorsList, Context mContext) {
        this.doctorsList = doctorsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DoctorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_main_page_row, parent, false);
        DoctorsViewHolder doctorsViewHolder = new DoctorsViewHolder(view);

        return doctorsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsViewHolder holder, int position) {

        final DoctorsModel doctorsPosition = doctorsList.get(position);

        holder.nameText.setText(" " + doctorsPosition.getName());
        holder.titleText.setText(" " + doctorsPosition.getTitle());
        holder.specialistText.setText(" বিশেষজ্ঞ: " + doctorsPosition.getSpecialist());
        holder.chamberText.setText(" চেম্বার: " + doctorsPosition.getChamber());
        holder.timeText.setText(" " + doctorsPosition.getTime());
        holder.numberText.setText(" সিরিয়াল: " + doctorsPosition.getNumber());
        holder.addressText.setText(" " + doctorsPosition.getAddress());

        Picasso.get().load(doctorsPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class DoctorsViewHolder extends RecyclerView.ViewHolder{

        ImageView imageURL;
        TextView nameText, titleText, specialistText, chamberText, timeText, numberText, addressText;

        public DoctorsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.doctorsImageID);
            nameText = itemView.findViewById(R.id.doctorsNameID);
            titleText = itemView.findViewById(R.id.doctorsTitleID);
            specialistText = itemView.findViewById(R.id.doctorsSpecialistID);
            chamberText = itemView.findViewById(R.id.doctorsChamberID);
            timeText = itemView.findViewById(R.id.doctorsTimeID);
            numberText = itemView.findViewById(R.id.doctorsNumberID);
            addressText = itemView.findViewById(R.id.doctorsAddressID);


        }
    }
}
