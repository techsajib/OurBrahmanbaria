package com.techsajib.amaderbbaria.Zila;

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

public class ZilaAdapter extends RecyclerView.Adapter<ZilaAdapter.ZilaViewHolder>{

    private List<ZilaModel> zilaList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;
    }


    public ZilaAdapter(List<ZilaModel> zilaList, Context mContext) {
        this.zilaList = zilaList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ZilaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zila_main_page_row, parent, false);
        ZilaViewHolder zilaViewHolder = new ZilaViewHolder(view);
        return zilaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ZilaViewHolder holder, int position) {

        final ZilaModel zilaPosition = zilaList.get(position);

        holder.postTitle.setText(zilaPosition.getTitle());
        holder.postDescription.setText(zilaPosition.getDetails());

        Picasso.get().load(zilaPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return zilaList.size();
    }

    public class ZilaViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL;
        TextView postTitle, postDescription;

        public ZilaViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.zilaMainPageImageID);
            postTitle = itemView.findViewById(R.id.zilaTitleID);
            postDescription = itemView.findViewById(R.id.zilaDescriptionID);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListener != null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
