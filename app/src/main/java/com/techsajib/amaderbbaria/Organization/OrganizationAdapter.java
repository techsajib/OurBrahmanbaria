package com.techsajib.amaderbbaria.Organization;

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

public class OrganizationAdapter extends RecyclerView.Adapter<OrganizationAdapter.OrganizationViewHolder>{

    private List<OrganizationModel> organizationList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;
    }

    public OrganizationAdapter(List<OrganizationModel> organizationList, Context mContext) {
        this.organizationList = organizationList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public OrganizationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.organization_main_page_row, parent, false);
        OrganizationViewHolder organizationViewHolder = new OrganizationViewHolder(view);
        return organizationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrganizationViewHolder holder, int position) {

        final OrganizationModel organizationPosition = organizationList.get(position);

        holder.postTitle.setText(organizationPosition.getTitle());
        holder.postDescription.setText(organizationPosition.getDetails());

        Picasso.get().load(organizationPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return organizationList.size();
    }

    public class OrganizationViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL;
        TextView postTitle, postDescription;

        public OrganizationViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.organizationMainPageImageID);
            postTitle = itemView.findViewById(R.id.organizationTitleID);
            postDescription = itemView.findViewById(R.id.organizationDescriptionID);

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
