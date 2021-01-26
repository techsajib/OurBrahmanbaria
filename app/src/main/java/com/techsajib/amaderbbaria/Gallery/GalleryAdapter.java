package com.techsajib.amaderbbaria.Gallery;

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

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{

    private List<GalleryModel> galleryList;
    private Context mContext;

    public GalleryAdapter(List<GalleryModel> galleryList, Context mContext) {
        this.galleryList = galleryList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_main_page_row, parent, false);
        GalleryViewHolder galleryViewHolder = new GalleryViewHolder(view);
        return galleryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {

        final GalleryModel galleryPosition = galleryList.get(position);

        holder.authorNameText.setText(" " + galleryPosition.getAuthorname());
        holder.locationText.setText(" " + galleryPosition.getLocation());
        holder.detailsText.setText(galleryPosition.getDetails());

        Picasso.get().load(galleryPosition.getUrl()).into(holder.imageURL);
        Picasso.get().load(galleryPosition.getAuthoricon()).into(holder.authorIcon);

    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL, authorIcon;
        TextView authorNameText, locationText, detailsText;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.galleryMainPageImageID);
            authorIcon = itemView.findViewById(R.id.galleryAuthorIconID);
            authorNameText = itemView.findViewById(R.id.galleryAuthorNameID);
            locationText = itemView.findViewById(R.id.galleryAddressID);
            detailsText = itemView.findViewById(R.id.galleryDescriptionID);

        }
    }
}
