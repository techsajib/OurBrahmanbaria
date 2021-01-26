package com.techsajib.amaderbbaria.Police;

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

public class PoliceAdapter extends RecyclerView.Adapter<PoliceAdapter.PoliceViewHolder>{

    private List<PoliceModel> policeList;
    private Context mContext;

    public PoliceAdapter(List<PoliceModel> policeList, Context mContext) {
        this.policeList = policeList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PoliceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.police_main_page_row, parent, false);
        PoliceViewHolder policeViewHolder = new PoliceViewHolder(view);
        return policeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PoliceViewHolder holder, int position) {

        final PoliceModel policePosition = policeList.get(position);

        holder.nameText.setText(" " + policePosition.getName());
        holder.titleText.setText(" " + policePosition.getTitle());
        holder.numberText.setText(" " + policePosition.getNumber());
        holder.emailText.setText(" " + policePosition.getEmail());
        holder.webText.setText(" " + policePosition.getWeb());
        holder.addressText.setText(" " + policePosition.getAddress());

        Picasso.get().load(policePosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return policeList.size();
    }

    public class PoliceViewHolder extends RecyclerView.ViewHolder{

        ImageView imageURL;
        TextView nameText, titleText, numberText, emailText, webText, addressText;

        public PoliceViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.policeImageID);
            nameText = itemView.findViewById(R.id.policeNameID);
            titleText = itemView.findViewById(R.id.policeTitleID);
            numberText = itemView.findViewById(R.id.policeNumberID);
            emailText = itemView.findViewById(R.id.policeEmailID);
            webText = itemView.findViewById(R.id.policeWebID);
            addressText = itemView.findViewById(R.id.policeAddressID);
        }
    }
}
