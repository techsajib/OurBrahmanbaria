package com.techsajib.amaderbbaria.FamousPeople;

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

public class FamousPeopleAdapter extends RecyclerView.Adapter<FamousPeopleAdapter.FamousPeopleViewHolder> {

    private List<FamousPeopleModel> famousPeopleList;
    private Context mContext;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;
    }

    public FamousPeopleAdapter(List<FamousPeopleModel> famousPeopleList, Context mContext) {
        this.famousPeopleList = famousPeopleList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FamousPeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.famous_people_main_page_row, parent, false);
        FamousPeopleViewHolder famousPeopleViewHolder = new FamousPeopleViewHolder(view);

        return famousPeopleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FamousPeopleViewHolder holder, int position) {

        final FamousPeopleModel famousPeoplePosition = famousPeopleList.get(position);

        holder.postTitle.setText(famousPeoplePosition.getTitle());
        holder.postDescription.setText(famousPeoplePosition.getDetails());
        holder.authorName.setText("লেখক: " + famousPeoplePosition.getAuthorname());


        Picasso.get().load(famousPeoplePosition.getAuthorpicture()).into(holder.authorPicture);
        Picasso.get().load(famousPeoplePosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return famousPeopleList.size();
    }


    public class FamousPeopleViewHolder extends RecyclerView.ViewHolder {

        //for widgets
        ImageView imageURL, authorPicture;
        TextView postTitle, postDescription, authorName;


        public FamousPeopleViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.FamousPeopleMainPageImageID);
            postTitle = itemView.findViewById(R.id.famousPeopleTitleID);
            postDescription = itemView.findViewById(R.id.famousPeopleDescriptionID);
            authorName = itemView.findViewById(R.id.famousPeopleAuthorNameID);
            authorPicture = itemView.findViewById(R.id.famousPeopleAuthorPictureID);

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
