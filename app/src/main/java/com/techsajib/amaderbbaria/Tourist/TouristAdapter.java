package com.techsajib.amaderbbaria.Tourist;

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

public class TouristAdapter extends RecyclerView.Adapter<TouristAdapter.TouristViewHolder>{

    private List<TouristModel> touristList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;
    }

    public TouristAdapter(List<TouristModel> touristList, Context mContext) {
        this.touristList = touristList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TouristViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tourist_main_page_row, parent, false);
        TouristViewHolder touristViewHolder = new TouristViewHolder(view);

        return touristViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TouristViewHolder holder, int position) {

        final TouristModel touristPosition = touristList.get(position);

        holder.authorName.setText("লেখক: " + touristPosition.getAuthorname());
        holder.postTitle.setText(touristPosition.getTitle());
        holder.postDescription.setText(touristPosition.getDescription());

        Picasso.get().load(touristPosition.getAuthoricon()).into(holder.authorPicture);
        Picasso.get().load(touristPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return touristList.size();
    }

    public class TouristViewHolder extends RecyclerView.ViewHolder{

        //for widgets
        ImageView imageURL, authorPicture;
        TextView postTitle, postDescription, authorName;

        public TouristViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.touristMainPageImageID);
            authorPicture = itemView.findViewById(R.id.touristAuthorPictureID);
            authorName = itemView.findViewById(R.id.touristAuthorNameID);
            postTitle = itemView.findViewById(R.id.touristTitleID);
            postDescription = itemView.findViewById(R.id.touristDescriptionID);

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
