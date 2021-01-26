package com.techsajib.amaderbbaria.Newspaper;

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

public class NewspaperAdapter extends RecyclerView.Adapter<NewspaperAdapter.NewspaperViewHolder>{

    private List<NewspaperModel> newspaperList;
    private Context mContext;

    public NewspaperAdapter(List<NewspaperModel> newspaperList, Context mContext) {
        this.newspaperList = newspaperList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NewspaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newspaper_main_page_row, parent, false);
        NewspaperViewHolder newspaperViewHolder = new NewspaperViewHolder(view);
        return newspaperViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewspaperViewHolder holder, int position) {

        final NewspaperModel newspaperPosition = newspaperList.get(position);

        holder.nameText.setText(" " + newspaperPosition.getName());
        holder.versionText.setText(" ভার্সন: " + newspaperPosition.getVersion());
        holder.editorText.setText(" সম্পাদক: " + newspaperPosition.getEditor());
        holder.numberText.setText(" " + newspaperPosition.getNumber());
        holder.emailText.setText(" " + newspaperPosition.getEmail());
        holder.webText.setText(" " + newspaperPosition.getWeb());
        holder.addressText.setText(" অফিস: " + newspaperPosition.getAddress());

        Picasso.get().load(newspaperPosition.getUrl()).into(holder.imageURL);

    }

    @Override
    public int getItemCount() {
        return newspaperList.size();
    }

    public class NewspaperViewHolder extends RecyclerView.ViewHolder {

        ImageView imageURL;
        TextView nameText, versionText, editorText, numberText, emailText, webText, addressText;

        public NewspaperViewHolder(@NonNull View itemView) {
            super(itemView);

            imageURL = itemView.findViewById(R.id.newspaperMainPageImageID);
            nameText = itemView.findViewById(R.id.newspaperNameTitleID);
            versionText = itemView.findViewById(R.id.newspaperVersionID);
            editorText = itemView.findViewById(R.id.newspaperEditorID);
            numberText = itemView.findViewById(R.id.newspaperNumberID);
            emailText = itemView.findViewById(R.id.newspaperEmailID);
            webText = itemView.findViewById(R.id.newspaperWebID);
            addressText = itemView.findViewById(R.id.newspaperAddressID);

        }
    }
}
