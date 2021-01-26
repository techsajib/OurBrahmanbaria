package com.techsajib.amaderbbaria.Education;

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

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.EducationViewHolder>{

    private List<EducationModel> eduInstituteList;
    private Context mContext;

    public EducationAdapter(List<EducationModel> eduInstituteList, Context mContext) {
        this.eduInstituteList = eduInstituteList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_main_page_row, parent, false);
        EducationViewHolder educationViewHolder = new EducationViewHolder(view);

        return educationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EducationViewHolder holder, int position) {

        final EducationModel educationPosition = eduInstituteList.get(position);

        holder.nameText.setText(" " + educationPosition.getName());
        holder.establishText.setText(" স্থাপন: " + educationPosition.getEstablish());
        holder.principalText.setText(" " + educationPosition.getPrincipal());
        holder.typeText.setText(" ধরন: " + educationPosition.getType());
        holder.studentText.setText(" শিক্ষার্থী: " + educationPosition.getStudent());
        holder.mobileText.setText(" " + educationPosition.getMobile());
        holder.emailText.setText(" " + educationPosition.getEmail());
        holder.webText.setText(" " + educationPosition.getWeb());
        holder.addressText.setText(" " + educationPosition.getAddress());

        Picasso.get().load(educationPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return eduInstituteList.size();
    }

    public class EducationViewHolder extends RecyclerView.ViewHolder {

        ImageView imageURL;
        TextView nameText, establishText, principalText, typeText, studentText, mobileText, emailText, webText, addressText;

        public EducationViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.educationMainPageImageID);
            nameText = itemView.findViewById(R.id.educationNameTitleID);
            establishText = itemView.findViewById(R.id.educationEstablishedID);
            principalText = itemView.findViewById(R.id.educationPrincipalID);
            typeText = itemView.findViewById(R.id.educationTypeID);
            studentText = itemView.findViewById(R.id.educationStudentID);
            mobileText = itemView.findViewById(R.id.educationNumberID);
            emailText = itemView.findViewById(R.id.educationEmailID);
            webText = itemView.findViewById(R.id.educationWebID);
            addressText = itemView.findViewById(R.id.educationAddressID);

        }
    }

}
