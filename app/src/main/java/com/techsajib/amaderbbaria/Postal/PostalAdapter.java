package com.techsajib.amaderbbaria.Postal;


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

public class PostalAdapter extends RecyclerView.Adapter<PostalAdapter.PostalViewHolder>{

    private List<PostalModel> postalList;
    private Context mContext;

    public PostalAdapter(List<PostalModel> postalList, Context mContext) {
        this.postalList = postalList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PostalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postal_main_page_row, parent, false);
        PostalViewHolder postalViewHolder = new PostalViewHolder(view);
        return postalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostalViewHolder holder, int position) {

        final PostalModel postalPosition = postalList.get(position);

        holder.postTitle.setText(postalPosition.getTitle());
        holder.postDescription.setText(postalPosition.getDetails());

        Picasso.get().load(postalPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return postalList.size();
    }

    public class PostalViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL;
        TextView postTitle, postDescription;

        public PostalViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.postalMainPageImageID);
            postTitle = itemView.findViewById(R.id.postalTitleID);
            postDescription = itemView.findViewById(R.id.postalDescriptionID);

        }
    }
}
