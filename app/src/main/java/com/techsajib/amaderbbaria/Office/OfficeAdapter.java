package com.techsajib.amaderbbaria.Office;

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

public class OfficeAdapter extends RecyclerView.Adapter<OfficeAdapter.OfficeViewHolder>{

    private List<OfficeModel> officeList;
    private Context mContext;

    public OfficeAdapter(List<OfficeModel> officeList, Context mContext) {
        this.officeList = officeList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OfficeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.office_main_page_row, parent, false);
        OfficeViewHolder officeViewHolder = new OfficeViewHolder(view);
        return officeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OfficeViewHolder holder, int position) {

        final OfficeModel officePosition = officeList.get(position);

        holder.nameText.setText(" " + officePosition.getName());
        holder.numberText.setText(" " + officePosition.getNumber());
        holder.emailText.setText(" " + officePosition.getEmail());
        holder.webText.setText(" " + officePosition.getWeb());
        holder.addressText.setText(" " + officePosition.getAddress());

        Picasso.get().load(officePosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return officeList.size();
    }

    public class OfficeViewHolder extends RecyclerView.ViewHolder {

        ImageView imageURL;
        TextView nameText, numberText, emailText, webText, addressText;

        public OfficeViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.officeMainPageImageID);
            nameText = itemView.findViewById(R.id.officeNameTitleID);
            numberText = itemView.findViewById(R.id.officeNumberID);
            emailText = itemView.findViewById(R.id.officeEmailID);
            webText = itemView.findViewById(R.id.officeWebID);
            addressText = itemView.findViewById(R.id.officeAddressID);

        }
    }
}
