package com.techsajib.amaderbbaria.Upozila;

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

public class UpozilaAdapter extends RecyclerView.Adapter<UpozilaAdapter.UpozilaViewHolder>{

    private List<UpozilaModel> upozilaList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;
    }

    public UpozilaAdapter(List<UpozilaModel> upozilaList, Context mContext) {
        this.upozilaList = upozilaList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public UpozilaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upozila_main_page_row, parent, false);
        UpozilaViewHolder upozilaViewHolder = new UpozilaViewHolder(view);
        return upozilaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpozilaViewHolder holder, int position) {

        final UpozilaModel upozilaPostion = upozilaList.get(position);

        holder.postTitle.setText(upozilaPostion.getTitle());
        holder.postDescription.setText(upozilaPostion.getDetails());

        Picasso.get().load(upozilaPostion.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return upozilaList.size();
    }

    public class UpozilaViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL;
        TextView postTitle, postDescription;

        public UpozilaViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.upozilaMainPageImageID);
            postTitle = itemView.findViewById(R.id.upozilaTitleID);
            postDescription = itemView.findViewById(R.id.upozilaDescriptionID);

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
