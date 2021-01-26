package com.techsajib.amaderbbaria.Leader;

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

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.LeaderViewHolder> {

    private List<LeaderModel> leaderList;
    private Context mContext;

    public LeaderAdapter(List<LeaderModel> leaderList, Context mContext) {
        this.leaderList = leaderList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_main_page_row, parent, false);
        LeaderViewHolder leaderViewHolder = new LeaderViewHolder(view);

        return leaderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderViewHolder holder, int position) {

        final LeaderModel leaderPosition = leaderList.get(position);

        holder.mayorText.setText("মেয়র: " + leaderPosition.getMayor());
        holder.chairmanText.setText("চেয়ারম্যান: " + leaderPosition.getChairman());
        holder.viceChairmanText.setText("ভাইস-চেয়ারম্যান: " + leaderPosition.getVicechairman());
        holder.womenViceChairmanText.setText("মহিলা ভাইস-চেয়ারম্যান: " + leaderPosition.getWomenchairman());

        Picasso.get().load(leaderPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return leaderList.size();
    }

    public class LeaderViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL;
        TextView mayorText, chairmanText, viceChairmanText, womenViceChairmanText;


        public LeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.leaderMainPageImageID);
            mayorText = itemView.findViewById(R.id.mayorNameID);
            chairmanText = itemView.findViewById(R.id.chairmanNameID);
            viceChairmanText = itemView.findViewById(R.id.viceChairmanNameID);
            womenViceChairmanText = itemView.findViewById(R.id.womenViceChairmanNameID);
        }
    }


}
