package com.techsajib.amaderbbaria.Library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsajib.amaderbbaria.R;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder>{

    private List<LibraryModel> libraryList;
    private Context mContext;

    public LibraryAdapter(List<LibraryModel> libraryList, Context mContext) {
        this.libraryList = libraryList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_main_page_row, parent, false);
        LibraryViewHolder libraryViewHolder = new LibraryViewHolder(view);
        return libraryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {

        final LibraryModel libraryPosition = libraryList.get(position);

        holder.nameText.setText(" " + libraryPosition.getName());
        holder.establishText.setText(" " + libraryPosition.getEstablish());
        holder.bookText.setText(" " + libraryPosition.getBook());
        holder.memberText.setText(" " + libraryPosition.getMember());
        holder.librarianText.setText(" " + libraryPosition.getLibrarian());
        holder.numberText.setText(" " + libraryPosition.getNumber());
        holder.locationText.setText(" " + libraryPosition.getLocation());

    }

    @Override
    public int getItemCount() {
        return libraryList.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder {

        TextView nameText, establishText, bookText, memberText, librarianText, numberText, locationText;

        public LibraryViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.libraryNameID);
            establishText = itemView.findViewById(R.id.libraryEstablishID);
            bookText = itemView.findViewById(R.id.libraryBookID);
            memberText = itemView.findViewById(R.id.libraryMemberID);
            librarianText = itemView.findViewById(R.id.libraryLibrarianID);
            numberText = itemView.findViewById(R.id.libraryNumberID);
            locationText = itemView.findViewById(R.id.libraryLocationID);
        }
    }
}
