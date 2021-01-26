package com.techsajib.amaderbbaria.MP;

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

public class MPAdapter extends RecyclerView.Adapter<MPAdapter.MPViewHolder> {

    private List<MPModel> mpList;
    private Context mContext;

    public MPAdapter(List<MPModel> mpList, Context mContext) {
        this.mpList = mpList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mp_main_page_row, parent, false);
        MPViewHolder mpViewHolder = new MPViewHolder(view);

        return mpViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MPViewHolder holder, int position) {

        final MPModel mpPosition = mpList.get(position);

        holder.areaView.setText(mpPosition.getArea());
        holder.nameView.setText(mpPosition.getName());
        holder.titleView.setText(mpPosition.getTitle());
        holder.partyView.setText(mpPosition.getParty());
        holder.upozilaView.setText(mpPosition.getUpozila());
        holder.descriptionView.setText(mpPosition.getDes());

        Picasso.get().load(mpPosition.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mpList.size();
    }

    public class MPViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageView;
        TextView areaView, nameView, titleView, upozilaView, partyView, descriptionView;

        public MPViewHolder(@NonNull View itemView) {
            super(itemView);

            areaView = itemView.findViewById(R.id.mpAreaID);
            imageView = itemView.findViewById(R.id.mpImageID);
            nameView = itemView.findViewById(R.id.mpNameID);
            titleView = itemView.findViewById(R.id.mpTitleID);
            upozilaView = itemView.findViewById(R.id.mpUpozilaID);
            partyView = itemView.findViewById(R.id.mpPartyID);
            descriptionView = itemView.findViewById(R.id.mpDesID);

        }
    }
}

